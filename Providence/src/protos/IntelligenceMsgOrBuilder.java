// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IntelligenceMsg.proto

package protos;

public interface IntelligenceMsgOrBuilder extends
    // @@protoc_insertion_point(interface_extends:intelligence.IntelligenceMsg)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes messageID = 1;</code>
   * @return The messageID.
   */
  com.google.protobuf.ByteString getMessageID();

  /**
   * <code>bytes payload = 2;</code>
   * @return The payload.
   */
  com.google.protobuf.ByteString getPayload();

  /**
   * <code>int32 payloadType = 3;</code>
   * @return The payloadType.
   */
  int getPayloadType();

  /**
   * <code>fixed64 checkSum = 4;</code>
   * @return The checkSum.
   */
  long getCheckSum();

  /**
   * <code>optional int32 serialNumber = 5;</code>
   * @return Whether the serialNumber field is set.
   */
  boolean hasSerialNumber();
  /**
   * <code>optional int32 serialNumber = 5;</code>
   * @return The serialNumber.
   */
  int getSerialNumber();
}
