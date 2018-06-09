package graphics.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;
import main.gameboardEntities.Wumpus;

public class WumpusHealth extends GraphicObject{
	private Wumpus wumpus;
	
	public WumpusHealth(Wumpus wumpus) {
		super(null, new Coordinate(0, 0), 100, 100);
		// TODO Auto-generated constructor stub
		this.wumpus = wumpus;
	}

	public void paint(Graphics graphic, int x, int y) {
		graphic.setFont(new Font("showcard gothic", Font.PLAIN, 28));
		graphic.setColor(Color.BLACK);
		try {
			
			graphic.drawString("WUMPUS HEALTH: " + wumpus.getHealth(), 1000, 690);
		} catch(Exception e) {
			e.printStackTrace();
			graphic.drawRect(500, 500, 500, 500);
		}
	}
	
	public String toString() {
		return "WUMPUS HEALTH: ";
	}
}
