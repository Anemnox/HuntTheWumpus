package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class ButtonObject extends GraphicObject{
	protected boolean mouseHover;
	protected boolean mouseDown;

	
	public ButtonObject (Animation anim, Coordinate coords, int width, int height) {
		super(anim, coords, width, height);
	}
	
	
	//Mouse Interaction classes
	public void mouseHover() {
		mouseHover = true;
	}	
		
	
	public void clicked() {
		// TODO Auto-generated method stub
		mouseDown = true;
	}
	
	public void noContact() {
		// TODO Auto-generated method stub
		mouseHover = false;
		mouseDown = false;
		
	}
	
	
	
	public void paint(Graphics graphic, int x, int y) {
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x(), y(), null);
			} else {
				graphic.setColor(color);
				graphic.fillRect(x(), y(), width, height);
			} 
		} catch (Exception e) {
			graphic.setColor(color);
			graphic.fillRect(x(), y(), width, height);
		}	
	}


	
}
