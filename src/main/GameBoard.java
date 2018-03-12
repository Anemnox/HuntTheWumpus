package main;

public class GameBoard 
{
	public Coordinate3 playerLocation;
	public Coordinate3 wumpusLocation;
	
	private class Coordinate3 {
		int x;
		int y;
		int z;
		
		public Coordinate3(int inX, int inY, int inZ) {
			x = inX;
			y = inY;
			z = inZ;
		}
		
		
	}
}


