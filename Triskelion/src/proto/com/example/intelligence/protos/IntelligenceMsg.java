// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IntelligenceMsg.proto

package com.example.intelligence.protos;

/**
 * Protobuf type {@code intelligence.IntelligenceMsg}
 */
public final class IntelligenceMsg extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:intelligence.IntelligenceMsg)
    IntelligenceMsgOrBuilder {
private static final long serialVersionUID = 0L;
  // Use IntelligenceMsg.newBuilder() to construct.
  private IntelligenceMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private IntelligenceMsg() {
    messageID_ = com.google.protobuf.ByteString.EMPTY;
    payload_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new IntelligenceMsg();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private IntelligenceMsg(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {

            messageID_ = input.readBytes();
            break;
          }
          case 18: {

            payload_ = input.readBytes();
            break;
          }
          case 25: {

            checkSum_ = input.readFixed64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.intelligence.protos.IntelligenceProtos.internal_static_intelligence_IntelligenceMsg_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.intelligence.protos.IntelligenceProtos.internal_static_intelligence_IntelligenceMsg_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.intelligence.protos.IntelligenceMsg.class, com.example.intelligence.protos.IntelligenceMsg.Builder.class);
  }

  public static final int MESSAGEID_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString messageID_;
  /**
   * <code>bytes messageID = 1;</code>
   * @return The messageID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getMessageID() {
    return messageID_;
  }

  public static final int PAYLOAD_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString payload_;
  /**
   * <code>bytes payload = 2;</code>
   * @return The payload.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getPayload() {
    return payload_;
  }

  public static final int CHECKSUM_FIELD_NUMBER = 3;
  private long checkSum_;
  /**
   * <code>fixed64 checkSum = 3;</code>
   * @return The checkSum.
   */
  @java.lang.Override
  public long getCheckSum() {
    return checkSum_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!messageID_.isEmpty()) {
      output.writeBytes(1, messageID_);
    }
    if (!payload_.isEmpty()) {
      output.writeBytes(2, payload_);
    }
    if (checkSum_ != 0L) {
      output.writeFixed64(3, checkSum_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!messageID_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, messageID_);
    }
    if (!payload_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, payload_);
    }
    if (checkSum_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(3, checkSum_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.intelligence.protos.IntelligenceMsg)) {
      return super.equals(obj);
    }
    com.example.intelligence.protos.IntelligenceMsg other = (com.example.intelligence.protos.IntelligenceMsg) obj;

    if (!getMessageID()
        .equals(other.getMessageID())) return false;
    if (!getPayload()
        .equals(other.getPayload())) return false;
    if (getCheckSum()
        != other.getCheckSum()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MESSAGEID_FIELD_NUMBER;
    hash = (53 * hash) + getMessageID().hashCode();
    hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
    hash = (53 * hash) + getPayload().hashCode();
    hash = (37 * hash) + CHECKSUM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCheckSum());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.intelligence.protos.IntelligenceMsg parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.intelligence.protos.IntelligenceMsg prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code intelligence.IntelligenceMsg}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:intelligence.IntelligenceMsg)
      com.example.intelligence.protos.IntelligenceMsgOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.intelligence.protos.IntelligenceProtos.internal_static_intelligence_IntelligenceMsg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.intelligence.protos.IntelligenceProtos.internal_static_intelligence_IntelligenceMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.intelligence.protos.IntelligenceMsg.class, com.example.intelligence.protos.IntelligenceMsg.Builder.class);
    }

    // Construct using com.example.intelligence.protos.IntelligenceMsg.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      messageID_ = com.google.protobuf.ByteString.EMPTY;

      payload_ = com.google.protobuf.ByteString.EMPTY;

      checkSum_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.intelligence.protos.IntelligenceProtos.internal_static_intelligence_IntelligenceMsg_descriptor;
    }

    @java.lang.Override
    public com.example.intelligence.protos.IntelligenceMsg getDefaultInstanceForType() {
      return com.example.intelligence.protos.IntelligenceMsg.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.intelligence.protos.IntelligenceMsg build() {
      com.example.intelligence.protos.IntelligenceMsg result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.intelligence.protos.IntelligenceMsg buildPartial() {
      com.example.intelligence.protos.IntelligenceMsg result = new com.example.intelligence.protos.IntelligenceMsg(this);
      result.messageID_ = messageID_;
      result.payload_ = payload_;
      result.checkSum_ = checkSum_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.intelligence.protos.IntelligenceMsg) {
        return mergeFrom((com.example.intelligence.protos.IntelligenceMsg)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.intelligence.protos.IntelligenceMsg other) {
      if (other == com.example.intelligence.protos.IntelligenceMsg.getDefaultInstance()) return this;
      if (other.getMessageID() != com.google.protobuf.ByteString.EMPTY) {
        setMessageID(other.getMessageID());
      }
      if (other.getPayload() != com.google.protobuf.ByteString.EMPTY) {
        setPayload(other.getPayload());
      }
      if (other.getCheckSum() != 0L) {
        setCheckSum(other.getCheckSum());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.intelligence.protos.IntelligenceMsg parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.intelligence.protos.IntelligenceMsg) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString messageID_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes messageID = 1;</code>
     * @return The messageID.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getMessageID() {
      return messageID_;
    }
    /**
     * <code>bytes messageID = 1;</code>
     * @param value The messageID to set.
     * @return This builder for chaining.
     */
    public Builder setMessageID(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      messageID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes messageID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessageID() {
      
      messageID_ = getDefaultInstance().getMessageID();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes payload = 2;</code>
     * @return The payload.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getPayload() {
      return payload_;
    }
    /**
     * <code>bytes payload = 2;</code>
     * @param value The payload to set.
     * @return This builder for chaining.
     */
    public Builder setPayload(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      payload_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes payload = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPayload() {
      
      payload_ = getDefaultInstance().getPayload();
      onChanged();
      return this;
    }

    private long checkSum_ ;
    /**
     * <code>fixed64 checkSum = 3;</code>
     * @return The checkSum.
     */
    @java.lang.Override
    public long getCheckSum() {
      return checkSum_;
    }
    /**
     * <code>fixed64 checkSum = 3;</code>
     * @param value The checkSum to set.
     * @return This builder for chaining.
     */
    public Builder setCheckSum(long value) {
      
      checkSum_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>fixed64 checkSum = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCheckSum() {
      
      checkSum_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:intelligence.IntelligenceMsg)
  }

  // @@protoc_insertion_point(class_scope:intelligence.IntelligenceMsg)
  private static final com.example.intelligence.protos.IntelligenceMsg DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.intelligence.protos.IntelligenceMsg();
  }

  public static com.example.intelligence.protos.IntelligenceMsg getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<IntelligenceMsg>
      PARSER = new com.google.protobuf.AbstractParser<IntelligenceMsg>() {
    @java.lang.Override
    public IntelligenceMsg parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new IntelligenceMsg(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<IntelligenceMsg> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<IntelligenceMsg> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.intelligence.protos.IntelligenceMsg getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

