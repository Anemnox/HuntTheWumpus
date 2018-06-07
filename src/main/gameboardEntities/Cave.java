package main.gameboardEntities;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;
import graphics.UserInterface.ButtonObject;

public class Cave extends ButtonObject{
	public ArrayList<GraphicObject> listOfEntities;
	public int caveID;
	public float opacity;
	public int[] doors;
	public boolean textIsVisible;
	public boolean roomIsVisible;
	public boolean focused;
	
	public Cave(Animation anim, Coordinate coords, int ID, int[] passageWays) {
		super(anim, coords, 100, 86, null);
		caveID = ID;
		doors = passageWays;
		opacity = (float) 0.8;
		// TODO Auto-generated constructor stub
		textIsVisible = true;
		listOfEntities = new ArrayList<>();
		focused = false;
	}
	
	public boolean possibleDoorway(int ID) {
		boolean possible = false;
		for(int i : doors) {
			if(i == ID)
				possible = true;
		}
		return possible;
	}
	
	
	public void addEntity(GraphicObject entity) {
		listOfEntities.add(entity);
	}
	
	public ArrayList<GraphicObject> getEntities() {
		return listOfEntities;
	}
	
	public void update(double tick) {
		boolean tempVisibility = false;
		for(GraphicObject object : listOfEntities) {
			if(object instanceof Player) {
				tempVisibility = true;
			}
		}
		
		roomIsVisible = tempVisibility;
		if(focused) {
			mouseHover();
		}
		
		if(roomIsVisible) {
			animation.setFrame(2);
		}
	}
	
	public void paint(Graphics graphic, int x, int y) {
		try {
			((Graphics2D) graphic).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
		} catch (Exception e) {
			
		}
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x + x(), y + y(), null);
			} else {
				graphic.setColor(color);
				graphic.fillRect(x(), y(), width, height);
			} 
			
		} catch (Exception e) {
			graphic.setColor(color);
			graphic.fillRect(x(), y(), width, height);
		}
		try {
			for(GraphicObject object: listOfEntities) {
				object.paint(graphic, x + x() + 30, y + y() + 20);
			}
		} catch(Exception e) {
			
		}
		if(textIsVisible) {
			try {
				graphic.setColor(Color.getHSBColor(0.09f, 0.73f, 0.29f));
				graphic.setFont(currentFont);
				graphic.drawString("" +caveID, x + x() + 20, y + y() + 70);
			} catch (Exception e) {
				
			}
		}
		try {
			((Graphics2D) graphic).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0));
		} catch (Exception e) {
			
		}
	}
	
	
	
	public void mouseHover() {
		opacity = (float) 1.0;
	}
		
	public void clicked() {
		
	}
	
	public void setFocus(boolean focused) {
		this.focused = focused;
	}
	
	public void noContact() {
		if(!focused) {
			opacity = (float) 0.6;

		}
	}
}
