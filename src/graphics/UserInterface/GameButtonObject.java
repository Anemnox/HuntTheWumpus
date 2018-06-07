package graphics.UserInterface;

import java.awt.Font;

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
}
