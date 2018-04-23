package main;

import graphics.*;

public class GameConstructor
{
	
	// x, y, width, height
	public static int[][] menuData = {
			{50, 200, 400, 400}
	};
	
	public static int[][] menuButtonData = {
			{600, 100, 300, 100},
			{600, 250, 300, 100},
			{600, 400, 300, 100},
			{600, 550, 300, 100},
	};
	
	public static WumpusWindow initializeWindow() {
		WumpusWindow window = new WumpusWindow(1028, 768);
		for(int i = 0; i < menuData.length; i++) {
			window.getFrame().add(new GraphicObject(new Coordinate(menuData[i][0], menuData[i][1]), menuData[i][2], menuData[i][3]));
		}
		return window;
	}
	public static void initializeGame() {
		
	}
	
	public static WumpusWindow testTriviaDisplay() {
		WumpusWindow window = new WumpusWindow(1366, 768);
		window.getFrame().add(new TriviaDisplayObject(new Coordinate(300, 300), "This is not working"));
		for(int i = 0; i < menuData.length; i++) {
			window.getFrame().add(new GraphicObject(new Coordinate(menuData[i][0], menuData[i][1]), menuData[i][2], menuData[i][3]));
		}
		for(int i = 0; i < menuButtonData.length; i++) {
			window.getFrame().addButton(new ButtonObject(new Coordinate(menuButtonData[i][0], menuButtonData[i][1]), menuButtonData[i][2], menuButtonData[i][3]));
		}
		return window;
	}
}
