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
		catch (Exception e)
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

}
