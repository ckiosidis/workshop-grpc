// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services.proto

package grpc.workshop.services;

public final class Protos {
  private Protos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ListTransactionsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ListTransactionsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ListTransactionsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ListTransactionsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Transaction_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Transaction_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016services.proto\032\037google/protobuf/timest" +
      "amp.proto\"\031\n\027ListTransactionsRequest\">\n\030" +
      "ListTransactionsResponse\022\"\n\014transactions" +
      "\030\001 \003(\0132\014.Transaction\"X\n\013Transaction\022\n\n\002i" +
      "d\030\001 \001(\t\022\016\n\006amount\030\002 \001(\001\022-\n\ttimestamp\030\003 \001" +
      "(\0132\032.google.protobuf.Timestamp2]\n\022Transa" +
      "ctionService\022G\n\020ListTransactions\022\030.ListT" +
      "ransactionsRequest\032\031.ListTransactionsRes" +
      "ponseB)\n\026grpc.workshop.servicesB\006ProtosP" +
      "\001Z\005protob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_ListTransactionsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ListTransactionsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ListTransactionsRequest_descriptor,
        new java.lang.String[] { });
    internal_static_ListTransactionsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ListTransactionsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ListTransactionsResponse_descriptor,
        new java.lang.String[] { "Transactions", });
    internal_static_Transaction_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Transaction_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Transaction_descriptor,
        new java.lang.String[] { "Id", "Amount", "Timestamp", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
