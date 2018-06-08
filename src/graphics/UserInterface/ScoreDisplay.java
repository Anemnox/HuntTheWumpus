package graphics.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;
import main.gameboardEntities.GameEntity;
import main.gameboardEntities.Player;

public class ScoreDisplay extends GraphicObject {
	private Player player;
	public ScoreDisplay(GameEntity player, Animation anim, Coordinate coords) {
		super(anim, coords, 400, 400);
		// TODO Auto-generated constructor stub
		this.player = (Player) player;
		color = Color.LIGHT_GRAY;
	}

	public void paint(Graphics graphic, int x, int y) {
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x() + x, y() + y, null);
			} else {
				graphic.setColor(color);
				graphic.fillRect(x() + x, y() + y, width, height);
			} 
		} catch (Exception e) {
			graphic.setColor(color);
			graphic.fillRect(x() + x, y() + y, width, height);
		}
		graphic.setFont(new Font("Showcard gothic", Font.PLAIN, 28));
		player.paint(graphic, x + x() + 130, y + y() + 80);
		graphic.drawString("Score: " + player.calculateScore(), x + x() + 120, y + y() + 200);
		
	}
	
	
}
