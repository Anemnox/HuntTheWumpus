package main.gameboardEntities;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

// The player object stores all data regarding the player
public class Player extends GraphicObject implements GameEntity{
	private boolean stunned;
	private boolean shot;
	private int slowed;
	private int wumpusHits;
	private int skin;
	private int arrows;
	private int gold;
	private int caveID;
	private boolean currentTurn;
	
	public Player(Animation anim) {
<<<<<<< HEAD
		super(anim, new Coordinate(0, 0), 50, 50);
		slowed = 0;
		stunned = false;
=======
		super(anim, new Coordinate(31, -30), 34,94);
>>>>>>> 06f0b533098a73a0fbe68971f43a8e3f3d895218
		gold = 3;
		arrows = 2;
		setSkin(0);
		currentTurn = false;
	}
	
	//public void paint(Graphics graphic, int x, int y) {
	
	//}
	
	public void update(double tick) {
		animation.setFrame(skin);
	}
	
		
	public void setPosition(int position) {
		caveID = position;
	}
	
<<<<<<< HEAD
=======
	public void setSkin(int index) {
		skin = index;
	}
	
	public void setTurn(boolean hasTurn) {
		currentTurn = hasTurn;
	}
	
>>>>>>> 06f0b533098a73a0fbe68971f43a8e3f3d895218
	public int calculateScore() {
		int score;
		score = (wumpusHits * 10) + gold + (arrows * 2); //TODO Tweak this
		return score;
	}

<<<<<<< HEAD
=======
	
	public void paint(Graphics graphic, int x, int y) {
		try {
			((Graphics2D) graphic).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0));
		} catch (Exception e) {
			
		}
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x() + x, y() + y, null);
			} else {
				graphic.setColor(color);
				graphic.fillRect(x() + x, y() + y, width, height);
			} 
		} catch (Exception e) {
			graphic.setColor(color);
			graphic.fillRect(x() + x, y() + y, width, height);
		}
		
	}

>>>>>>> 06f0b533098a73a0fbe68971f43a8e3f3d895218
	//
	//		setter methods
	//
	public void hitWumpus() {
		wumpusHits++;
	}
	
	public void setGold(int setAmount) { // Force sets the gold count of the player
		gold = setAmount;
	}
	
	public void setShot(boolean shoot) {
		shot = shoot;
	}
	
	public void setStun(boolean stun) {
		stunned = stun;
	}
	
	public void setSlow(int slow) {
		slowed = slow;
	}
	
	public void setArrows(int setAmount) { // Force sets the arrow count of the player
		arrows = setAmount;
	}
	
	public void changeArrow(int incr) { // Add/Remove arrows
		arrows += incr;
	}
	
	public void changeGold(int incr) { // Add/Remove Gold
		gold += incr;
	}
	
	//
	//		Getter Methods
	//
	public int getSlow() {
		return slowed;
	}
	
	public int getGold() { // Returns how much gold the player has
		return gold;
	}
	
	public boolean getStun() {
		return stunned;
	}
	
	public boolean getShot() {
		return shot;
	}

	public int getArrows() { // Returns how many arrows the player has
		return arrows;
	}
	
	public int getPosition() {
		return caveID;
	}
	
	public boolean hasTurn() {
		return currentTurn;
	}
}
