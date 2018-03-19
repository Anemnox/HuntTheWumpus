package graphics;

import java.awt.Graphics;

public abstract class GraphicObject {
	private Coordinate coords;
	private int[][] points;
	private double radius; 
	private int height;
	private int width;
	
	/*
	 * Constructs an Object for the graphical userface.
	 *  
	 * @param p convex points with origin of (0, 0)
	 */
	public GraphicObject(int[][] p) {
		points = p;
	}
	
	public abstract void update(double millis);
	
		
	
	public void paint(Graphics graphic) {
		graphic.fillRect(x(), y(), width, height);
	}
	
	
	public boolean objectTouch(GraphicObject object) {
		return false;
	}
	
	public boolean pointTouch(GraphicObject object, Coordinate coords) {
		if(coords.getX() > object.leftX() && coords.getX() < object.rightX()) {
			if(coords.getY() > object.topY() && coords.getY() < object.bottomY())
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
}
