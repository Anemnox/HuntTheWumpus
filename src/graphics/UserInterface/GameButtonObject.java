package graphics.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;

public class GameButtonObject extends ButtonObject {

	public GameButtonObject(Animation anim, Coordinate coords, int width, int height) {
		super(anim, coords, width, height);
		// TODO Auto-generated constructor stub
	}

	public void update(double tick ) {
		if(mouseDown) {
			animation.setFrame(2);
		} else if (mouseHover) {
			animation.setFrame(1);
			currentFont = new Font("showcard gothic", Font.BOLD, 28);
		} else {
			animation.setFrame(0);
			currentFont = new Font("showcard gothic", Font.PLAIN, 28);
		}
	}
	
	public void paint(Graphics graphic, int x, int y) {
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
			graphic.setColor(Color.getHSBColor(0.09f, 0.73f, 0.29f));
			graphic.setFont(currentFont);
			graphic.drawString(textToDisplay, x() + 20, y() + 40);
		} catch (Exception e) {
			
		}
	}
}
