package grpc.ca.loginService;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import grpc.ca.loginService.UserServiceGrpc.UserServiceImplBase;
import grpc.ca.server1.JMDNS.JmdnsRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class StaffServer extends UserServiceImplBase{

	public static void main(String[] args) throws IOException, InterruptedException {
		StaffServer staffServer = new StaffServer();
		staffServer.start();
	}

	public void start() throws InterruptedException, IOException {
		int port = 10084;
		String service_name = "staffServer";
		JmdnsRegistration registration = new JmdnsRegistration();
		registration.run(port ,service_name);

		Server server = ServerBuilder.forPort(port).addService(this).build().start();

		System.out.println("Server started with Port:" + server.getPort());
		server.awaitTermination();
	}

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		System.out.println("Inside UserService::Login()");
		String username = request.getUsername();
		String password = request.getPassword();

		LoginResponse.Builder response = LoginResponse.newBuilder();
		System.out.println("username = " + username + ", password = " + password);

		if(username.equals("Enda") && password.equals("Dublin")) {
			// return Success response
			response.setResponseCode(1).setResponseMessage(username + ".....Successfully logged in");
		}
		else {
			// return Success response
			response.setResponseCode(99).setResponseMessage(username + "... Sorry Login Failed");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}




	@Override
	public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
		System.out.println("Inside UserService::Logout()");
		String username = request.getUsername();

		LogoutResponse.Builder response = LogoutResponse.newBuilder();
		System.out.println("Logging out username = " + username);

		if(username.equals("Enda")) {
			// return Success response
			response.setResponseCode(1).setResponseMessage(username + ".....Successfully logged out");
		}
		else {
			// return Success response
			response.setResponseCode(99).setResponseMessage(username +
					"... Sorry Logout Failed, user not logged in: " + username);
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	
	@Override
	public void stampIn(StampInRequest request, StreamObserver<StampInResponse> responseObserver) {
		System.out.println("Inside UserService:Stamp In");
		String username = request.getUsername();
	    String stampTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

		StampInResponse.Builder response = StampInResponse.newBuilder();
		System.out.println("username = " + username);

		if(username.equals("Enda")) {
			// return Success response
			response.setResponseMessage(username + " Successfully Stamp in " + stampTime);
		}
		else {
			// return Success response
			response.setResponseMessage(username + "... Sorry StampIn Failed");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	
	@Override
	public void stampOut(StampOutRequest request, StreamObserver<StampOutResponse> responseObserver) {
		System.out.println("Inside UserService:Stamp In");
		String username = request.getUsername();
	    String stampTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

		StampOutResponse.Builder response = StampOutResponse.newBuilder();
		System.out.println("username = " + username);

		if(username.equals("Enda")) {
			// return Success response
			response.setResponseMessage(username + " Thank you! You Successfully Stamp Out " + stampTime + " Enjoy your off time!");
		}
		else {
			// return Success response
			response.setResponseMessage(username + "... Sorry StampOut Failed");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

}//class
