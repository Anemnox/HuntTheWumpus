package main;

import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingUtilities;

import graphics.*;

public class GameControl implements RunOnGameLoop {
	private GameLoop mainLoop;
	private WumpusWindow window;
	private Player player;
	private MapCoordinates playerLoc, wumpus, pit1, pit2, bat1, bat2;
	
	private int movement;
	
	/**
	 * Method to construct the GameControl object
	 */
	public GameControl() {
		mainLoop = new GameLoop(this, 100, true);
		window = GameConstructor.testTriviaDisplay();
		mainLoop.start();
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

    /**
     * Method to start a new game
     */
    public void start() {
        //Creates new Player and calls map
    	player = new Player();
    	playerLoc = new MapCoordinates(0,0);
    	wumpus = new MapCoordinates(0,0);
    	pit1 = new MapCoordinates(0,0);
    	pit2 = new MapCoordinates(0,0);
    	bat1 = new MapCoordinates(0,0);
    	bat2 = new MapCoordinates(0,0);
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
    	} catch(Exception e) {
    		
    	}
    }
    
    @Override
    public void update(double tick) {
    	 checkInput();
    	 window.getFrame().update(tick);
    }
    
}
