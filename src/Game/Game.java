package Game;

import Sprites.Bullet;
import Sprites.Player;
import Game.Input;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.net.Socket;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public Player player1 = new Player(460,20);
	public Player player2 = new Player(460,930);
	private Bullet bullet = new Bullet(2,2);
	private int player1Score = 0;
	private int player2Score = 0;
	private boolean playing = true;
	private Input input = new Input();
	private Input input2 = new Input();
	public static final int GAME_WIDTH = 1000;
	public static final int GAME_HEIGHT = 1000;
	private int port = 7777;
	private Socket link;
	
	public Game () {
		addKeyListener(this);
	}
	
	private void processPlayer1(Graphics g) {
		player1.tick(input);
		g.fillRect(player1.getX(), player1.getY(), 80, 20);
	}
	
	private void processPlayer2(Graphics g) {
		player2.tick(input2);
		g.fillRect(player2.getX(), player2.getY(), 80, 20);
	}
	
	private void processBullet(Graphics g) {
		bullet.tick(input);
				g.fillRect(bullet.getX(), bullet.getY(), 5,5);
		if (bullet.getX() - player1.getX() <= 80 || bullet.getY() - player1.getY() <= 20)
			bullet.setYaccelerationP1();
		 
			
		else if (bullet.getX() - player2.getX() <= 80 || bullet.getY() - player2.getY() <= 20)
			bullet.setYaccelerationP2();
				
	}

	private void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLUE);

		processPlayer1(g);
		processBullet(g);
		processPlayer2(g);

		g.drawString("Player 1 Score " + player1Score, 900, 450);
		g.drawString("Player 2 Score "+ player2Score, 900, 500);
		g.dispose();
		bs.show();

		//controls the speed of the game
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			render();
			
		}
	}
	public void start() {
		new Thread(this).start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		input.set(e.getKeyCode(), true);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		input.set(arg0.getKeyCode(), false);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	
}
