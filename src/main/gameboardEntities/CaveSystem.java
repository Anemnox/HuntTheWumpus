package main.gameboardEntities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import graphics.Coordinate;
import graphics.DisplayFrame;
import graphics.GraphicObject;
import graphics.UserInterface.ButtonObject;
import main.wumpusConstructor.GameConstructor;

public class CaveSystem extends ButtonObject
{
	public static int[][] arr1 = {
			{5, 6, 26}, //1
			{3, 6, 7}, //2
			{2, 8, 4}, //3
			{3, 5, 28}, //4
			{1, 4, 10}, //5
			{1, 2, 12}, //6
			{2, 8, 12}, //7
			{3, 7, 14}, //8
			{14, 15, 10}, //9
			{11, 5, 9}, //10
			{16, 10, 20}, //11
			{7, 6, 16}, //12
			{18, 17, 14}, //13
			{13, 8, 9}, //14
			{9, 20, 19},//15
			{11, 21, 12}, //16
			{13, 23, 18}, //17
			{17, 13, 24}, //18
			{15, 24, 25}, //19
			{15, 11, 21}, //20
			{20, 22, 16}, //21
			{26, 21, 27}, //22
			{17, 27, 24}, //23
			{18, 19, 23}, //24
			{19, 29, 30}, //25
			{30, 1, 22}, //26
			{22, 23, 28}, //27
			{27, 29, 4}, //28 
			{28, 25, 30}, //29
			{26, 25, 29} //30
			
			};
	public ArrayList<Cave> listOfCaves;
	//constructor
	public Coordinate cameraCoords;
	public Coordinate mouseCoords;
	public Coordinate mouseRelCamera;
	public Rectangle visibleRectangle;
	public DisplayFrame currentFrame;
	public int highlightedCave;
	
	public CaveSystem(DisplayFrame frame){
		super(null, new Coordinate(410, 90), 590, 580);
		//declare int
		//list all through 30 arrays
		listOfCaves = new ArrayList<>();
		for(int i = 0; i < arr1.length; i++) {
			Coordinate tempCoords = new Coordinate(95 * (i / 6), 94 * (i % 6) + (47 * ((i / 6) % 2)));
			listOfCaves.add(new Cave(GameConstructor.getAnimation(4), tempCoords, i, arr1[i]));
		}
		cameraCoords = new Coordinate(1, 1);
		
		currentFrame = frame;
		
		
		
		/* run a true false situation grabbing index (number in the array) 
		 *  and tell whether it is possible to move to each room until it finds a match
		 */
	}
	
	
	public void populateCaves(ArrayList<GraphicObject> listOfEntities) {
		for(Cave cave : listOfCaves) {
			cave.listOfEntities.clear();
		}
		
		int count = 0;
		Random rand = new Random();
		while(count < listOfEntities.size()) {
			int i = rand.nextInt(listOfCaves.size() - 1);

			if(listOfCaves.get(i).getEntities().isEmpty()) {
				listOfCaves.get(i).addEntity(listOfEntities.get(count));
				System.out.println("Adding Entity to Cave " + i);
				count ++;
			}
		}
	}
	
	
	
	
	public void update(double millis) {
		for(Cave cave : listOfCaves) {
			cave.update(millis);
		}
	};

	public boolean pointTouch(Coordinate coords) {
		mouseCoords = new Coordinate(coords.getX(), coords.getY());
		return super.pointTouch(coords);
	}
	
	public void clicked() {
		//super.clicked();
		mouseRelCamera = new Coordinate(
				mouseCoords.getX() - coords.getX() - cameraCoords.getX(),
				mouseCoords.getY() - coords.getY() - cameraCoords.getY());
		//System.out.println(mouseRelCamera);
		for(Cave cave : listOfCaves) {
			if(cave.pointTouch(mouseRelCamera)) {
				//System.out.println("Cave " + cave.caveID + " was clicked");
				highlightedCave = cave.caveID;
				cave.setFocus(true);
				cave.clicked();
			} else {
				cave.setFocus(false);
				cave.noContact();
			}
		}
	}
	
	public void paint(Graphics graphics, int x, int y) {
		//super.paint(graphic, x, y);
		graphics.setColor(Color.LIGHT_GRAY);
		//graphics.drawRect(leftX(), topY(), width, height);
		//graphics.fillRect(leftX(), topY(), width, height);
		//graphics.drawString("MouseCoords: " + mouseCoords + "    Camera Coordinates: " + cameraCoords + " Relative Camera Coords: " + mouseRelCamera, 50, 50);
		//System.out.println(leftX() + ", " + topY());
		//System.out.println(listOfCaves.get(0).leftX() + ", " + listOfCaves.get(0).bottomY());
		for(Cave cave: listOfCaves) {
			try {
				//graphics.drawImage(cave.getFrame(), x + cave.x() + x(), y + cave.y() + y(), null);
				//System.out.println(x+x() + ", " + y +y());
				if(caveCameraX() + cave.leftX() > leftX() && caveCameraX() + cave.rightX() < rightX() &&
						caveCameraY() + cave.topY() > topY() && caveCameraY() + cave.bottomY() < bottomY()) {
					
				
					cave.paint(graphics, x + caveCameraX(), y + caveCameraY());
				}
			} catch (Exception e) {
				
			}
		}
	}
		
	public void mouseHover() {
		mouseRelCamera = new Coordinate(
				mouseCoords.getX() - coords.getX() - cameraCoords.getX(),
				mouseCoords.getY() - coords.getY() - cameraCoords.getY());
		
		for(Cave cave : listOfCaves) {	
			if(cave.pointTouch(mouseRelCamera)) {
				//System.out.println("Hovering over cave " + cave.caveID);
				cave.mouseHover();
			} else {
				cave.noContact();
			}
		}
	}
	
	public void setCamera(int x, int y) {
		cameraCoords.setCoords(x, y);
	}
	
	public Cave focusedCave() {
		return listOfCaves.get(highlightedCave);
	}
	
	public Cave getCave(int i) {
		try {
			return listOfCaves.get(i);
		} catch(Exception e) {
			return null;
		}
	}
	
	public int getNumberOfCaves() {
		return listOfCaves.size();
	}
	
	public int getSavedCameraX() {
		return cameraCoords.getX();
	}
	
	public int getSavedCameraY() {
		return cameraCoords.getY();
	}
	
	public int caveCameraX() {
		return coords.getX() + cameraCoords.getX();
	}
	
	public int caveCameraY() {
		return coords.getY() + cameraCoords.getY();
	}
}
	



