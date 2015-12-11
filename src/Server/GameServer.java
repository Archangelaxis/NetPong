package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer {
	
	private final int port = 7777;
	private ServerSocket serverSocket;
	private ArrayList<Socket> clientList;	

	public GameServer() {
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setReuseAddress(true);
		} catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		clientList = new ArrayList<Socket>();
	}
	
	public void startServer() throws IOException {
		System.out.println("Accepting clients...");
		while(true)
		{
			// wait for a client
			Socket client = serverSocket.accept();
			clientList.add(client);
			System.out.println("New client accepted..." + client.getRemoteSocketAddress());
			System.out.println("Total users: " + clientList.size());
			GameClientHandler handler = new GameClientHandler(client,this);
			//Thread t = new Thread(handler);
			//t.start();
		}
	}
	public static void main(String[] args) throws IOException {
		new GameServer().startServer();
	}

}
