package grpc.ca.loginService;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class StaffClient {

	private final UserServiceGrpc.UserServiceBlockingStub blockingStub;
	private final ManagedChannel channel;
	private final UserServiceGrpc.UserServiceStub asyncStub;

	public StaffClient(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		blockingStub = UserServiceGrpc.newBlockingStub(channel);
		asyncStub = UserServiceGrpc.newStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public static void main(String[] args) throws InterruptedException {
		StaffClient client = new StaffClient("127.0.0.1", 10084);
		client.stampIn("Enda");
		TimeUnit.SECONDS.sleep(1);
	}

	//Login
	public String login(String userName, String password) {
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername(userName).setPassword(password).build();
		LoginResponse response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).login(loginRequest);
		return response.getResponseMessage();
	}

	//Logout
	public String logout(String username) {

		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername(username).build();

		LogoutResponse response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).logout(logoutRequest);
		return response.getResponseMessage();
	}
	
	public String stampIn(String username) {
		StampInRequest loginRequest = StampInRequest.newBuilder().setUsername(username).build();
		StampInResponse response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).stampIn(loginRequest);
		return response.getResponseMessage();
	}

	public String stampOut(String username) {
		StampOutRequest loginRequest = StampOutRequest.newBuilder().setUsername(username).build();
		StampOutResponse response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).stampOut(loginRequest);
		return response.getResponseMessage();
	}
}

