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
			"Manual",
			"Options",
			"Exit",
			"Move",
			"Shoot",
			"Draw",
			"Center"
	};
	
	
	//
	//				Game Screen
	//
	public static int[][] gameBoardData = {
			
	};
	
	public static int[][] gameBoardButtonData = {
			//{}, // Setting Button
			//{}, // Shop Button
			{1000, 50, 300, 100, 5, 4}, //Move
			{1000, 150, 300, 100, 5, 5}, //Shoot
			{1000, 250, 300, 100, 5, 6}, //Draw
			{500, 10, 300, 100, 5, 7}, // Center
	};
	
	
	//
	// 				image Data
	//
	public static String[] imageNames = {
			"images/minecraftTest.png",
			"images/MenuButton.png",
			"images/Table Background large.png",
			"images/Title.png",
			"images/Caves.png",
			"images/Button Two.png",
			"images/Rolling Dice.png",
			"images/Doors.png"
	};
	
	//info: width, height, number of frames, frames per row, Scaling 
	public static int[][] imageData = {
			{300, 168, 1, 1, 100},
			{300, 100, 3, 1, 100},
			{1366, 768, 1, 1, 100},
			{700, 389, 1, 1, 100},
			{100, 86, 4, 2, 100},
			{100, 50, 1, 1, 100},
			{130, 130, 15, 4, 100},
			{100, 86, 6, 3, 100},
	};
	
}
