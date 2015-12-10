package Sprites;

import Game.Input;

public class Player extends Sprite {

	public Player(int x, int y) {
		super(x, y);
	}
	@Override
	public void tick(Input input) {
		if (input.buttons[Input.LEFT])
			if (getX() > 0) // prevents the player from leaving the screen
			setX(getX() - 1);
		if (input.buttons[Input.RIGHT])
			if (getX() < 913) // prevents the player from leaving the screen
			setX(getX() + 1);
	}
	
}