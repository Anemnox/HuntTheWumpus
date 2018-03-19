package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DisplayFrame extends JPanel{
	private ArrayList<GraphicObject> listOfObjects;
	private int width, height;
	
	public DisplayFrame(int width, int height) {
		this.width = width;
		this.height = height;
		//setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		setBackground(Color.BLUE);
        setForeground(Color.BLACK);
        setFont(new Font("Ariel", Font.PLAIN, 20));
        listOfObjects = new ArrayList<>();
    }
	
	
	public void add(GraphicObject graphicObject) {
		listOfObjects.add(graphicObject);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        try {
	        for(GraphicObject object : listOfObjects) {
	        	object.paint(graphics);
	        }
        } catch (Exception e) {
        	
        }
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
}
