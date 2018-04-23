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
        //Calls player or cave system and add gold
    	//player.move(dir);
    }

    public void buyArrow() {
        //Calls Players for gold and add an arrow
    }

    public void displayTrivia(int x) {
    	//currentTrivia = new TriviaDisplayObject(Trivia.getTriviax());
    }
    
    public void buyTips() {
        //Calls trivia for a quiz then returns a random tip
    }

    public void start() {
        //Creates new Player and calls map
    	player = new Player();
    	
    }

    
    public void shootArrow() {
        //Calls map and checks to see if arrow hits Wumpus and removes an arrow
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
