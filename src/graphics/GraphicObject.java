package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicObject {
	private Coordinate coords;
	private int[][] points;
	private double radius; 
	private int height;
	private int width;
	
	
	private Color color;
	private Animation animation;
	
	/*
	 * Constructs an Object for the graphical userface.
	 *  
	 * @param p convex points with origin of (0, 0)
	 */
	public GraphicObject(Coordinate coords, int width, int height) {
		this.coords = coords;
		this.width = width;
		this.height = height;
		color = Color.BLACK;
	}
	
	public void update(double millis) {};
	
		
	
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
	
	
	public boolean objectTouch(GraphicObject object) {
		if(object.leftX() < this.rightX() && object.rightX() > this.leftX()) {
			if(object.topY() < this.bottomY() && object.bottomY() > this.topY()) 
				return true;
		}
		return false;
	}
	
	public boolean pointTouch(Coordinate coords) {
		if(coords.getX() > leftX() && coords.getX() < rightX()) {
			if(coords.getY() > topY() && coords.getY() < bottomY())
				return true;
		}
		return false;
	}

	public boolean narrowObjectTouch(GraphicObject object) {
		return false;
	}
	
	public boolean narrowObjectTouch(GraphicObject object, Coordinate coords) {
		return false;
	}
	
	
	
	
	//Mouse Interaction classes
	public void mouseHover() {
		color = Color.GREEN;
	}
	
	public void mouseClick() {
		
	}
	
	public void noContact() {
		color = Color.BLACK;
	}
	
	
	
	
	
	public void setCoordinate(int x, int y) {
		coords.setCoords(x, y);
	}
	
	//
	public int rightX() {
		return coords.getX() + width;
	}
	public int leftX() {
		return x();
	}
	public int topY() {
		return y();
	}
	public int bottomY() {
		return y() + height;
	}
	
	//
	public int x() {
		return coords.getX();
	}
	public int y() {
		return coords.getY();
	}
	
	public String toString() {
		return "Object: " + x() + ", " + y();
	}
}
