package grpc.ca.loginService;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class StaffClient {

	private static UserServiceGrpc.UserServiceBlockingStub blockingStub;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = UserServiceGrpc.newBlockingStub(channel);

		//Create Request messages for use within the main method
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Enda").setPassword("123456").build();
		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername("Enda").build();
		StampInRequest stampInRequest = StampInRequest.newBuilder().setUsername("Enda").build();
		StampOutRequest stampOutRequest = StampOutRequest.newBuilder().setUsername("Enda").build();

		
		StampOutResponse response = blockingStub.stampOut(stampOutRequest);
		System.out.println("Response from Server: " + response);
	}

	//Login
	public static void login() {
		System.out.println("Inside Login in Client: ");

		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Enda").setPassword("Dublin").build();

		LoginResponse response = blockingStub.login(loginRequest);

		System.out.println("Response from Server: " + response);
	}

	//Logout
	public static void logout() {
		System.out.println("Inside Logout in Client: ");

		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername("Ends").build();

		LogoutResponse response = blockingStub.logout(logoutRequest);

		System.out.println("Response from Server: " + response);
	}
	
	public static void stampIn() {
		System.out.println("Inside Login in Client: ");

		StampInRequest loginRequest = StampInRequest.newBuilder().setUsername("Enda").build();

		StampInResponse response = blockingStub.stampIn(loginRequest);

		System.out.println("Response from Server: " + response);
	}
	
	public static void stampOut() {
		System.out.println("Inside Login in Client: ");

		StampOutRequest loginRequest = StampOutRequest.newBuilder().setUsername("Enda").build();

		StampOutResponse response = blockingStub.stampOut(loginRequest);

		System.out.println("Response from Server: " + response);
	}
}

