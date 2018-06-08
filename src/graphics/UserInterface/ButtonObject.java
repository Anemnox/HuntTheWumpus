package graphics.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

public class ButtonObject extends GraphicObject{
	protected boolean mouseHover;
	protected boolean mouseDown;
	protected boolean hasFocus;
	protected ButtonAction buttonAction;
	protected String textToDisplay;
	protected Font currentFont;
	
	
	public ButtonObject (Animation anim, Coordinate coords, int width, int height, ButtonAction action) {
		super(anim, coords, width, height);
		buttonAction = action;
		currentFont = new Font("Showcard gothic", Font.PLAIN, 58);
		hasFocus = true;
	}
	public ButtonObject (Animation anim, Coordinate coords, int width, int height) {
		this(anim, coords, width, height, null);
	}
	
	@Override
	public void update(double tick ) {
		if(mouseDown) {
			animation.setFrame(2);
		} else if (mouseHover) {
			animation.setFrame(1);
			currentFont = new Font("showcard gothic", Font.BOLD, 58);
		} else {
			animation.setFrame(0);
			currentFont = new Font("showcard gothic", Font.PLAIN, 58);
		}
	}
	
	public void setText(String text) {
		textToDisplay = text;
	}
	
	public void setFocus(boolean focused) {
		hasFocus = focused;
	}
	
	
	//Mouse Interaction classes
	public void mouseHover() {
		if(hasFocus) {
			mouseHover = true;
		}
	}	
	
	public void mouseDown() {
		if(hasFocus) {
			mouseDown = true;
		}
	}
	
	public void mouseUp() {
		mouseDown = false;
	}
	
	public void clicked() {
		// TODO Auto-generated method stub
		if(hasFocus) {
			try {
				buttonAction.action();
			} catch(Exception e) {
				System.err.println("No Action Set");
			}
		}
	}
	
	public void noContact() {
		// TODO Auto-generated method stub
		mouseHover = false;
	}
	
	
	public void setAction(ButtonAction action) {
		buttonAction = action;
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
			graphic.drawString(textToDisplay, x() + 20, y() + 70);
		} catch (Exception e) {
			
		}
	}
	
	public boolean getMouseDown() {
		return mouseDown;
	}
	
	public boolean isFocused() {
		return hasFocus;
	}
}
