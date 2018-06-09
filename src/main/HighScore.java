package main;

public class HighScore {
	
	// 100 - n + g + (10*a)
	// n = num of turns; g = gold ; a = arrows
	
	
	//Get this stuff from player person
	private int num;
	private int gold;
	private int arrows;
	
	
	
	private int totalScore;
	private String name;  //Name = Get 3 letters through scanner
	
	public HighScore(int n, int g, int a, String na)
	{
		name = na;
		totalScore = 100 - n + g + (10 * a);
	}
	
	
	
	
	public int getHighScore()
	{
		return totalScore;
	}
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name + totalScore;
	}
	
	
	

}
