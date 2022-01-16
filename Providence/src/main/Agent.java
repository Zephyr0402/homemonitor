package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Objects;
import java.util.UUID;

import sensor.TemperatureSensor;
import com.google.common.flogger.FluentLogger;
import com.google.protobuf.ByteString;
import org.json.JSONObject;
import org.json.JSONTokener;
import protos.IntelligenceMsg;
import protos.SensorMsg;
import protos.TemperatureMsg;
import toolbox.Toolbox;

public class Agent extends Thread {
    private DatagramSocket socket;
    private String triskelionAddress;
    private String triskelionPort;
    private String providencePort;
    private byte[] buf = new byte[512];
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public Agent() throws SocketException {
        super();
        providencePort = "9999";
        String locationFile = "./location.json";
        try {
            InputStream is = new FileInputStream(locationFile);
            JSONTokener token = new JSONTokener(is);
            JSONObject obj = new JSONObject(token);
            triskelionAddress = obj.getString("triskelionAddress");
            triskelionPort = obj.getString("triskelionPort");
            providencePort = obj.getString("providencePort");
            is.close();
        } catch (FileNotFoundException e) {
            logger.atInfo().withCause(e).log("Location file not found!");
        } catch (IOException e) {
            logger.atInfo().withCause(e).log("InputStream closing error!");
        }
        socket = new DatagramSocket(Integer.parseInt(providencePort));
    }

    /**
     * Sending sensor data to Triskelion
     */
    public void run() {
        while(true) {
            // sending UDP packets
            sendTemperatureSensorData();
            try {
                sleep(5 * 1000);
            } catch (InterruptedException e) {
                logger.atInfo().withCause(e).log("Sleep 5 seconds failed");
            }
        }
    }

    private void sendTemperatureSensorData() {
        try {
            // set temperature message
            TemperatureSensor s = SensorControl.getTemperatureSensorData();
            TemperatureMsg.Builder tempMsg = TemperatureMsg.newBuilder();
            tempMsg.setTemperatureLevel(s.getTemperature());
            tempMsg.setHumidityLevel(s.getHumidity());
            if (Objects.equals(s.getMetric(), "C")) {
                tempMsg.setMetricType(1);
            } else {
                tempMsg.setMetricType(2);
            }
            // set sensor message
            SensorMsg.Builder sMsg = SensorMsg.newBuilder();
            sMsg.setDataType(0x01);
            sMsg.setCommand(0x01);
            sMsg.setData(tempMsg.build().toByteString());
            // set intelligence message
            UUID uuid = UUID.randomUUID();
            byte[] payload = sMsg.build().toByteArray();
            IntelligenceMsg.Builder intelMsg = IntelligenceMsg.newBuilder();
            intelMsg.setMessageID(ByteString.copyFrom(uuid.toString().getBytes()));
            intelMsg.setCheckSum(Toolbox.getCRC32Checksum(payload));
            intelMsg.setPayload(ByteString.copyFrom(payload));
            intelMsg.setPayloadType(0x01);
            buf = intelMsg.build().toByteArray();
            logger.atInfo().log("Sending bytes: %s", buf);
            IntelligenceMsg test = IntelligenceMsg.parseFrom(buf);
            logger.atInfo().log("TEST! %s", buf);
            logger.atInfo().log("TEST! Before build message id %s", intelMsg.getMessageID());
            logger.atInfo().log("TEST! After build message id %s", test.getMessageID());
            // send packet
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(this.triskelionAddress), Integer.parseInt(this.triskelionPort));
            this.socket.send(packet);
            logger.atInfo().log("Sent one temperature packet, packet size %d", buf.length);
        } catch (Exception e) {
            logger.atInfo().withCause(e).log("Send temperature sensor data failed!");
        }
    }
}
