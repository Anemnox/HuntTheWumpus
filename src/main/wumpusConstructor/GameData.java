package main.wumpusConstructor;

import main.GameControl;

public class GameData {
	//
	//				Menu Screen
	//
	public static int[][] menuData = {
			//{x, y, width, height}
			{130, 150, 700, 400, 3}
	};
	
	public static int[][] menuButtonData = {
			//{x, y, width, height, imageID, tagID}
			{900, 100, 300, 100, 1, 0},
			{900, 250, 300, 100, 1, 1},
			{900, 400, 300, 100, 1, 2},
			{900, 550, 300, 100, 1, 3},
	};
	
	public static String[] buttonText = {
			"Play",
			"Manuel",
			"Options",
			"Exit"
	};
	
	
	//
	//				Game Screen
	//
	public static int[][] gameBoardData = {
			
	};
	
	public static int[][] gameBoardButtonData = {
			//{}, // Setting Button
			//{}, // Shop Button
			//{}
	};
	
	
	//
	// 				image Data
	//
	public static String[] imageNames = {
			"images/minecraftTest.png",
			"images/MenuButton.png",
			"images/Table Background large.png",
			"images/Title.png"
	};
	
	//info: width, height, number of frames, frames per row
	public static int[][] imageData = {
			{300, 168, 1, 1},
			{300, 100, 3, 1},
			{1366, 768, 1, 1},
			{700, 389, 1, 1}
	};
	
}
