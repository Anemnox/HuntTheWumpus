package graphics.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

public class TriviaDisplayObject extends GraphicObject {
	private String text;
	private Font font;
	
	public TriviaDisplayObject(Animation anim, Coordinate coord, String toDisplay) {
		super(anim, coord, 100, 100);
		
		text = toDisplay;
	}
	
	@Override
	public void paint(Graphics graphic, int x, int y) {
		try {
			if(animation.getFrame() != null) {
				graphic.drawImage(animation.getFrame(), x() + x, y() + y, null);
			} else {
				graphic.setColor(Color.BLACK);
			} 
		} catch (Exception e) {
			graphic.setColor(color);
			graphic.fillRect(x() + x, y() + y, width, height);
		}
		graphic.drawString(text, x() + x, y() + y);
	}
	
}
