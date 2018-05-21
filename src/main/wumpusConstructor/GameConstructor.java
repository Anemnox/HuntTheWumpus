package main.wumpusConstructor;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import graphics.*;
import graphics.UserInterface.ButtonAction;
import graphics.UserInterface.ButtonObject;
import graphics.UserInterface.StatusBarObject;
import graphics.UserInterface.TriviaDisplayObject;
import main.GameControl;
import main.wumpusConstructor.*;

public class GameConstructor
{	
	// MAIN GAME CONTROLS
	public static GameControl controls;
	
	
	public static WumpusWindow initializeWindow() {
		WumpusWindow window = new WumpusWindow(1366, 768);
		return window;
	}
	
	public static void initializeMenu(WumpusWindow window) {
		window.getFrame().clearAll();
		//
		//  Buttons
		//
		for(int i = 0; i < GameData.menuButtonData.length; i++) {
			window.getFrame().addButton(
					new ButtonObject(getAnimation(GameData.menuButtonData[i][4]), new Coordinate(GameData.menuButtonData[i][0], GameData.menuButtonData[i][1]), 
					GameData.menuButtonData[i][2], GameData.menuButtonData[i][3])
					);
		};
		//
		//	Misc 
		//
		for(int i = 0; i < GameData.menuData.length; i++) {
			window.getFrame().add(new GraphicObject(null, new Coordinate(GameData.menuData[i][0], GameData.menuData[i][1]), 
					GameData.menuData[i][2], GameData.menuData[i][3]));
		}
		//
		//			Button Actions
		//
		//PlayButton
				window.getFrame().getButtons().get(0).setAction(
						new ButtonAction() {
							public void action() {
								controls.startGameBoard();
							}

						}
						);
				//InstructionFrame
				window.getFrame().getButtons().get(1).setAction(
						new ButtonAction() {
							public void action() {
								controls.displayInstructions();
							}
						});
				//SettingFrame
				window.getFrame().getButtons().get(2).setAction(
						new ButtonAction() {
							public void action() {
								controls.displaySettings();
							}
						});
				//Exit
				window.getFrame().getButtons().get(3).setAction(
						new ButtonAction() {
							public void action() {
								controls.exit();
							}
						});
	}
	
	//
	//				Initialize	GameBoard
	//
	public static void initializeGame(WumpusWindow window) {
		window.getFrame().clearAll();
		//
		//  Buttons
		//
		for(int i = 0; i < GameData.gameBoardButtonData.length; i++) {
			window.getFrame().addButton(
					new ButtonObject(null, new Coordinate(GameData.menuButtonData[i][0], GameData.menuButtonData[i][1]), 
					GameData.menuButtonData[i][2], GameData.menuButtonData[i][3])
					);
		};
		//
		//	
		//
		window.getFrame().add(
				new StatusBarObject(getAnimation(1)) 
				);
		
		//
		//	Misc 
		//
		for(int i = 0; i < GameData.gameBoardData.length; i++) {
			window.getFrame().add(new GraphicObject(null, new Coordinate(GameData.menuData[i][0], GameData.menuData[i][1]), 
					GameData.menuData[i][2], GameData.menuData[i][3]));
		}
		
	}
	
	
	//
	//			Test
	//
	public static WumpusWindow testTriviaDisplay() {
		WumpusWindow window = new WumpusWindow(1366, 768);
		window.getFrame().add(new TriviaDisplayObject(getAnimation(0), new Coordinate(300, 300), "This is not working"));
		for(int i = 0; i < GameData.menuData.length; i++) {
			window.getFrame().add(new GraphicObject(null, new Coordinate(GameData.menuData[i][0], GameData.menuData[i][1]), 
					GameData.menuData[i][2], GameData.menuData[i][3]));
		}
		for(int i = 0; i < GameData.menuButtonData.length; i++) {
			window.getFrame().addButton(new ButtonObject(null, new Coordinate(GameData.menuButtonData[i][0], GameData.menuButtonData[i][1]), 
					GameData.menuButtonData[i][2], GameData.menuButtonData[i][3]));
		}
		return window;
	}
	
	
	//IMAGE LOADERS
	public static BufferedImage getImageResource(int id) {
		try {
			//String current = new java.io.File( "." ).getCanonicalPath();
	        //System.out.println("Current dir:"+current);
			return ImageIO.read(ClassLoader.getSystemResource(GameData.imageNames[id]));
		} catch (Exception e) {
			System.err.println("Unable to find: " + GameData.imageNames[id]);
			return null;
		}
	}
	
	
	public static Animation getAnimation(int id) {
		Animation animation = new Animation(getImageResource(id), GameData.imageData[id][0], GameData.imageData[id][1],
				 GameData.imageData[id][2], GameData.imageData[id][3]);
		
		return animation;
	}
}
