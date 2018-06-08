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
			{1100, 100, 150, 70, 5, 4}, //Move
			{1100, 180, 150, 70, 5, 5}, //Shoot
			{1100, 260, 150, 70, 5, 6}, //Draw
			{580, 20, 150, 70, 5, 7}, // Center
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
			"images/ButtonTwo.png",
			"images/Rolling Dice.png",
			"images/Doors.png",
			"images/Player.png",
			"Player Display.png"
	};
	
	//info: width, height, number of frames, frames per row, Scaling 
	public static int[][] imageData = {
			{300, 168, 1, 1, 100},
			{300, 100, 3, 1, 100},
			{1366, 768, 1, 1, 100},
			{700, 389, 1, 1, 100},
			{100, 86, 4, 2, 100},
			{150, 70, 1, 1, 100},
			{130, 130, 15, 4, 100},
			{100, 86, 6, 3, 100},
			{34, 94, 4, 2, 100},
			{300, 200, 2, 1, 100}
	};
	
}
