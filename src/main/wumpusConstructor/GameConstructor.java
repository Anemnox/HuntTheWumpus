package main.wumpusConstructor;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import graphics.*;
import graphics.UserInterface.ButtonAction;
import graphics.UserInterface.ButtonObject;
import graphics.UserInterface.GameButtonObject;
import main.GameControl;
import main.gameboardEntities.CaveSystem;
import main.wumpusConstructor.*;

public class GameConstructor
{	
	// MAIN GAME CONTROLS
	public static GameControl controls;
	
	/**
	 * Method to create and return the game window
	 * @return A new WumpusWindow object
	 */
	public static WumpusWindow initializeWindow() {
		WumpusWindow window = new WumpusWindow(1366, 768);
		return window;
	}
	
	/**
	 * Method to set a window to display the start screen
	 * @param window Window used to display start screen
	 */
	public static void initializeMenu(WumpusWindow window) {
		window.getFrame().clearAll();
		window.getFrame().setBackground(getAnimation(2));
		//
		//  Buttons
		//
		for(int i = 0; i < GameData.menuButtonData.length; i++) {
			ButtonObject obj = new ButtonObject(getAnimation(GameData.menuButtonData[i][4]), new Coordinate(GameData.menuButtonData[i][0], GameData.menuButtonData[i][1]), 
					GameData.menuButtonData[i][2], GameData.menuButtonData[i][3]);
			obj.setText(GameData.buttonText[GameData.menuButtonData[i][5]]);
			window.getFrame().addButton(obj);
		};
		//
		//	Misc 
		//
		for(int i = 0; i < GameData.menuData.length; i++) {
			window.getFrame().add(new GraphicObject(getAnimation(GameData.menuData[i][4]), new Coordinate(GameData.menuData[i][0], GameData.menuData[i][1]), 
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
			ButtonObject button = new GameButtonObject(getAnimation(GameData.gameBoardButtonData[i][4]), 
					new Coordinate(GameData.gameBoardButtonData[i][0], GameData.gameBoardButtonData[i][1]), 
			GameData.gameBoardButtonData[i][2], GameData.gameBoardButtonData[i][3]);
			
			button.setText(GameData.buttonText[GameData.gameBoardButtonData[i][5]]);
			window.getFrame().addButton(button);
		};
		//
		//	Button Actions
		//
		try {
			window.getFrame().getButtons().get(3).setAction(
					new ButtonAction() {
						public void action() {
							controls.centerBoard();
						}

					}
					);
			window.getFrame().getButtons().get(0).setAction(
					new ButtonAction() {
						public void action() {
							controls.move();
						}

					}
				);
			window.getFrame().getButtons().get(1).setAction(
					new ButtonAction() {
						public void action() {
							controls.shootArrow();
						}

					}
				);
			window.getFrame().getButtons().get(2).setAction(
					new ButtonAction() {
						public void action() {
							controls.startScoreboard();//TODO change this later
						}

					}
				);
		} catch (Exception e) {
			
		}
		
		
		
		
		//
		//	Misc 
		//
		for(int i = 0; i < GameData.gameBoardData.length; i++) {
			window.getFrame().add(new GraphicObject(null, new Coordinate(GameData.menuData[i][0], GameData.menuData[i][1]), 
					GameData.menuData[i][2], GameData.menuData[i][3]));
		}
	}
	
	public static void initializeScoreboard(WumpusWindow window) {
		window.getFrame().clearAll();
		//
		//  Buttons
		//
		for(int i = 0; i < GameData.scoreboardButtonData.length; i++) {
			ButtonObject button = new GameButtonObject(getAnimation(GameData.gameBoardButtonData[i][4]), 
					new Coordinate(GameData.gameBoardButtonData[i][0], GameData.gameBoardButtonData[i][1]), 
			GameData.gameBoardButtonData[i][2], GameData.gameBoardButtonData[i][3]);
			
			button.setText(GameData.buttonText[GameData.gameBoardButtonData[i][5]]);
			window.getFrame().addButton(button);
		};
	}
	
	
	
	//
	//		IMAGE LOADERS
	//
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
		try {
			Animation animation = new Animation(getImageResource(id), GameData.imageData[id][0], GameData.imageData[id][1],
					 GameData.imageData[id][2], GameData.imageData[id][3]);
			return animation;
		} catch(Exception e) {
			return null;
		}
	}
}
