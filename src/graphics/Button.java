package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Button extends GraphicObject{
	protected boolean mouseHover;
	protected boolean mouseDown;

	
	public Button (Coordinate coords, int width, int height) {
		super(coords, width, height);
	}
	
	
	//Mouse Interaction classes
	public void mouseHover() {
		mouseHover = true;
	}	
		
	
	public void clicked() {
		// TODO Auto-generated method stub
	}
	
	
	
	
	
	public void paint(Graphics graphic, int x, int y) {
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x() + x, y() + y, null);
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
