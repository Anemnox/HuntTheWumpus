package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DisplayFrame extends JPanel implements MouseListener {
	private ArrayList<GraphicObject> listOfObjects;
	private int width, height;
	private Coordinate coords;
	private int mouseX, mouseY;
	private boolean mouseDown;
	private int clicks;
	
	public DisplayFrame(int width, int height, Coordinate coords) {
		this.width = width;
		this.height = height;
		//setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        addMouseListener(this);
		setBackground(Color.BLUE);
        setForeground(Color.BLACK);
        setFont(new Font("Ariel", Font.PLAIN, 20));
        listOfObjects = new ArrayList<>();
        this.coords = coords;
        clicks = 0;
    }
	
	public DisplayFrame(int width, int height) {
		this(width, height, new Coordinate(0, 0));
    }
	
	
	public void add(GraphicObject graphicObject) {
		listOfObjects.add(graphicObject);
		System.out.println(graphicObject);
	}
	
	
	
	public void update(double tick) {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        try {
        	graphics.drawString("Mouse x: " + mouseX + "   Mouse y: " + mouseY, 20, 20);
        	graphics.drawString("Mouse Down: " + mouseDown + "   Mouse Clicks: " + clicks, 20, 80);
	        for(GraphicObject object : listOfObjects) {
	        	object.paint(graphics, x(), y());
	        }
        } catch (Exception e) {
        	
        }
    }
	
	
	public void setMouseCoords(int x, int y) {
		mouseX = x;
		mouseY = y;
	}
	public void setHeight(int h) {
		height = h;
	}
	public void setWidth(int w) {
		width = w;
	}
	
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	private int y() {
		return coords.getX();
	}

	private int x() {
		return coords.getY();
	}
	public ArrayList<GraphicObject> getObjects(){
		return listOfObjects;
	}

	
	
	
	
	//Mouse Listener
	@Override
	public void mouseClicked(MouseEvent e) {
		clicks += 1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
	}
}
