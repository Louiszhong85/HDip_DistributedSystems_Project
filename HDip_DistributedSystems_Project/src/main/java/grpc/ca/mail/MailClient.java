package grpc.ca.mail;

import com.google.gson.Gson;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.net.ssl.SSLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class MailClient {

    private final ManagedChannel channel;
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;
    private final UserServiceGrpc.UserServiceStub asyncStub;

    public MailClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = UserServiceGrpc.newBlockingStub(channel);
        asyncStub = UserServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public String staffMail(String username) {
        ArrayList<String> strings = new ArrayList<>();
        staffMailRequest request = staffMailRequest.newBuilder().setUsername(username).build();
        Iterator<staffMailResponse> iterator = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).staffMail(request);
        while (iterator.hasNext()) {
             strings.add(iterator.next().getResponseMessage());
        }
        Gson gson = new Gson();
        return gson.toJson(strings);
    }

    public String staffAgenda(String username) throws InterruptedException {
        CountDownLatch finishLatch = new CountDownLatch(1);
        ArrayList<String> responseStr = new ArrayList<>();
        Gson gson = new Gson();
        StreamObserver<agendaRequest> requestObserver = asyncStub.withDeadlineAfter(5, TimeUnit.SECONDS)
                .staffAgenda(new StreamObserver<agendaResponse>() {
                    @Override
                    public void onNext(agendaResponse response) {
                        responseStr.add(response.getResponseMessage());
                    }

                    @Override
                    public void onError(Throwable t) {
                        responseStr.add(t.getMessage());
                        finishLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        finishLatch.countDown();
                    }
                });

        agendaRequest request = agendaRequest.newBuilder().setUsername(username).build();
        requestObserver.onNext(request);

        requestObserver.onCompleted();
        finishLatch.await(1, TimeUnit.MINUTES);
        return gson.toJson(responseStr);
    }

    public static void main(String[] args) throws InterruptedException, SSLException {
        MailClient client = new MailClient("127.0.0.1", 10085);

        try {
            String aaa = client.staffMail("Enda");
            System.out.println(aaa);
        } finally {
            client.shutdown();
        }
    }
}
