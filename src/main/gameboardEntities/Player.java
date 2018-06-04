package main.gameboardEntities;

// The player object stores all data regarding the player
public class Player implements GameEntity{
	
	private int wumpusHits;
	private int arrows;
	private int gold;
	private int turns;
	
	public Player() {
		turns = 0; 
		gold = 3;
		arrows = 2;
	}
	
	public void setArrows(int setAmount) { // Force sets the arrow count of the player
		arrows = setAmount;
	}
	
	public int getArrows() { // Returns how many arrows the player has
		return arrows;
	}
	
	public void incArrow() { // Increases the arrow count by 1
		arrows++;
	}
	
	public void decArrow() { // Decreases the arrow count by 1
		arrows--;
	}
	
	public void setGold(int setAmount) { // Force sets the gold count of the player
		gold = setAmount;
	}
	
	public int getGold() { // Returns how much gold the player has
		return gold;
	}
	
	public void incGold() { // Increases the gold count by 1
		gold++;
	}
	
	public void decGold() { // Decreases the gold count by 1
		gold--;
	}
	
	public void setTurns(int setAmount) {
		turns = setAmount;
	}
	
	public int getTurns() {
		return turns;
	}
	
	public void incTurns() {
		turns++;
	}

	public int calculateScore() {
		int score;
		score = (wumpusHits * 10) + gold + (arrows * 2) - turns;
		return score;
	}

	
}
