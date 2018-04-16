package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TriviaDisplayObject extends GraphicObject {
	private String text;
	private Font font;
	
	public TriviaDisplayObject(Coordinate coord, String toDisplay) {
		super(coord, 100, 100);
		
		text = toDisplay;
	}
	
	@Override
	public void paint(Graphics graphic, int x, int y) {
		graphic.setColor(Color.BLACK);
		graphic.drawString(text, x() + x, y() + y);
	}
	
}
