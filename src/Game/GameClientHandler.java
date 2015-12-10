package Game;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import Game.GameServer;

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

