package main.gameboardEntities;

import java.util.ArrayList;

import graphics.Animation;
import graphics.Coordinate;
import graphics.UserInterface.ButtonObject;

public class Cave extends ButtonObject{
	public ArrayList<GameEntity> listOfEntities;
	public int caveID;
	public int[] doors;
	
	public Cave(Animation anim, Coordinate coords, int ID, int[] passageWays) {
		super(anim, coords, 100, 86, null);
		caveID = ID;
		doors = passageWays;
		// TODO Auto-generated constructor stub
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
	public ArrayList<GameEntity> getEntities() {
		return listOfEntities;
	}
	
	
	
	
	
	public void mouseHover() {
		
	}
	
	public void clicked() {
		
	}
}
