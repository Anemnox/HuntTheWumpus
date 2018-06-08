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
	public static Animation doorFrames;
	public static boolean showAll = false;
	public ArrayList<GameEntity> listOfEntities;
	public int caveID;
	public float opacity;
	public int[] doors;
	
	public int[] doorWayDirection;
	
	public boolean textIsVisible;
	public boolean roomIsVisible;
	public boolean focused;
	
	public static void setDoorsAnimation(Animation animation) {
		doorFrames = animation;
	}
	
	public Cave(Animation anim, Coordinate coords, int ID, int[] passageWays) {
		super(anim, coords, 100, 86, null);
		caveID = ID;
		doors = passageWays;
		
		doorWayDirection = new int[passageWays.length];
		for(int i = 0; i < passageWays.length; i++) {
			int change = passageWays[i] - caveID;
			int direction = 0;
			int oddOrEvenRow = ((caveID / 6) % 2);
			switch(change) {
			case 1:
				direction = 3;
				break;
			case -1:
				direction = 0;
				break;
			case 5:
				direction = 1;
				break;
			case -5:
				direction = 4;
				break;
			case 6:
				if(oddOrEvenRow == 0) {
					direction = 2;
				} else {
					direction = 1;
				}
				break;
			case -6:
				if(oddOrEvenRow == 0) {
					direction = 4;
				} else {
					direction = 5;
				}
				break;
			case 7:
				direction = 2;
				break;
			case -7:
				direction = 5;
				break;
			default:
				direction = 0;
				break;
			}
			doorWayDirection[i] = direction;
		}
		
		opacity = (float) 0.8;
		// TODO Auto-generated constructor stub
		textIsVisible = false; //true;
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
	
	
	public void addEntity(GameEntity entity) {
		listOfEntities.add(entity);
	}
	public void removeEntity(GameEntity entity) {
		listOfEntities.remove(entity);
	}
	
	public ArrayList<GameEntity> getEntities() {
		return listOfEntities;
	}
	
	public void update(double tick) {
		boolean tempVisibility = false;
		for(GameEntity object : listOfEntities) {
			object.update(tick);
			if(Cave.showAll) {
				tempVisibility = true;	
			} else {
				if(object instanceof Player) {
					tempVisibility = true;
				}
			}
		}
		
		roomIsVisible = tempVisibility;
		if(focused) {
			mouseHover();
		}
		
		if(roomIsVisible) {
			animation.setFrame(3);
		} else {
			animation.setFrame(0);
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
			for(int i : doorWayDirection) {
				doorFrames.setFrame(i);
				graphic.drawImage(doorFrames.getFrame(), x + x(), y + y(), null);
			}
			
		} catch(Exception e) {
			
		}
		
			try {
				int i = 0;
				for(GameEntity object: listOfEntities) {
					if(roomIsVisible) {
						object.paint(graphic, x + x() - 10 + (i * 10), y + y());
					} 
					i++;
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
		System.out.println(listOfEntities);
		/*for(int i : doorWayDirection){
			System.out.print(" " + i);
		}*/
	}
	
	public void setHighlighted(boolean focused) {
		this.focused = focused;
	}
	
	public void noContact() {
		if(!focused) {
			opacity = (float) 0.6;

		}
	}

	public int getID() {
		// TODO Auto-generated method stub
		return caveID;
	}

	public void interact() {
		// TODO Auto-generated method stub
		for(int i1 = 0; i1 < (listOfEntities.size() - 1); i1++) {
			for(int i2 = i1; i2 < listOfEntities.size(); i2++ ) {
				listOfEntities.get(i1).interact(listOfEntities.get(i2));
			}
		}
	}
}
