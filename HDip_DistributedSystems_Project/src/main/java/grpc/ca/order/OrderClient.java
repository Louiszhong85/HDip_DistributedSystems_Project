package grpc.ca.order;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.stub.StreamObserver;

import javax.net.ssl.SSLException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderClient {
    private static final Logger logger = Logger.getLogger(OrderClient.class.getName());

    private final ManagedChannel channel;
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;
    private final UserServiceGrpc.UserServiceStub asyncStub;

    public OrderClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        blockingStub = UserServiceGrpc.newBlockingStub(channel);
        asyncStub = UserServiceGrpc.newStub(channel);
    }

    public OrderClient(String host, int port, SslContext sslContext) {
        channel = NettyChannelBuilder.forAddress(host, port)
                .sslContext(sslContext)
                .build();

        blockingStub = UserServiceGrpc.newBlockingStub(channel);
        asyncStub = UserServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void queryOrders() {
        orderQueryRequest request = orderQueryRequest.newBuilder().build();
        orderQueryResponse response = orderQueryResponse.getDefaultInstance();

        try {
            response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).orderQuery(request);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }

        logger.info("query orders: " + response.getResponseMessage());
    }

    public void updateOrder(int[] orderIds, float[] prices) throws InterruptedException {
        CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<orderUpdateRequest> requestObserver = asyncStub.withDeadlineAfter(5, TimeUnit.SECONDS)
                .orderEdit(new StreamObserver<orderUpdateResponse>() {
                    @Override
                    public void onNext(orderUpdateResponse response) {
                        logger.info("response message = " + response.getResponseMessage());
                    }

                    @Override
                    public void onError(Throwable t) {
                        logger.log(Level.SEVERE, "rate laptop failed: " + t.getMessage());
                        finishLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        logger.info("rate laptop completed");
                        finishLatch.countDown();
                    }
                });

        int n = orderIds.length;
        try {
            for (int i = 0; i < n; i++) {
                orderUpdateRequest request = orderUpdateRequest.newBuilder()
                        .setOrderId(orderIds[i])
                        .setPrice(prices[i])
                        .build();
                requestObserver.onNext(request);
                logger.info("update order id = " + request.getOrderId() + ", price = " + request.getPrice());
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "unexpected error: " + e.getMessage());
            requestObserver.onError(e);
            return;
        }

        requestObserver.onCompleted();
        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            logger.warning("request cannot finish within 1 minute");
        }
    }

    public static void testQueryOrder(OrderClient client) throws InterruptedException {
        client.queryOrders();
    }

    public static void testUpdateOrder(OrderClient client) throws InterruptedException {
        int[] ids = {1,2};
        float[] price = {8.9f, 2.2f};
        client.updateOrder(ids, price);
    }

    public static void main(String[] args) throws InterruptedException, SSLException {
        OrderClient client = new OrderClient("0.0.0.0", 50053);

        try {
            testQueryOrder(client);
        } finally {
            client.shutdown();
        }
    }
}


