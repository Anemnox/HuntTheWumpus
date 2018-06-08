package main.gameboardEntities;

import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

// The player object stores all data regarding the player
public class Player extends GraphicObject implements GameEntity{
	
	private int wumpusHits;
	private int arrows;
	private int gold;
	private int caveID;
	
	public Player(Animation anim) {
		super(anim, new Coordinate(0, 0), 50, 50);
		gold = 3;
		arrows = 2;
	}
	
	//public void paint(Graphics graphic, int x, int y) {
	
	//}
	
	public void update(double tick) {
		
	}
	
		
	public void setPosition(int position) {
		caveID = position;
	}
	
	
	
	
	public int calculateScore() {
		int score;
		score = (wumpusHits * 10) + gold + (arrows * 2);
		return score;
	}

	
	

	//
	//		setter methods
	//
	public void setGold(int setAmount) { // Force sets the gold count of the player
		gold = setAmount;
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
	
	
	//Getter Methods;
	public int getGold() { // Returns how much gold the player has
		return gold;
	}

	public int getArrows() { // Returns how many arrows the player has
		return arrows;
	}
	
	public int getPosition() {
		return caveID;
	}
}
