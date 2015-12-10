package Sprites;

import Game.Input;
import Sprites.Sprite;
import Game.Game;

public class Bullet extends Sprite {

	public int Xacceleration = 2;
	public int Yacceleration = 1;
	

	public Bullet(int x, int y) {
		super(x, y);
	}
	

	public void tick(Input input) {
		setY(getY() + Yacceleration);
		setX(getX() + Xacceleration);
		if (getY() > Game.GAME_HEIGHT)
			Yacceleration = -1;
			//remove();
		else if (getY() <= 0)
			Yacceleration = 1;
			//remove();
		else if (getX() > Game.GAME_WIDTH)
			Xacceleration = -1;
		else if (getX() <= 0)
			Xacceleration = 1;
		
		}
	
	public void setYaccelerationP2() {
		Yacceleration = -1;
	}
	
	public void setYaccelerationP1() {
		Yacceleration = 1;
	}
}