package main.gameboardEntities;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;
import main.wumpusConstructor.GameConstructor;

public class Chest extends GraphicObject implements GameEntity{
	private int health;
	private int location;
	
	/**
	 * Constructor to make a new Wumpus
	 * @param anim Animation for the wumpus
	 * @param h How many hits the wumpus can take (health)
	 * @param loc The room the wumpus is in
	 */
	public Chest() {
		super(GameConstructor.getAnimation(14), new Coordinate(38, 30), 50, 50);
		
	}
	
	public void update(double millis) {
		
	}
	
	public int getPosition() {
		return location;
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
		location = position;
	}

	@Override
	public void interact(GameEntity entity) {
		// TODO Auto-generated method stub
		if(entity instanceof Player) {
			Random rand = new Random();
			if(rand.nextBoolean()) {
				((Player) entity).changeGold(1);
			} else {
				((Player) entity).changeArrow(1);
			}
		}
	}
}
