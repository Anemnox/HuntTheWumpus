package main.gameboardEntities;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

public class Wumpus extends GraphicObject implements GameEntity {
	private int health;
	private int location;
	
	/**
	 * Constructor to make a new Wumpus
	 * @param anim Animation for the wumpus
	 * @param h How many hits the wumpus can take (health)
	 * @param loc The room the wumpus is in
	 */
	public Wumpus(Animation anim, int h, int loc) {
		super(anim, new Coordinate(20, 20), 50, 50);
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

	public void paint(Graphics graphic, int x, int y) {
		try {
			((Graphics2D) graphic).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0));
		} catch (Exception e) {
			
		}
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x() + x + 5, y() + y, null);
			} else {
				graphic.setColor(color);
				graphic.fillRect(x() + x, y() + y, width, height);
			} 
		} catch (Exception e) {
			graphic.setColor(color);
			graphic.fillRect(x() + x, y() + y, width, height);
		}
	}
	

	@Override
	public void setPosition(int position) {
		// TODO Auto-generated method stub
		this.location = position;
	}

	@Override
	public void interact(GameEntity entity) {
		// TODO Auto-generated method stub
		if(entity instanceof Player) {
			((Player)(entity)).fightWumpus(true);
		}
	}
	
	public int getHealth() {
		return health;
	}

	@Override
	public void addTurn() {
		// TODO Auto-generated method stub
		
	}
}
