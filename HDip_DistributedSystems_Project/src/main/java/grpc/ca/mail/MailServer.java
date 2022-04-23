package grpc.ca.mail;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import grpc.ca.mail.UserServiceGrpc.UserServiceImplBase;

public class MailServer{
	
	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		MailServer ourServer = new MailServer();
		ourServer.start();
		
	}
	private void start() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Starting gRPC Server!!!!!");
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new MailServerImpl()).build().start();
		System.out.println("Server Running on Port: " + port);
		
		server.awaitTermination();
		
	}
	//Extend abstract base class for our own implementation
	static class MailServerImpl extends UserServiceImplBase{

	@Override
	public void staffMail(staffMailRequest request, StreamObserver<staffMailResponse> responseObserver) {
		System.out.println("Inside UserService::Logout()");
		String username = request.getUsername();

		staffMailResponse.Builder response = staffMailResponse.newBuilder();
		System.out.println("Logging out username = " + username);

		if(username.equals("Enda")) {
			// return Success response
			response.setResponseMessage(username + "This is Internal mail: \n"
					+ "sender: Louis\n"
					+ "Would you albe help me to checke next week sale report\n "
					+ "Regard \n"
					+ "Louis");
			
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
			
		}
		else {
			// return Success response
			response.setResponseMessage(username +
					"... Sorry request Failed, user not logged in: " + username);
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		}
	
	}	
	//client Stream 
	public StreamObserver<agendaRequest> staffAgenda(StreamObserver<agendaResponse> responseObserver){
		System.out.println("On Server; inside the streaming method ");
		
		return new StreamObserver<agendaRequest>() {

			@Override
			public void onNext(agendaRequest value) {
			System.out.println("On Server; message received from client " + value.getUsername());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				//
				agendaResponse.Builder responseBuilder = agendaResponse.newBuilder();
				
				responseBuilder.setResponseMessage("Server says it has got your  complete message: ");
				
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted();
				
			}};
	}
	
	
}




