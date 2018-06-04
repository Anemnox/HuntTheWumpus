package main.gameboardEntities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import graphics.Coordinate;
import graphics.GraphicObject;
import main.wumpusConstructor.GameConstructor;

public class CaveSystem extends GraphicObject
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
	
	public CaveSystem(){
		super(null, new Coordinate(110, 90), 1140, 580);
		//declare int
		//list all through 30 arrays
		listOfCaves = new ArrayList<>();
		for(int i = 0; i < arr1.length; i++) {
			Coordinate tempCoords = new Coordinate(95 * (i / 6), 94 * (i % 6) + (47 * ((i / 6) % 2)));
			listOfCaves.add(new Cave(GameConstructor.getAnimation(4), tempCoords, i, arr1[i]));
		}
		cameraCoords = new Coordinate(0, 0);
		
		
		
		/* run a true false situation grabbing index (number in the array) 
		 *  and tell whether it is possible to move to each room until it finds a match
		 */
	}
	
	public void populateCaves(ArrayList<GameEntity> listOfEntities) {
		for(Cave cave : listOfCaves) {
			cave.listOfEntities.clear();
		}
		
		int count = 0;
		Random rand = new Random();
		while(count < listOfEntities.size()) {
			int i = rand.nextInt(listOfCaves.size() - 1);
			if(listOfCaves.get(i).getEntities().isEmpty()) {
				listOfCaves.get(i).addEntity(listOfEntities.get(count));
				count ++;
			}
		}
	}
		
	public void paint(Graphics graphics, int x, int y) {
		//super.paint(graphic, x, y);
		for(Cave cave: listOfCaves) {
			try {
				//graphics.drawImage(cave.getFrame(), x + cave.x() + x(), y + cave.y() + y(), null);
				//System.out.println(x+x() + ", " + y +y());
				cave.paint(graphics, x + x(), y + y());
			} catch (Exception e) {
				
			}
		}
		
	}
		
	public void setCamera(int x, int y) {
		cameraCoords.setCoords(x, y);
	}
	
	public int getNumberOfCaves() {
		return listOfCaves.size();
	}
	
	public int x() {
		return coords.getX() + cameraCoords.getX();
	}
	
	public int y() {
		return coords.getY() + cameraCoords.getY();
	}
}
	



