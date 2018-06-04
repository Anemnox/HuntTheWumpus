package main.gameboardEntities;

import etc.MapCoordinates;

public class Wumpus {
	private int health;
	
	/**
	 * Constructor to make a new Wumpus
	 * @param h How many hits the wumpus can take (health)
	 * @param loc The room the wumpus is in
	 */
	public Wumpus(int h, int loc) {
		health = h;
		
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
}
