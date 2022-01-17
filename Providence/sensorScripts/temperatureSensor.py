import Adafruit_DHT

DHT_SENSOR = Adafruit_DHT.DHT22
DHT_PIN = 4

humidity, temperature = Adafruit_DHT.read_retry(DHT_SENSOR, DHT_PIN)

if humidity is not None and temperature is not None:
    print("{0:0.1f}\n{1:0.1f}".format(temperature, humidity))
else:
    print("Failed to retrieve data from humidity sensor")