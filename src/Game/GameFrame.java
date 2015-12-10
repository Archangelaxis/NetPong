package Game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("NetPong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		Game game = new Game();
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setResizable(false);
		game.start();
	}
}
