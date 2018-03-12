package main;

public class GameControl implements RunOnGameLoop{
	
	public GameControl() {
		
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

    @Override
    public void update(double tick) {
    	
    }
}
