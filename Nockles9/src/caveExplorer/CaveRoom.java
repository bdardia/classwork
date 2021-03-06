package caveExplorer;

public class CaveRoom 
{
	private String description;
	private String directions;
	private String contents;
	private String defaultContents;
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) 
	{
		this.description = description;
		setDefaultContents(" ");
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDirections() {
		return directions;
	}
	
	public Door getDoor(int direction)
	{
		return doors[direction];
	}

	public void setDirections() 
	{
		this.description = "";
		for (int i = 0; i < doors.length; i += 1)
		{
			if (this.doors[i] != null)
			{
				this.description += "There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
			}
		}
		if (this.description.equals(""))
		{
			this.description = "There is no way out. You are trapped in this room";
		}
		
	}
	
	public static String toDirection(int dir)
	{
		String[] direction = {"the North", "the East", "the South", "the West"};
		return direction[dir];
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public void enter()
	{
		contents = "X";
	}
	
	public void leave()
	{
		contents = defaultContents;
	}
	
	public void setConnection(int direction, CaveRoom anotherRoom, Door door)
	{
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	public void addRoom(int dir, CaveRoom caveRoom, Door door) 
	{
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();
	}

	public static int oppositeDirection(int direction) 
	{
		return (direction + 2) % 4;
	}

	public void interpretInput(String input)
	{
		while(!isValid(input))
		{
			printValidMoves();
			input = CaveExplorer.in.nextLine();
		}
		int direction = validMoves().indexOf(input);
		if (direction < 4)
		{
			goToRoom(direction);	
		}
		else
		{
			performAction(direction);
		}
	}

	public void performAction(int direction)
	{
		CaveExplorer.print("That key does nothing.");
	}
	
	public void printValidMoves()
	{
		CaveExplorer.print("You can only enter 'w', 's', 'a', or 'd'.");
	}
	
	private boolean isValid(String input) 
	{
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	
	public String validMoves()
	{
		return "wdsa";
	}
	
	public static void setUpCaves()
	{
		CaveExplorer.caves = new NPCRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves;
		
		for (int row = 0; row < c.length; row += 1)
		{
			for (int col = 0; col < c[row].length; col += 1)
			{
				c[row][col] = new NPCRoom("This cave has coordinates " + row + ", " + col);
			}
		}
		NPC testNPC = new NPC();
		testNPC.setPosition(1, 2);
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = testNPC;
		
		// replace some default rooms with custom rooms (save for later)
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
	}
	
	public void goToRoom(int direction)
	{
		if (borderingRooms[direction] != null && doors[direction] != null && doors[direction].isOpen())
		{
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
		else
		{
			System.err.println("You can't do that");
		}
	}
}
