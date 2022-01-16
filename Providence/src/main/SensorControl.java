package main;

import sensor.TemperatureSensor;

public class SensorControl {
    private static int degree = 0;

    public static TemperatureSensor getTemperatureSensorData() {
        if (degree > 50) {
            degree = 0;
        }
        degree++;
        return new TemperatureSensor(degree, (float) 0.2, "C");
    }
}
