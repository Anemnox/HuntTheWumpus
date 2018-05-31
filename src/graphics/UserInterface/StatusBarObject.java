package graphics.UserInterface;

import java.awt.Graphics;
import java.util.ArrayList;

import graphics.*;
import main.gameboardEntities.Player;

public class StatusBarObject extends GraphicObject{
	private ArrayList<Player> listOfPlayers;
	
	public StatusBarObject(Animation anim) {
		super(anim, new Coordinate(20, 618), 1266, 100);
		
	}
	
	public void addPlayer(Player player) {
		listOfPlayers.add(player);
	}
	
	public void paint(Graphics graphic, int x, int y) {
		super.paint(graphic, x, y);
	}
}
