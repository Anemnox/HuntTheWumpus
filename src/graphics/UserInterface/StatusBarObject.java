package graphics.UserInterface;

import java.util.ArrayList;

import graphics.*;
import main.Player;

public class StatusBarObject extends GraphicObject{
	private ArrayList<Player> listOfPlayers;
	
	public StatusBarObject(Animation anim) {
		super(anim, new Coordinate(668, 0), 1366, 100);
		
	}
	
	public void addPlayer(Player player) {
		listOfPlayers.add(player);
	}
	
	public void paint() {
		
	}
}
