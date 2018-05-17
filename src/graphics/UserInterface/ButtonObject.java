package graphics.UserInterface;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Animation;
import graphics.Coordinate;
import graphics.GraphicObject;

public class ButtonObject extends GraphicObject{
	protected boolean mouseHover;
	protected boolean mouseDown;
	protected ButtonAction buttonAction;
	
	public ButtonObject (Animation anim, Coordinate coords, int width, int height, ButtonAction action) {
		super(anim, coords, width, height);
		buttonAction = action;
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
		} else {
			animation.setFrame(0);
		}
	}
	
	//Mouse Interaction classes
	public void mouseHover() {
		mouseHover = true;
	}	
	
	public void mouseDown() {
		mouseDown = true;
	}
	
	public void mouseUp() {
		mouseDown = false;
	}
	
	public void clicked() {
		// TODO Auto-generated method stub
		try {
			buttonAction.action();
		} catch(Exception e) {
			System.err.println("No Action Set");
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
	
	public boolean getMouseDown() {
		return mouseDown;
	}
}
