package main;

public class MapCoordinates  implements RunOnGameLoop
{
	// CONVERT INDEX TO COORDINATES
	// x = index / height
	// y = (index % height) - 1
	
	// CONVERT COORDINATES TO INDEX
	// index = (x * height) + y + 1
	
	// The GameBoard handles the location of everything on the map
	private int xCoor;
	private int yCoor;
	
	public MapCoordinates(int x, int y) {
		xCoor = x;
		yCoor = y;
	}
	
	// Get and Set commands for the x coordinate
	public int getX() {
		return xCoor;
	}
	
	public void setX(int input) {
		xCoor = input;
	}
	
	// Get and Set commands for the y coordinate
	public int getY() {
		return yCoor;
	}
	
	public void setY(int input) {
		yCoor = input;
	}
	
	// Equals compares this objects coordinates with the coordinates of another object
	public boolean equals(MapCoordinates target) {
		if(xCoor == target.getX() && yCoor == target.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// The TestMove command checks if a movement can be made, using the Cave's walls
	public void testMove(int moveIndex) {
		switch (moveIndex) {
			case 0:
				// TODO Get Everett's code 
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			default:
				System.out.println("Error. Incorrect index");
		}
	}
	
	// The Move command is used to move the object's coordinates. 
	public void move(int moveIndex) {
		switch (moveIndex) {
			case 0:
				yCoor--;
				break;
			case 1:
				xCoor++;
				yCoor--;
				break;
			case 2:
				xCoor++;
				break;
			case 3:
				yCoor++;
				break;
			case 4:
				xCoor--;
				break;
			case 5:
				xCoor--;
				yCoor--;
				break;
			default:
				System.out.println("Error. Incorrect index");
		}
	}
	
	// Private functions to modify XY coordinates into index coordinates
	// TODO make functions

	@Override
	public void update(double tick) {
		// TODO Auto-generated method stub
		
	}
}