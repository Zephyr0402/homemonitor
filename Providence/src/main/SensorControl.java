package main;

import Sensor.TemperatureSensor;

public class SensorControl {
    public static TemperatureSensor getTemperatureSensorData() {
        return new TemperatureSensor(10, (float) 0.2, "C");
    }
}
