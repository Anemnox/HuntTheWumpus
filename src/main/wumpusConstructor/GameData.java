package main.wumpusConstructor;

import main.GameControl;

public class GameData {
	//
	//				Menu Screen
	//
	public static int[][] menuData = {
			//{x, y, width, height}
			{70, 150, 700, 400}
	};
	
	public static int[][] menuButtonData = {
			//{x, y, width, height, imageID, tagID}
			{900, 100, 300, 100, 1},
			{900, 250, 300, 100, 1},
			{900, 400, 300, 100, 1},
			{900, 550, 300, 100, 1},
	};
	
	
	
	//
	//				Game Screen
	//
	public static int[][] gameBoardData = {
			
	};
	
	public static int[][] gameBoardButtonData = {
			{}, // Setting Button
			{}, // Shop Button
			{}
	};
	
	
	//
	// 				image Data
	//
	public static String[] imageNames = {
			"images/minecraftTest.png",
			"images/MenuButton.png"
	};
	
	//info: width, height, number of frames, frames per row
	public static int[][] imageData = {
			{300, 168, 1, 1},
			{300, 100, 3, 1}
	};
	
}
