package graphics;

import java.awt.Color;

import javax.swing.JFrame;

public class WumpusWindow extends JFrame{
	private int height;
	private int width;
	
	public WumpusWindow(int width, int height) {
		this.height = height;
		this.width = width;
		setSize(this.width, this.height);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setUndecorated(true);
	}
	
	
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
}
