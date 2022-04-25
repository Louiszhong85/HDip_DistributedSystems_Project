package grpc.ca.mail;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: staffEmailService.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ca.mail.staffMailRequest,
      grpc.ca.mail.staffMailResponse> getStaffMailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "staffMail",
      requestType = grpc.ca.mail.staffMailRequest.class,
      responseType = grpc.ca.mail.staffMailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ca.mail.staffMailRequest,
      grpc.ca.mail.staffMailResponse> getStaffMailMethod() {
    io.grpc.MethodDescriptor<grpc.ca.mail.staffMailRequest, grpc.ca.mail.staffMailResponse> getStaffMailMethod;
    if ((getStaffMailMethod = UserServiceGrpc.getStaffMailMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getStaffMailMethod = UserServiceGrpc.getStaffMailMethod) == null) {
          UserServiceGrpc.getStaffMailMethod = getStaffMailMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.mail.staffMailRequest, grpc.ca.mail.staffMailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "staffMail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.mail.staffMailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.mail.staffMailResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("staffMail"))
                  .build();
          }
        }
     }
     return getStaffMailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.mail.containsString,
      grpc.ca.mail.containsString> getStaffAgendaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "staffAgenda",
      requestType = grpc.ca.mail.containsString.class,
      responseType = grpc.ca.mail.containsString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ca.mail.containsString,
      grpc.ca.mail.containsString> getStaffAgendaMethod() {
    io.grpc.MethodDescriptor<grpc.ca.mail.containsString, grpc.ca.mail.containsString> getStaffAgendaMethod;
    if ((getStaffAgendaMethod = UserServiceGrpc.getStaffAgendaMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getStaffAgendaMethod = UserServiceGrpc.getStaffAgendaMethod) == null) {
          UserServiceGrpc.getStaffAgendaMethod = getStaffAgendaMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.mail.containsString, grpc.ca.mail.containsString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "staffAgenda"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.mail.containsString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.mail.containsString.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("staffAgenda"))
                  .build();
          }
        }
     }
     return getStaffAgendaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void staffMail(grpc.ca.mail.staffMailRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.mail.staffMailResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStaffMailMethod(), responseObserver);
    }

    /**
     * <pre>
     *client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.ca.mail.containsString> staffAgenda(
        io.grpc.stub.StreamObserver<grpc.ca.mail.containsString> responseObserver) {
      return asyncUnimplementedStreamingCall(getStaffAgendaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStaffMailMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.ca.mail.staffMailRequest,
                grpc.ca.mail.staffMailResponse>(
                  this, METHODID_STAFF_MAIL)))
          .addMethod(
            getStaffAgendaMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.ca.mail.containsString,
                grpc.ca.mail.containsString>(
                  this, METHODID_STAFF_AGENDA)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void staffMail(grpc.ca.mail.staffMailRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.mail.staffMailResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStaffMailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.ca.mail.containsString> staffAgenda(
        io.grpc.stub.StreamObserver<grpc.ca.mail.containsString> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStaffAgendaMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public java.util.Iterator<grpc.ca.mail.staffMailResponse> staffMail(
        grpc.ca.mail.staffMailRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStaffMailMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STAFF_MAIL = 0;
  private static final int METHODID_STAFF_AGENDA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STAFF_MAIL:
          serviceImpl.staffMail((grpc.ca.mail.staffMailRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.mail.staffMailResponse>) responseObserver);
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
        case METHODID_STAFF_AGENDA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.staffAgenda(
              (io.grpc.stub.StreamObserver<grpc.ca.mail.containsString>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ca.mail.StaffMailImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getStaffMailMethod())
              .addMethod(getStaffAgendaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
