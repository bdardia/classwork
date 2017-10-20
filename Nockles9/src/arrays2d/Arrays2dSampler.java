package arrays2d;

public class Arrays2dSampler 
{
	private String[][] pic;
	
	public Arrays2dSampler()
	{
		pic = new String[10][20];
		print(pic);
	}

	private void print(String[][] pic) 
	{
		for (int row = 0; row < pic.length; row += 1)
		{
			for (int col = 0; col < pic[row].length; col += 1)
			{
				System.out.print(pic[row][col]);
			}
			System.out.println("");
		}
		
		for (String[] row : pic)
		{
			for (String col : row)
			{
				System.out.print(col);
			}
			System.out.println("");
		}
	}
}
