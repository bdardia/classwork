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

	public void setDirections() 
	{
		int failCount = 0;
		
		for (int i = 0; i < doors.length; i += 1)
		{
			try
			{
				System.out.println("There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails());
			}
			catch (NullPointerException e)
			{
				failCount += 1;
				if (failCount == 4)
				{
					System.out.println("There is no way out. You are trapped.");
				}
			}
		}
	}
	
	public static String toDirection(int dir)
	{
		String[] direction = {"the North", "the East", "the South", "the West"};
		try
		{
			return direction[dir];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return null;
		}
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
			System.out.println("You can only enter 'w', 's', 'a', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String inputChars = "wdsa";
		int direction = inputChars.indexOf(input);
		goToRoom(direction);
	}

	private boolean isValid(String input) 
	{
		String inputChars = "wdsa";
		return inputChars.indexOf(input) != -1 && input.length() == 1;
	}
	
	public static void setUpCaves()
	{
		CaveExplorer.caves = new CaveRoom[7][7];
		CaveRoom[][] c = CaveExplorer.caves;
		
		for (int row = 0; row < c.length; row += 1)
		{
			for (int col = 0; col < c[row].length; col += 1)
			{
				c[row][col] = new CaveRoom("This cave has coordinates " + row + ", " + col);
			}
		}
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
