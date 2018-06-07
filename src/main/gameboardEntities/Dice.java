package main.gameboardEntities;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;
import graphics.UserInterface.ButtonObject;

public class Dice extends ButtonObject{
	private float opacity;
	private boolean diceIsVisible;
	private int diceRoll;
	private	int diceMax;
	private int animationFrame;
	
	public Dice(Animation animation) {
		super(animation, new Coordinate(1150, 540), 100, 100);
		diceRoll = 1;
		diceMax = 6;
	}
	
	public void update(double tick) {
		
	}
	
	
	public void paint(Graphics graphic, int x, int y) {
		try {
			((Graphics2D) graphic).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
		} catch (Exception e) {}
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x + x() - 10, y + y() - 10, null);
			} else {
				graphic.setColor(color);
				graphic.fillRect(x(), y(), width, height);
			} 
			
		} catch (Exception e) {
			graphic.setColor(color);
			graphic.fillRect(x + x(), y + y(), width, height);
		}
		try {
			graphic.drawString("" + diceRoll, x + x() + 30, y + y() - 20);
			
		} catch (Exception e) {
			
		}
		try {
			((Graphics2D) graphic).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0));
		} catch (Exception e) {}
	}
	
	
	
	public void mouseHover() {
		opacity = (float) 1.0;
	}
	
	public void rollAnimation() {
		try {
			if(animation.getFrameIndex() < 6) {
				animation.setFrame(6);
			} else {
				animation.nextFrame();
			}
		} catch (Exception e) {
			
		}
	}
	
	public int rollDice() {
		Random rand = new Random();
		
		diceRoll = 1 + rand.nextInt(diceMax); 
		
		animation.setFrame(diceRoll - 1);
		return diceRoll;
	}
	
	public void noContact() {
		opacity = (float) 0.6;
	}
}
