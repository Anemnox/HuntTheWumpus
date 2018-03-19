package main;

public class GameBoard  implements RunOnGameLoop
{
	// The GameBoard handles the location of everything on the map
	
	
	
	/*
	private class Hex3 {
		int x;
		int y;
		int z;
		
		public Hex3(int inX, int inY, int inZ) {
			x = inX;
			y = inY;
			z = inZ;
			
			if(x + y + z != 0) {
				System.out.println("ERROR! [IMP_FORM] 3D coordinates are not in a proper format!");
			}
		}
		
		public int get(char desiredVector) {
			// This function returns the x, y, or z of the Hex3 coordinates. Returns -10000 if x, y, or z isn't returned
			switch (desiredVector) {
				case 'x':
					return x;
				case 'y':
					return y;
				case 'z':
					return z;
				default:
					System.out.println("ERROR! [INC_INDEX] Requested coordinate is not x, y, or z!");
					return -10000;
			}
		}
		
		public boolean matches(Hex3 compareTarget) {
			if(x == compareTarget.get('x') && y == compareTarget.get('y') && z == compareTarget.get('z')) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// TODO Make sure the move command loops the player around the map
		public void move(int direction) {
			// Moves this coordinate in one of six directions.
			// Input:	0	| 1		  | 2		  | 3		| 4		   | 5
			// Moves:	Up	| UpRight | DownRight | Down	| DownLeft | UpLeft
			// Prints an error in the console if an int outside of 0-5 is used.
			switch(direction) {
				case 0:
					y += 1;
					z -= 1;
					break;
				case 1:
					x += 1;
					z -= 1;
					break;
				case 2:
					x += 1;
					y -= 1;
					break;
				case 3:
					z += 1;
					y -= 1;
					break;
				case 4:
					z += 1;
					x -= 1;
					break;
				case 5:
					y += 1;
					x -= 1;
					break;
				default:
					System.out.println("ERROR! [OOB] Out of Bounds on Hex3's move function!");
			}
		}
		*/
		
		
	




	@Override
	public void update(double tick) {
		// TODO Auto-generated method stub
		
	}
}
