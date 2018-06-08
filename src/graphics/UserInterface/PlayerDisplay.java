package graphics.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Coordinate;
import graphics.GraphicObject;
import main.gameboardEntities.Player;
import main.wumpusConstructor.GameConstructor;

public class PlayerDisplay extends GraphicObject {
	private Player player;
	
	public PlayerDisplay(Coordinate coords, Player player) {
		super(GameConstructor.getAnimation(9), coords, 300, 200);
		this.player = player;
	}
	
	
	@Override
	public void update(double tick) {
		if(player.hasTurn()) {
			animation.setFrame(1);
		} else {
			animation.setFrame(0);
		}
	}
	
	@Override
	public void paint(Graphics graphic, int x, int y) {
		super.paint(graphic, x, y);
		player.paint(graphic, x + x() + 30, y + y() + 60);
		graphic.setColor(Color.black);
		graphic.setFont(new Font("showcard gothic", Font.BOLD, 28));
		graphic.drawString("" + player.getNumberOfMoves(), x + x() + 230, y + y() + 90);
		graphic.drawString("" + player.getArrows(), x + x() + 220, y + y() + 160);
		graphic.drawString("" + player.getGold(), x + x() + 105, y + y() + 160);
		graphic.drawString("Cave Position: " + player.getPosition(), x + x() + 10, y + y());

	}

}
