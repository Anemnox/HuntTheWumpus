package main;

import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingUtilities;

import graphics.Coordinate;
import graphics.GraphicObject;
import graphics.WumpusWindow;

public class GameControl implements RunOnGameLoop {
	private GameLoop mainLoop;
	private WumpusWindow window;
	
	
	public GameControl() {
		mainLoop = new GameLoop(this, 100, true);
		window = GameConstructor.initializeWindow();
		mainLoop.start();
	}
	
	public void status() {
        //Return the status of the player, Calls Player
    }

    public void move() {
        //Calls player or cave system and add gold
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
    		for(GraphicObject object : window.getFrame().getObjects()) {
    			if(object.pointTouch(mouseCoords)) {
    				object.mouseHover();
    			} else {
    				object.noContact();
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
