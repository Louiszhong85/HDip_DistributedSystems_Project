package grpc.ca.loginService;

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
    comments = "Source: staffLoginService.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ca.loginService.LoginRequest,
      grpc.ca.loginService.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = grpc.ca.loginService.LoginRequest.class,
      responseType = grpc.ca.loginService.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.loginService.LoginRequest,
      grpc.ca.loginService.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<grpc.ca.loginService.LoginRequest, grpc.ca.loginService.LoginResponse> getLoginMethod;
    if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
          UserServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.loginService.LoginRequest, grpc.ca.loginService.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.loginService.LogoutRequest,
      grpc.ca.loginService.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = grpc.ca.loginService.LogoutRequest.class,
      responseType = grpc.ca.loginService.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.loginService.LogoutRequest,
      grpc.ca.loginService.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<grpc.ca.loginService.LogoutRequest, grpc.ca.loginService.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = UserServiceGrpc.getLogoutMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLogoutMethod = UserServiceGrpc.getLogoutMethod) == null) {
          UserServiceGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.loginService.LogoutRequest, grpc.ca.loginService.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.loginService.CheckinRequest,
      grpc.ca.loginService.LogoutResponse> getCheckinMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkin",
      requestType = grpc.ca.loginService.CheckinRequest.class,
      responseType = grpc.ca.loginService.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.loginService.CheckinRequest,
      grpc.ca.loginService.LogoutResponse> getCheckinMethod() {
    io.grpc.MethodDescriptor<grpc.ca.loginService.CheckinRequest, grpc.ca.loginService.LogoutResponse> getCheckinMethod;
    if ((getCheckinMethod = UserServiceGrpc.getCheckinMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCheckinMethod = UserServiceGrpc.getCheckinMethod) == null) {
          UserServiceGrpc.getCheckinMethod = getCheckinMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.loginService.CheckinRequest, grpc.ca.loginService.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "checkin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.CheckinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("checkin"))
                  .build();
          }
        }
     }
     return getCheckinMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ca.loginService.CheckoutRequest,
      grpc.ca.loginService.CheckoutResponse> getCheckoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkout",
      requestType = grpc.ca.loginService.CheckoutRequest.class,
      responseType = grpc.ca.loginService.CheckoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ca.loginService.CheckoutRequest,
      grpc.ca.loginService.CheckoutResponse> getCheckoutMethod() {
    io.grpc.MethodDescriptor<grpc.ca.loginService.CheckoutRequest, grpc.ca.loginService.CheckoutResponse> getCheckoutMethod;
    if ((getCheckoutMethod = UserServiceGrpc.getCheckoutMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCheckoutMethod = UserServiceGrpc.getCheckoutMethod) == null) {
          UserServiceGrpc.getCheckoutMethod = getCheckoutMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.loginService.CheckoutRequest, grpc.ca.loginService.CheckoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "checkout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.CheckoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.loginService.CheckoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("checkout"))
                  .build();
          }
        }
     }
     return getCheckoutMethod;
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
     */
    public void login(grpc.ca.loginService.LoginRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(grpc.ca.loginService.LogoutRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    /**
     */
    public void checkin(grpc.ca.loginService.CheckinRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckinMethod(), responseObserver);
    }

    /**
     */
    public void checkout(grpc.ca.loginService.CheckoutRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.CheckoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.loginService.LoginRequest,
                grpc.ca.loginService.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.loginService.LogoutRequest,
                grpc.ca.loginService.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .addMethod(
            getCheckinMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.loginService.CheckinRequest,
                grpc.ca.loginService.LogoutResponse>(
                  this, METHODID_CHECKIN)))
          .addMethod(
            getCheckoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ca.loginService.CheckoutRequest,
                grpc.ca.loginService.CheckoutResponse>(
                  this, METHODID_CHECKOUT)))
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
     */
    public void login(grpc.ca.loginService.LoginRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(grpc.ca.loginService.LogoutRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkin(grpc.ca.loginService.CheckinRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckinMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkout(grpc.ca.loginService.CheckoutRequest request,
        io.grpc.stub.StreamObserver<grpc.ca.loginService.CheckoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckoutMethod(), getCallOptions()), request, responseObserver);
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
     */
    public grpc.ca.loginService.LoginResponse login(grpc.ca.loginService.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ca.loginService.LogoutResponse logout(grpc.ca.loginService.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ca.loginService.LogoutResponse checkin(grpc.ca.loginService.CheckinRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckinMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ca.loginService.CheckoutResponse checkout(grpc.ca.loginService.CheckoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckoutMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.loginService.LoginResponse> login(
        grpc.ca.loginService.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.loginService.LogoutResponse> logout(
        grpc.ca.loginService.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.loginService.LogoutResponse> checkin(
        grpc.ca.loginService.CheckinRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckinMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ca.loginService.CheckoutResponse> checkout(
        grpc.ca.loginService.CheckoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;
  private static final int METHODID_CHECKIN = 2;
  private static final int METHODID_CHECKOUT = 3;

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
        case METHODID_LOGIN:
          serviceImpl.login((grpc.ca.loginService.LoginRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.loginService.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((grpc.ca.loginService.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.loginService.LogoutResponse>) responseObserver);
          break;
        case METHODID_CHECKIN:
          serviceImpl.checkin((grpc.ca.loginService.CheckinRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.loginService.LogoutResponse>) responseObserver);
          break;
        case METHODID_CHECKOUT:
          serviceImpl.checkout((grpc.ca.loginService.CheckoutRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ca.loginService.CheckoutResponse>) responseObserver);
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ca.loginService.UserServiceImpl.getDescriptor();
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
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .addMethod(getCheckinMethod())
              .addMethod(getCheckoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
