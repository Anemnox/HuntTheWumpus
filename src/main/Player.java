package main;

public class Player {
	
	private int arrows;
	private int gold;
	
	public Player() {
		
	}
	
	
	public void setArrows(int setAmount) {
		arrows = setAmount;
	}
	
	public int getArrows() {
		return arrows;
	}
	
	public void decrementArrow() {
		arrows--;
	}
	
	public void setGold(int setAmount) {
		gold = setAmount;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void incrementGold() {
		gold++;
	}
}
