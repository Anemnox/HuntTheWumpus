/* TODO (This is Michael, here is a list of things I need:
 * Cave - I need methods to access the array content
 */

package main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import etc.MapCoordinates;
import graphics.*;
import graphics.UserInterface.ButtonAction;
import graphics.UserInterface.ButtonObject;
import main.gameboardEntities.CaveSystem;
import main.gameboardEntities.Player;
import main.wumpusConstructor.GameConstructor;
import triviaStructure.Question;

public class GameControl implements RunOnGameLoop {
	private Question question;
	private String gameState;
	private GameLoop mainLoop;
	private WumpusWindow window;
	
	
	private Player player;
	private MapCoordinates playerLoc, pit1, pit2, bat1, bat2;
	private int movement;
	
	private CaveSystem caveMap;
	
	private ArrayList<Object> deck;
	private ArrayList<Object> discard;
	private Object caveMap;
	
	/**
	 * Method to construct the GameControl object
	 */
	public GameControl() {
		mainLoop = new GameLoop(this, 100, true);
		//window = GameConstructor.testTriviaDisplay();
		window = GameConstructor.initializeWindow();
		startMenu();
		mainLoop.start();
		
		caveMap = new CaveSystem();
		
	}

	/**
	 * Method to set the game window to display the start screen
	 */
	public void startMenu() {
		GameConstructor.initializeMenu(window);
	}
	
	public void status() {
        //Return the status of the player, Calls Player
    }
	
	/**
	 * Method to move the player to a new room
	 * @param dir Input from 0-5, clockwise. 0 represents an upward movement
	 * and 5 represents a up-left movement.
	 */
    public void move(int dir) {
    	playerLoc.move(dir);
    }

    /**
     * Method to use gold to buy an arrow
     */
    public void buyArrow() {
        
    }

    public void displayTrivia(int x) {
    	//currentTrivia = new TriviaDisplayObject(Trivia.getTriviax());
    }
    
    /**
     * To be honest I have no idea how this would work
     */
    public void buyTips() {
        //Calls trivia for a quiz then returns a random tip
    }

    //
    //		Button Clicks
    //
    /**
     * Method to create a new game board for
     * @param gen The specific board to be generated (int)
     */
    public void startGameBoard() {
    	discard = new ArrayList<Object>(); //TODO initialize deck of cards
		deck = new ArrayList<Object>();

    	//TODO Communicate with Cave to determine which board to initialize
        //Creates new Player and calls map
    	player = new Player();
    	playerLoc = new MapCoordinates(0,0);
    	wumpus = new MapCoordinates(0,0);
    	pit1 = new MapCoordinates(0,0);
    	pit2 = new MapCoordinates(0,0);
    	bat1 = new MapCoordinates(0,0);
    	bat2 = new MapCoordinates(0,0);
    	
    	
    	GameConstructor.initializeGame(window);
    }

	public void displaySettings() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method to display the instruction screen
	 */
	public void displayInstructions() {
		// TODO Auto-generated method stub
		
	}
	
	public void exit() {
		
	}
	
    /**
     * Method to shoot an arrow into a room
     * @param dir Input from 0-5, clockwise. 0 represents an upward movement
	 * and 5 represents a up-left movement.
     */
    public void shootArrow(int dir) {
       switch (dir) {
	       case 0:
	    	   
	    	   break;
	       case 1:
	    	   
	    	   break;
	       case 2:
	    	   
	    	   break;
	       case 3:
	    	   
	    	   break;
	       case 4:
	    	   
	    	   break;
    	   default:
    		   System.out.println("This shouldn't happen (Shoot Arrow Error");
    		   break;
       }
    }

    public void death() {
        //calls graphic and loads a death screen
    }
    
    public void checkInput() {
    	try {
    		Point mousePoint = MouseInfo.getPointerInfo().getLocation();
    		Point windowPoint = window.getLocation();
    		Coordinate mouseCoords = new Coordinate(mousePoint.x - windowPoint.x, mousePoint.y - windowPoint.y);
    		window.getFrame().setMouseCoords(mouseCoords.getX(), mouseCoords.getY());
    		for(ButtonObject button : window.getFrame().getButtons()) {
    			
    			if(button.pointTouch(mouseCoords)) {
    				button.mouseHover();
    			} else {
    				button.noContact();
    			}
    		}
    		
    		if(window.getFrame().mouseDown() && caveMap != null) {
    			
    		}
    		
    	} catch(Exception e) {
    		
    	}
    }
    
    @Override
    public void update(double tick) {
    	 checkInput();
    	 window.getFrame().update(tick);
    }
    
    
}
