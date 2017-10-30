package caveExplorer;

public class TwoDArrayPractice 
{
	public static void main(String[] args)
	{
		String[][] pic = new String[6][10];
		
		for (String[] row: pic)
		{
			for (int col = 0; col < row.length; col += 1)
			{
				row[col] = " ";
			}
		}
		drawHorizontalLine(pic, 2);
		drawVerticalLine(pic, 3);
		// drawSlot(pic, 4, 6);
		drawBox(pic, 4, 6);
		print(pic);
	}
	
	private static void drawBox(String[][] pic, int y, int x) 
	{
		boolean drawXMinus1 = !(x == 0);
		boolean drawYMinus1 = !(y == 0);
		boolean drawXPlus1 = !(x >= pic[y].length - 1);
		boolean drawYPlus1 = !(y >= pic.length - 1);
		
		if (drawXMinus1)
		{
			pic[y][x - 1] = "|";
			if (drawYPlus1)
			{
				pic[y + 1][x - 1] = "|";
			}
		}
		if (drawYMinus1)
		{
			pic[y - 1][x] = "-";
			if (drawXPlus1)
			{
				pic[y - 1][x + 1] = "-";
			}
			if (drawXMinus1)
			{
				pic[y - 1][x - 1] = "-";
			}
		}
		if (drawXPlus1)
		{
			pic[y][x + 1] = "|";
			if (drawYPlus1)
			{
				pic[y + 1][x + 1] = "|";	
			}
		}
		if (drawYPlus1)
		{
			pic[y + 1][x] = "_";
		}
	}

	private static void drawSlot(String[][] pic, int y, int x) 
	{
		if (x == 0)
		{
			pic[y][x + 1] = "|";
		}
		else if (y >= pic[y].length - 1)
		{
			pic[y][x - 1] = "|";
		}
		else
		{
			pic[y][x - 1] = "|";
			pic[y][x + 1] = "|";
		}
	}

	private static void drawVerticalLine(String[][] pic, int index) 
	{
		for (int i = 0; i < pic.length; i += 1)
		{
			pic[i][index] = "|";
		}
	}

	private static void drawHorizontalLine(String[][] pic, int index) 
	{
		for (int i = 0; i < pic[index].length; i += 1)
		{
			pic[index][i] = "-";
		}
	}

	private static void print(String[][] pic)
	{
		for (String[] row: pic)
		{
			for (int col = 0; col < row.length; col += 1)
			{
				System.out.print(row[col]);
			}
			System.out.println(" ");
		}
	}
}
