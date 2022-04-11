package grpc.ca.mail;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import grpc.ca.mail.UserServiceGrpc.UserServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MailServer extends UserServiceImplBase {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Starting gRPC Server");
		MailServer userserver = new MailServer();

		int port = 50051;

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(userserver)
					.build()
					.start();

			System.out.println("Server started with Port:" + server.getPort());
		    server.awaitTermination();

		}//try
		catch(IOException e){
			e.printStackTrace();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}

	}//main
	

	public void staffAgenda(AgendaRequest request, StreamObserver<AgendaResponse> responseObserver) {
		System.out.println("Inside UserService::Login()");
		String username = request.getUsername();

		AgendaResponse.Builder response = AgendaResponse.newBuilder();
		System.out.println("username = " + username );

		if(username.equals("Enda") ) {
			// return Success response
			response.setResponseMessage(username + ".....Successfully logged in");
		}
		else {
			// return Success response
			response.setResponseMessage(username + "... Sorry Login Failed");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}




	@Override
	public void staffMail(StaffMailRequest request, StreamObserver<StaffMailResponse> responseObserver) {
		System.out.println("Inside UserService::Logout()");
		String username = request.getUsername();

		StaffMailResponse.Builder response = StaffMailResponse.newBuilder();
		System.out.println("Logging out username = " + username);

		if(username.equals("Enda")) {
			// return Success response
			response.setResponseMessage(username + ".....Successfully logged out");
		}
		else {
			// return Success response
			response.setResponseMessage(username +
					"... Sorry Logout Failed, user not logged in: " + username);
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

}
