package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class GameClientHandler {

	private Socket client;
	private GameServer server;

	
	public GameClientHandler(Socket client, GameServer server) {
		this.client = client;
		this.server = server;
	}
		
	
	public void run() {
	
	}

}

