package main;

import java.util.ArrayList;
import java.util.List;

// This class stores the data for the map, where everything is located, and the player's data

enum RoomFeature { PLAYER, WUMPUS, BAT, PIT }

public class GameBoard 
{
	// In my idea of how this will work, there will be a 2D List of rooms. The first index is room number.
	// The second index accesses a List of enumerations that show what all is in the room
	// vv Room #   vv ArrayList of things in room
	List<List<RoomFeature>> rooms = new ArrayList<List<RoomFeature>>();
	// Why I can make an ArrayList go into a List and not a List into a List is beyond me
	
	
	
}


