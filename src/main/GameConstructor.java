package main;

import graphics.*;

public class GameConstructor
{
	public static WumpusWindow window;
	
	// x, y, width, height
	public static int[][] menuData = {
			{100, 100, 300, 100},
			{100, 300, 300, 100},
			{500, 100, 300, 100},
			{400, 300, 300, 100},
			
	};
	
	public static void initializeMenu() {
		window = new WumpusWindow(1028, 768);
		for(int i = 0; i < menuData.length; i++) {
			window.getFrame().add(new GraphicObject(new Coordinate(menuData[i][0], menuData[i][1]), menuData[i][2], menuData[i][3]));
		}
	}
	public static void initializeGame() {
		
	}
}
