package main;

import com.google.common.flogger.FluentLogger;
import com.google.protobuf.InvalidProtocolBufferException;
import sensor.TemperatureSensor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import protos.*;
import toolbox.*;

/**
 * Agent is a thread that handle all incoming message sent by Providence and Lighthouse*/
public class Agent extends Thread {
    private Vault vault;
    private DatagramSocket socket;
    private boolean running;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public Agent(Vault v) throws SocketException {
        socket = new DatagramSocket(Integer.parseInt(Slingshot.getTriskelionPort()));
        vault = v;
    }

    /**
     * Listening IntelligenceMsg packets while running thread
     */
    public void run() {
        running = true;
        while(running) {
            // Receive UDP packets
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
                logger.atInfo().log("Packet received with size: %d", packet.getLength());
            } catch (IOException e) {
                logger.atInfo().withCause(e).log("Packet receiving failed!");
                continue;
            }
            byte[] recvBuf = Toolbox.getSmallerByteArray(packet.getData(), packet.getLength());
            // Convert to intelligence message
            IntelligenceMsg intelMsg = null;
            try {
                intelMsg = IntelligenceMsg.parseFrom(recvBuf);
                logger.atInfo().log("Intelligence message received with messageID: %s", intelMsg.getMessageID());
            } catch (InvalidProtocolBufferException e) {
                logger.atInfo().withCause(e).log("Intelligence message parsing error!");
                continue;
            }
            // Checksum
            assert intelMsg != null;
            byte[] payload = intelMsg.getPayload().toByteArray();
            if (intelMsg.getCheckSum() != Toolbox.getCRC32Checksum(payload)) {
                logger.atInfo().log("Intelligence message payload did not pass checksum!");
                continue;
            }
            handleIntelMsg(intelMsg.getPayloadType(), payload);
        }
        socket.close();
    }

    /**
     * Handle raspberry PI sensor data
     * @param data
     * @return
     */
    private void handleSensorMsg(byte[] data) {
        SensorMsg sensorMsg;
        try {
            sensorMsg = SensorMsg.parseFrom(data);
            logger.atInfo().log("Sensor message received with data type: %d", sensorMsg.getDataType());
        } catch (InvalidProtocolBufferException e) {
            logger.atInfo().withCause(e).log("Get sensor data failed!");
            return;
        }
        switch (sensorMsg.getDataType()) {
            case 0x01:
                TemperatureSensor s = getTemperatureData(sensorMsg.getData().toByteArray());
                if (s != null && storeTemperatureData(s)) {
                    logger.atInfo().log("Temperature data is stored successfully");
                } else {
                    logger.atInfo().log("Store temperature data failed!");
                }
                break;
            default:
                break;
        }
    }

    /**
     * Handle Intelligence message payload
     * @param payload
     * @return
     */
    public boolean handleIntelMsg(int payloadType, byte[] payload) {
        logger.atInfo().log("Payload type is %d", payloadType);
        // Parse payload
        switch (payloadType) {
            // Sensor Message
            case 0x01:
                try {
                    handleSensorMsg(payload);
                } catch (Exception e) {
                    logger.atInfo().withCause(e).log("Handle sensor data failed!");
                }

            case 0x02:
            default:
                break;
        }
        return true;
    }

    /**
     * Store temperature sensor data to local mongodb
     * @param tempSensor
     * @return
     */
    private boolean storeTemperatureData(TemperatureSensor tempSensor) {
        return vault.storeTemperatureData(tempSensor);
    }

    /**
     * Read temperature sensor data from IntelligenceMsg payload, return temperature class
     * @param payload
     * @return
     */
    private TemperatureSensor getTemperatureData(byte[] payload) {
        try {
            TemperatureMsg tempMsg = TemperatureMsg.parseFrom(payload);
            String metric = "C";
            if (tempMsg.getMetricType() != 1) {
                metric = "F";
            }
            return new TemperatureSensor(tempMsg.getTemperatureLevel(), tempMsg.getHumidityLevel(), metric);
        } catch (InvalidProtocolBufferException e) {
            logger.atInfo().withCause(e).log("Get temperature data failed!");
            return null;
        }

    }
}
