package main.gameboardEntities;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

// The player object stores all data regarding the player
public class Player extends GraphicObject implements GameEntity{
	private boolean shot;
	private int wumpusHits;
	private int skin;
	private int arrows;
	private int gold;
	private int caveID;
	private boolean currentTurn;
	private int moves;
	private int triviaFail;
	
	public Player(Animation anim) {
		super(anim, new Coordinate(31, -30), 34, 94);
		triviaFail = 0;
		gold = 3;
		arrows = 2;
		setSkin(0);
		currentTurn = false;
	}
	
	//public void paint(Graphics graphic, int x, int y) {
	
	//}
	
	public void triviaFailed() {
		triviaFail++;
	}
	
	public void update(double tick) {
		animation.setFrame(skin);
	}
	
		
	public void setPosition(int position) {
		caveID = position;
	}

	public void setSkin(int index) {
		skin = index;
	}
	
	public void setTurn(boolean hasTurn) {
		currentTurn = hasTurn;
	}
	
	public void setMoves(int i) {
		moves = i;
	}
	
	
	public void changeMoves(int i) {
		moves += i;
	}
	
	public int calculateScore() {
		int score;
		score = (wumpusHits * 18) + (gold * 2)  + (arrows * 3) - triviaFail; //TODO Tweak this
		return score;
	}

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
	public int getGold() { // Returns how much gold the player has
		return gold;
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
	
	public int getNumberOfMoves() {
		return moves;
	}
	
	public boolean hasTurn() {
		return currentTurn;
	}
}
