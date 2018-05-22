package grpc.workshop.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: services.proto")
public final class TransactionServiceGrpc {

  private TransactionServiceGrpc() {}

  public static final String SERVICE_NAME = "TransactionService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTransactionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<grpc.workshop.services.ListTransactionsRequest,
      grpc.workshop.services.ListTransactionsResponse> METHOD_LIST_TRANSACTIONS = getListTransactionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<grpc.workshop.services.ListTransactionsRequest,
      grpc.workshop.services.ListTransactionsResponse> getListTransactionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<grpc.workshop.services.ListTransactionsRequest,
      grpc.workshop.services.ListTransactionsResponse> getListTransactionsMethod() {
    return getListTransactionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<grpc.workshop.services.ListTransactionsRequest,
      grpc.workshop.services.ListTransactionsResponse> getListTransactionsMethodHelper() {
    io.grpc.MethodDescriptor<grpc.workshop.services.ListTransactionsRequest, grpc.workshop.services.ListTransactionsResponse> getListTransactionsMethod;
    if ((getListTransactionsMethod = TransactionServiceGrpc.getListTransactionsMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getListTransactionsMethod = TransactionServiceGrpc.getListTransactionsMethod) == null) {
          TransactionServiceGrpc.getListTransactionsMethod = getListTransactionsMethod = 
              io.grpc.MethodDescriptor.<grpc.workshop.services.ListTransactionsRequest, grpc.workshop.services.ListTransactionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TransactionService", "ListTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.workshop.services.ListTransactionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.workshop.services.ListTransactionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("ListTransactions"))
                  .build();
          }
        }
     }
     return getListTransactionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransactionServiceStub newStub(io.grpc.Channel channel) {
    return new TransactionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransactionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransactionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransactionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransactionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TransactionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void listTransactions(grpc.workshop.services.ListTransactionsRequest request,
        io.grpc.stub.StreamObserver<grpc.workshop.services.ListTransactionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTransactionsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListTransactionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.workshop.services.ListTransactionsRequest,
                grpc.workshop.services.ListTransactionsResponse>(
                  this, METHODID_LIST_TRANSACTIONS)))
          .build();
    }
  }

  /**
   */
  public static final class TransactionServiceStub extends io.grpc.stub.AbstractStub<TransactionServiceStub> {
    private TransactionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceStub(channel, callOptions);
    }

    /**
     */
    public void listTransactions(grpc.workshop.services.ListTransactionsRequest request,
        io.grpc.stub.StreamObserver<grpc.workshop.services.ListTransactionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransactionsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransactionServiceBlockingStub extends io.grpc.stub.AbstractStub<TransactionServiceBlockingStub> {
    private TransactionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.workshop.services.ListTransactionsResponse listTransactions(grpc.workshop.services.ListTransactionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransactionsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransactionServiceFutureStub extends io.grpc.stub.AbstractStub<TransactionServiceFutureStub> {
    private TransactionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.workshop.services.ListTransactionsResponse> listTransactions(
        grpc.workshop.services.ListTransactionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransactionsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TRANSACTIONS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransactionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransactionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_TRANSACTIONS:
          serviceImpl.listTransactions((grpc.workshop.services.ListTransactionsRequest) request,
              (io.grpc.stub.StreamObserver<grpc.workshop.services.ListTransactionsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransactionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.workshop.services.Protos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransactionService");
    }
  }

  private static final class TransactionServiceFileDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier {
    TransactionServiceFileDescriptorSupplier() {}
  }

  private static final class TransactionServiceMethodDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransactionServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TransactionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransactionServiceFileDescriptorSupplier())
              .addMethod(getListTransactionsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
