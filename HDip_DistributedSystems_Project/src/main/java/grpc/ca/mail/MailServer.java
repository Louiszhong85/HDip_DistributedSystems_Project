package grpc.ca.mail;

import java.io.IOException;

import grpc.ca.server1.JMDNS.JmdnsRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class MailServer extends UserServiceGrpc.UserServiceImplBase {

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        MailServer ourServer = new MailServer();
        ourServer.start();
    }

    private void start() throws IOException, InterruptedException {
        int port = 10085;
        String service_name = "mailServer";
        JmdnsRegistration registration = new JmdnsRegistration();
        registration.run(port, service_name);

        server = ServerBuilder.forPort(port).addService(this).build().start();
        System.out.println("Server Running on Port: " + port);

        server.awaitTermination();
    }

    @Override
    public void staffMail(staffMailRequest request, StreamObserver<staffMailResponse> responseObserver) {
        System.out.println("Inside UserService::Logout()");
        String username = request.getUsername();

        staffMailResponse.Builder response = staffMailResponse.newBuilder();
        System.out.println("Logging out username = " + username);

        if (username.equals("Enda")) {
            // return Success response
			response.setResponseMessage(username + "This is Internal mail: \n"
					+ "sender: Louis\n"
					+ "Would you albe help me to checke next week sale report\n "
					+ "Regard \n"
					+ "Louis");
			responseObserver.onNext(response.build());
			response.setResponseMessage(username + "This is External mail: \n"
					+ "sender: Louis Wong\n"
					+ "Would you albe help me to checke my acc balance\n "
					+ "Regard \n"
					+ "Louis Wong");
			responseObserver.onNext(response.build());
			response.setResponseMessage(username + "This is Internal mail: \n"
					+ "sender: Sarah\n"
					+ "when yo free would you mind send me last week sale report , please\n "
					+ "Regard \n"
					+ "Sarah");
			responseObserver.onNext(response.build());
            

        } else {
            // return Success response
            responseObserver.onNext(
                    response.setResponseMessage("... Sorry request Failed, user not logged in: " + username).build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<agendaRequest> staffAgenda(StreamObserver<agendaResponse> responseObserver) {
        return new StreamObserver<agendaRequest>() {
            @Override
            public void onNext(agendaRequest value) {
                
                String username = value.getUsername();
                System.out.println("On Server; message received from client " + username);

                if (username.equals("Enda")) {
                    // return Success response
                    agendaResponse running = agendaResponse.newBuilder().setResponseMessage("Your Agend is ").build();
                    responseObserver.onNext(running);

                } else {
                    // return Success response
                    responseObserver.onError(
                            Status.NOT_FOUND.withDescription("Dont have " + username + " agenda").asRuntimeException()
                    );
                }
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}