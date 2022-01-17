package main;

import com.google.common.flogger.FluentLogger;
import sensor.TemperatureSensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SensorControl {
    private static int degree = 0;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static TemperatureSensor getTemperatureSensorData() {
        try {
            Process p = Runtime.getRuntime().exec("python3 ~/sensorScripts/temperatureSensor.py");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String temperature, humidity;
            temperature = br.readLine();
            humidity = br.readLine();
            return new TemperatureSensor(Float.parseFloat(temperature), Float.parseFloat(humidity), "C");
        } catch (IOException e) {
            logger.atInfo().withCause(e).log("error running temperature sensor script!");
            return null;
        }
    }
}
