// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IntelligenceMsg.proto

package protos;

public final class IntelligenceProtos {
  private IntelligenceProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_intelligence_IntelligenceMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_intelligence_IntelligenceMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025IntelligenceMsg.proto\022\014intelligence\"\210\001" +
      "\n\017IntelligenceMsg\022\021\n\tmessageID\030\001 \001(\014\022\017\n\007" +
      "payload\030\002 \001(\014\022\023\n\013payloadType\030\003 \001(\005\022\020\n\010ch" +
      "eckSum\030\004 \001(\006\022\031\n\014serialNumber\030\005 \001(\005H\000\210\001\001B" +
      "\017\n\r_serialNumberB\036\n\006protosB\022Intelligence" +
      "ProtosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_intelligence_IntelligenceMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_intelligence_IntelligenceMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_intelligence_IntelligenceMsg_descriptor,
        new java.lang.String[] { "MessageID", "Payload", "PayloadType", "CheckSum", "SerialNumber", "SerialNumber", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
