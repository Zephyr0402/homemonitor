// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TemperatureMsg.proto

package protos;

public interface TemperatureMsgOrBuilder extends
    // @@protoc_insertion_point(interface_extends:intelligence.TemperatureMsg)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>float temperatureLevel = 1;</code>
   * @return The temperatureLevel.
   */
  float getTemperatureLevel();

  /**
   * <code>float humidityLevel = 2;</code>
   * @return The humidityLevel.
   */
  float getHumidityLevel();

  /**
   * <code>int32 metricType = 3;</code>
   * @return The metricType.
   */
  int getMetricType();
}
