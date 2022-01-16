package sensor;

public class TemperatureSensor {
    private float temperature;
    private float humidity;
    private String metric;

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public TemperatureSensor(float temp, float humid, String metric) {
        this.temperature = temp;
        this.humidity = humid;
        this.metric = metric;
    }
}
