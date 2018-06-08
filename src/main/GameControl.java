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
import main.gameboardEntities.Dice;
import main.gameboardEntities.GameEntity;
import main.gameboardEntities.Player;
import main.wumpusConstructor.GameConstructor;
import triviaStructure.Question;

public class GameControl extends Thread implements RunOnGameLoop {
	private Question question;
	private String gameState;
	private GameLoop mainLoop;
	private WumpusWindow window;
	private Coordinate mouseCoords;
	
	//private MapCoordinates playerLoc, pit1, pit2, bat1, bat2;
	//private int movement;
	
	private boolean isHolding;
	private Coordinate holdPoint;
	private Coordinate cameraPoint;
	
	private ArrayList<Object> deck;
	private ArrayList<Object> discard;
	
	//
	//		Gameplay Variables
	//
	private CaveSystem caveMap;
	private ArrayList<GameEntity> listOfPlayers;
	private boolean gameIsRunning;
	private Dice dice;
	private int currentPlayer;
	private int turnNumber;
	private boolean turnEnd;
	private GameAction currentAction;
	private boolean rolledDice;
	private int diceRoll;
	private int totalMoves;
	private int targetDirection;
	
	enum GameAction {
		ROLL, DRAW_TRIVIA, DRAW_ACTION, MOVE, SHOOT, WAIT
	}
	
	/**
	 * Method to construct the GameControl object
	 */
	public GameControl() {
		mainLoop = new GameLoop(this, 100, true);
		//window = GameConstructor.testTriviaDisplay();
		window = GameConstructor.initializeWindow();
		startMenu();
		mainLoop.start();
		listOfPlayers = new ArrayList<>();
	}

	
    /**
     * To be honest I have no idea how this would work
     */
    public void buyTips() {
        //Calls trivia for a quiz then returns a random tip
    }
	
	
	public void status() {
        //Return the status of the player, Calls Player
    }
	
	/**
	 * Method to move the player to a new room
	 */
    public void move() {
    	currentAction = GameAction.MOVE;
    }

    /**
     * Method to use gold to buy an arrow
     */
    public void buyArrow() {
        
    }

    public void displayTrivia(int x) {
    	//currentTrivia = new TriviaDisplayObject(Trivia.getTriviax());
    }
    

    
    
    
    //
    //		Button Clicks
    //

    /**
	 * Method to set the game window to display the start screen
	 */
	public void startMenu() {
		GameConstructor.initializeMenu(window);
	}

	
    /**
     * Method to create a new game board for
     * @param gen The specific board to be generated (int)
     */
    public void startGameBoard() {
    	discard = new ArrayList<Object>(); //TODO initialize deck of cards
		deck = new ArrayList<Object>();

		
    	//TODO Communicate with Cave to determine which board to initialize
        
		
    	GameConstructor.initializeGame(window);
    	caveMap = new CaveSystem(window.getFrame());
    	dice = new Dice(GameConstructor.getAnimation(6));
    	dice.setAction(
    		new ButtonAction() {
	    		public void action() {
	    			currentAction = GameAction.ROLL;
				}
    	});
    	
    	listOfPlayers.add(new Player(null));
    	listOfPlayers.add(new Player(null));
		window.getFrame().addButton(caveMap);
		window.getFrame().addButton(dice);
		System.out.println("Populating Caves");
		caveMap.populateCaves(listOfPlayers);
		start();
    }

    /**
     * Method to display the settings screen
     */
    
	public void displaySettings() {
		// TODO Auto-generated method stub
		
	}

	
	
	/**
	 * Method to display the instruction screen
	 */
	public void displayInstructions() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Method to Exit the game
	 */
	public void exit() {
		
	}
	
	
	//
	//   Game Play
	//
	public void run() {
		gameIsRunning = true;
		currentPlayer = 0;
		turnNumber = 1;
		currentAction = GameAction.WAIT;
		diceRoll = 1;
		totalMoves = 0;
		targetDirection = 0;
		turnEnd = false;
		while(gameIsRunning) {
			//System.out.println("Game is running");
			if(currentAction != GameAction.WAIT) {
				Player player = (Player)(listOfPlayers.get(currentPlayer));
				switch(currentAction) {
				case ROLL:
					if(!rolledDice) {
						for(int i = 0; i < 20; i++) {
							dice.rollAnimation();
							try {
								Thread.sleep(60);
							} catch (Exception e) {
								
							}
						}
						diceRoll = dice.rollDice();
						rolledDice = true;
					}
					
					currentAction = GameAction.WAIT;
					break;
				case MOVE:
					if(rolledDice) {
						if(caveMap.getCave(player.getPosition()).possibleDoorway(caveMap.focusedCave().getID())) {
							caveMap.getCave(player.getPosition()).removeEntity(player);
							caveMap.focusedCave().addEntity(player);
							player.setPosition(caveMap.focusedCave().getID());
							totalMoves++;
						} else {
							System.out.println("Not possible");
							System.out.println(player.getPosition() + "    " + caveMap.focusedCave().getID());
						}
					}
					currentAction = GameAction.WAIT;
					break;
				case SHOOT:
					
					
					currentAction = GameAction.WAIT;
					break;
				case DRAW_TRIVIA:
					
					
					currentAction = GameAction.WAIT;
					break;
				case DRAW_ACTION:
					
					
					currentAction = GameAction.WAIT;
					break;
				
				default:
					
					
					break;
					
				}
				
				if(totalMoves >= diceRoll) {
					turnEnd = true;
				}
				
				if(turnEnd) {
					currentPlayer ++;
					totalMoves = 0;
					rolledDice = false;
					currentAction = GameAction.WAIT;
					if(currentPlayer > listOfPlayers.size() - 1) {
						currentPlayer = 0;
						turnNumber ++;
					}
					turnEnd = false;
				}
				
				
				
				
				
				
				
				
				
				
				
				
			} else {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					
				}
			}
			
		}
	}
	
	public void setGameAction(GameAction action) {
		currentAction = action;
	}
	
	
	public void playTrivia() {
		
	}
	
	public void centerBoard() {
		// TODO Auto-generated method stub
		caveMap.setCamera(1,  1);
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
    
    
    
    //
    //		GUI Code
    //
    public void checkInput() {
    	try {
    		Point mousePoint = MouseInfo.getPointerInfo().getLocation();
    		Point windowPoint = window.getLocation();
    		mouseCoords = new Coordinate(mousePoint.x - windowPoint.x, mousePoint.y - windowPoint.y);
    		window.getFrame().setMouseCoords(mouseCoords.getX(), mouseCoords.getY());
    		for(ButtonObject button : window.getFrame().getButtons()) {
    			
    			if(button.pointTouch(mouseCoords)) {
    				button.mouseHover();
    			} else {
    				button.noContact();
    			}
    		}
    		
    		if(window.getFrame().mouseDown() && caveMap != null) {
    			if(!isHolding) {
    				isHolding = true;
    				holdPoint = new Coordinate(mouseCoords.getX(), mouseCoords.getY());
    				
    				//System.out.println("Mouse pressed");
    				//System.out.println("Hold Point: " + holdPoint);
    				//System.out.println("cameraPoint: " + cameraPoint);
    			} else {
    				Coordinate changeInDistance = new Coordinate(mouseCoords.getX() - holdPoint.getX(), mouseCoords.getY() - holdPoint.getY());
    				
    				caveMap.setCamera(changeInDistance.getX() + cameraPoint.getX(), 
    						changeInDistance.getY() + cameraPoint.getY());
    				//System.out.println("Map Coords: " + caveMap.getCameraX() + ", " + caveMap.getCameraY());
    			}
    		} else {
    			isHolding = false;
				cameraPoint = new Coordinate(caveMap.getSavedCameraX(), caveMap.getSavedCameraY());

    		}
    		
    	} catch(Exception e) {
    		
    	}
    }
    
    @Override
    public void update(double tick) {
    	 checkInput();
    	 window.getFrame().update(tick);
    }
    
    public Coordinate getMousePoint() {
    	return mouseCoords;
    }
    
    public GameAction getCurrentGameAction() {
    	return currentAction;
    }


	
}
