package main.gameboardEntities;

import java.awt.Graphics;

public interface GameEntity {
	public void paint(Graphics graphic, int x, int y);
	public int getPosition();
	public void update(double millis);
	public void setPosition(int position);
}
