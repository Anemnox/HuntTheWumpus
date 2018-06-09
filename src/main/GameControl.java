/* TODO (This is Michael, here is a list of things I need:
 * Cave - I need methods to access the array content
 */

package main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingUtilities;

import graphics.*;
import graphics.UserInterface.ButtonAction;
import graphics.UserInterface.ButtonObject;
import graphics.UserInterface.PlayerDisplay;
import graphics.UserInterface.ScoreDisplay;
import graphics.UserInterface.WumpusHealth;
import main.actionCards.ActionCards;
import main.gameboardEntities.CaveSystem;
import main.gameboardEntities.Chest;
import main.gameboardEntities.Dice;
import main.gameboardEntities.GameEntity;
import main.gameboardEntities.Player;
import main.gameboardEntities.Wumpus;
import main.triviaStructure.TriviaManager;
import main.wumpusConstructor.GameConstructor;

public class GameControl extends Thread implements RunOnGameLoop {
	private TriviaManager question;
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
	private ArrayList<GameEntity> listOfEntities;
	private TriviaManager trivia;
	private ActionCards actionDeck;
	private Wumpus wumpus;
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
		ROLL, DRAW_TRIVIA, DRAW_ACTION, MOVE, SHOOT, WAIT, WAIT_TRIVIA, END_TURN
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
		listOfEntities = new ArrayList<>();
		
    	GameConstructor.initializeGame(window);
    	caveMap = new CaveSystem(window.getFrame());
    	dice = new Dice(GameConstructor.getAnimation(6));
    	dice.setAction(
    		new ButtonAction() {
	    		public void action() {
	    			currentAction = GameAction.ROLL;
				}
    	});
    	
    	wumpus = new Wumpus(GameConstructor.getAnimation(13), 5, 0); //TODO figure out health value & position
    	    	
    	listOfEntities.add(wumpus);
    	listOfEntities.add(new Chest());
    	listOfEntities.add(new Chest());
    	listOfEntities.add(new Chest());
    	listOfEntities.add(new Chest());
    	listOfEntities.add(new Chest());
    	listOfEntities.add(new Chest());
    	
    	
    	listOfPlayers.clear();
    	for(int i = 0; i < 3; i++) {
    		listOfPlayers.add(new Player(GameConstructor.getAnimation(8)));
    		((Player)listOfPlayers.get(i)).setSkin(i);
    		window.getFrame().add(new PlayerDisplay(new Coordinate(100, 50 + (230 * i)),
    			(Player)listOfPlayers.get(i)));
    	}
		window.getFrame().addButton(caveMap);
		window.getFrame().addButton(dice);
		
		try {
			trivia = GameConstructor.getTriviaManager();
			window.getFrame().addButton(trivia);
			for(int i = 0; i < 4; i++) {
			trivia.getButtons().get(0).setAction(new ButtonAction() {
				public void action() {
					trivia.setAnswer("a");
				}
			});
			}
			trivia.getButtons().get(1).setAction(new ButtonAction() {
				public void action() {
					trivia.setAnswer("b");
				}
			});
			trivia.getButtons().get(2).setAction(new ButtonAction() {
				public void action() {
					trivia.setAnswer("c");
				}
			});
			trivia.getButtons().get(3).setAction(new ButtonAction() {
				public void action() {
					trivia.setAnswer("d");
				}
			});
		} catch (Exception e) {
			
		}
		
		try {
			actionDeck = new ActionCards();
			window.getFrame().addButton(actionDeck);
		} catch (Exception e) {
			
		}
		System.out.println("Populating Caves");
		caveMap.populateCaves(listOfPlayers);
		caveMap.populateCaves(listOfEntities);
		System.out.println(wumpus);
    	window.getFrame().add(new WumpusHealth(wumpus));

		start();
    }

    
    
    /**
     * Method to display the settings screen
     */
    
	public void displaySettings() {
		// TODO Auto-generated method stub
		startScoreboard();
	}

	public void startScoreboard() {
		GameConstructor.initializeScoreboard(window);
		//listOfPlayers.add(new Player(GameConstructor.getAnimation(8)));
		for(int i = 0; i < listOfPlayers.size(); i++) {
			window.getFrame().add(new ScoreDisplay(listOfPlayers.get(i), GameConstructor.getAnimation(12), new Coordinate(100, 100)));
		}
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
			Player player = (Player)(listOfPlayers.get(currentPlayer));
			player.setTurn(true);
			if (currentAction == GameAction.WAIT_TRIVIA || trivia.isVisible){
				if(trivia.getResult() != -1) {
					currentAction = GameAction.WAIT;
					if(trivia.getResult() == 1) {
						System.out.println("RIGHT");
						if(player.isFighting()) {
							Random rand = new Random();

							player.fightWumpus(false);
							wumpus.takeDamage();
							if(wumpus.getHealth() != 0) {
								int pos = rand.nextInt(caveMap.getNumberOfCaves());
								while(!caveMap.getCave(pos).getEntities().isEmpty()) {
									pos = rand.nextInt(caveMap.getNumberOfCaves());
								}
								caveMap.getCave(wumpus.getPosition()).removeEntity(wumpus);
								wumpus.setPosition(pos);
								caveMap.getCave(pos).addEntity(wumpus);
								wumpus.setPosition(pos);	
								
							} else {
								startScoreboard();
							}
						}
					} else {
						Random rand = new Random();

						System.out.println("WRONG");
						player.triviaFailed();
						if(player.isFighting()) {
							player.fightWumpus(false);
							caveMap.getCave(player.getPosition()).removeEntity(player);
							int pos = rand.nextInt(caveMap.getNumberOfCaves());
							player.setPosition(pos);
							caveMap.getCave(pos).addEntity(player);
							player.setPosition(pos);
	
						}
						endTurn();
					}
					caveMap.setFocus(true);
					trivia.setVisible(false);
				}
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					
				}
			
			} else if(currentAction != GameAction.WAIT) {
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
						player.changeMoves(diceRoll);
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
							player.changeMoves(-1);
						} else {
							System.out.println("Not possible");
							System.out.println(player.getPosition() + "    " + caveMap.focusedCave().getID());
						}
						if(caveMap.getCave(player.getPosition()).getEntities().size() > 1) {
							caveMap.getCave(player.getPosition()).interact();
						}
						if(player.isFighting()) {
							playTrivia();
						}
					}
					if(!player.isFighting()) {
						currentAction = GameAction.WAIT;
					}
					break;
				case SHOOT:
					if (!player.getShot() && player.getArrows() > 0 && rolledDice) {
						player.changeMoves(-1);
						player.setShot(true);
						player.changeArrow(-1);
						if (caveMap.focusedCave() == caveMap.getCave(wumpus.getPosition())) {
							wumpus.takeDamage();
							player.hitWumpus();
						} else {
							for (GameEntity ge : listOfPlayers) {
								if (caveMap.focusedCave() == caveMap.getCave(ge.getPosition())) {
									for(int i = 0; i < 20; i++) {
										dice.rollAnimation();
										try {
											Thread.sleep(60);
										} catch (Exception e) {
											
										}
									}
									int roll = dice.rollDice();
									System.out.println(roll);
									if (roll == 1) {
										System.out.println("missed");
									} else if (roll < 6) {
										((Player)ge).changeMoves(-(roll - 1));
										System.out.println("Enemy slowed for: " + (roll - 1));
									} else {
										((Player)ge).changeMoves(-6);
										System.out.println("Player stunned");
									}
									break;
								}
							}
						}
					}
					
					currentAction = GameAction.WAIT;
					break;
				case DRAW_TRIVIA:
					System.out.println("PLAYING TRIVIA");
					trivia.newQuestion();
					trivia.setVisible(true);
					caveMap.setFocus(false);
					currentAction = GameAction.WAIT_TRIVIA;
					break;
				case DRAW_ACTION:
					
					
					currentAction = GameAction.WAIT;
					break;
				case END_TURN:
				
					turnEnd = true;
					currentAction = GameAction.WAIT;
				default:
						
					break;
					
				}
				
				if((currentAction != GameAction.DRAW_TRIVIA && player.getNumberOfMoves() <= 0 && rolledDice) || player.getNumberOfMoves() == -6) {
					turnEnd = true;
				}
				
				if(turnEnd) {
					player.setMoves(0);
					player.setShot(false);
					player.setTurn(false);
					player.setMoves(0);
					currentPlayer ++;
					rolledDice = false;
					currentAction = GameAction.WAIT;
					if(currentPlayer > listOfPlayers.size() - 1) {
						currentPlayer = 0;
						turnNumber ++;
						caveMap.addTurn();
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
		currentAction = GameAction.DRAW_TRIVIA;
	}
	
	public void drawAction() {
		
	}
	
	public void centerBoard() {
		// TODO Auto-generated method stub
		caveMap.setCamera(1,  1);
	}
	
	public void endTurn() {
		currentAction = GameAction.END_TURN;
	}
	
    /**
     * Method to shoot an arrow into a room
     * @param dir Input from 0-5, clockwise. 0 represents an upward movement
	 * and 5 represents a up-left movement.
     */
    public void shootArrow() {
       currentAction = GameAction.SHOOT;
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
    		
    		if(window.getFrame().mouseDown() && caveMap != null && caveMap.isFocused()) {
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
