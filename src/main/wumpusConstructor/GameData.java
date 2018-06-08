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
			{1100, 340, 150, 70, 5, 7}, // Center
	};
	
	public static int[][] scoreboardButtonData = {
			{},
			{}
	};
	
	
	//
	// 				image Data
	//
	public static String[] imageNames = {
			"images/minecraftTest.png",		 		//0
			"images/MenuButton.png", 				//1
			"images/Table Background large.png", 	//2
			"images/Title.png", 					//3
			"images/Caves.png", 					//4
			"images/ButtonTwo.png", 				//5
			"images/Rolling Dice.png",				//6
			"images/Doors.png",						//7
			"images/Player.png",					//8
			"images/Player Display.png",			//9
			"images/CardFront.png",					//10
			"images/Scoreboard big boi.png",		//11
			"images/Scoreboard Small Bou.png"		//12
	};
	
	//info: width, height, number of frames, frames per row, Scaling 
	public static int[][] imageData = {
			{300, 168, 1, 1, 100},					//0
			{300, 100, 3, 1, 100},					//1
			{1366, 768, 1, 1, 100},					//2
			{700, 389, 1, 1, 100},					//3
			{100, 86, 4, 2, 100},					//4
			{150, 70, 1, 1, 100},					//5
			{130, 130, 15, 4, 100},					//6
			{100, 86, 6, 3, 100},					//7
			{34, 94, 4, 2, 100},					//8
			{300, 200, 2, 1, 100},					//9
			{500, 315, 1, 1, 100},					//10
			{409, 584, 1, 1, 100},					//11
			{381, 255, 1, 1, 100}					//12
	};
	
}
