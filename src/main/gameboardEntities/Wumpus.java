package main.gameboardEntities;

import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

public class Wumpus extends GraphicObject {
	private int health;
	private int location;
	
	/**
	 * Constructor to make a new Wumpus
	 * @param anim Animation for the wumpus
	 * @param h How many hits the wumpus can take (health)
	 * @param loc The room the wumpus is in
	 */
	public Wumpus(Animation anim, int h, int loc) {
		super(anim, new Coordinate(0, 0), 50, 50);
		health = h;
		location = loc;
	}
	
	public void update(double millis) {
		
	}
	
	public int getPosition() {
		return location;
	}
	
	
	/**
	 * Method to call when the Wumpus takes damage
	 */
	public void takeDamage() {
		health--;
		if (health == 0) {
			//TODO Either have something happen here or return something
		}
	}
	
	/**
	 * Method to move the Wumpus to a new location
	 */
	public void move() {
		//Do we really need this?
	}

	@Override
	public void paint(Graphics graphic, int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
