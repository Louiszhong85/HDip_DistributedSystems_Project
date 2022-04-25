package grpc.ca.order;

import com.google.gson.Gson;
import grpc.ca.order.store.Order;
import grpc.ca.order.store.OrderStore;
import grpc.ca.order.store.OrderStoreImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;


public class OrderServer {
    private static final Logger logger = Logger.getLogger(OrderServer.class.getName());

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        OrderServer ourServer = new OrderServer();
        ourServer.start();
    }

    // start
    private void start() throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        System.out.println("Starting gRPC Server!!!!!");
        int port = 50053;

        server = ServerBuilder.forPort(port).addService(new OrderServerImpl()).build().start();
        System.out.println("Server Running on Port: " + port);

        server.awaitTermination();
    }

    //Extend abstract base class for our own implementation
    static class OrderServerImpl extends UserServiceGrpc.UserServiceImplBase {

        private OrderStore orderStore;

        public OrderServerImpl() {
            this.orderStore = new OrderStoreImpl();
        }

        @Override
        public void orderQuery(orderQueryRequest request, StreamObserver<orderQueryResponse> responseObserver) {
            Gson gson = new Gson();
            orderQueryResponse response = orderQueryResponse.newBuilder()
                    .setResponseMessage(gson.toJson(orderStore.queryOrders()))
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<orderUpdateRequest> orderEdit(StreamObserver<orderUpdateResponse> responseObserver) {
            return new StreamObserver<orderUpdateRequest>() {
                @Override
                public void onNext(orderUpdateRequest request) {
                    int orderId = request.getOrderId();
                    float price = request.getPrice();
                    if (orderId == 0) {
                        responseObserver.onError(
                                Status.INVALID_ARGUMENT.withDescription("orderId doesn't in request body").asRuntimeException()
                        );
                        return;
                    }

                    if (price == 0) {
                        responseObserver.onError(
                                Status.INVALID_ARGUMENT.withDescription("price don't can set zero").asRuntimeException()
                        );
                        return;
                    }

                    Order order = orderStore.getByOrderId(orderId);
                    if (order == null) {
                        responseObserver.onError(
                                Status.NOT_FOUND.withDescription("order doesn't found").asRuntimeException()
                        );
                        return;
                    }

                    logger.info("update price:" + price);

                    // update
                    orderStore.updateOrder(orderId, price);

                    orderUpdateResponse response = orderUpdateResponse.newBuilder()
                            .setResponseMessage("update " + order.getOrderName() + "success!")
                            .build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    logger.warning(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}

