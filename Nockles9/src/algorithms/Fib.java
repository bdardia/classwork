package algorithms;

public class Fib 
{
	public Fib()
	{
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(nextInt(1));
	}
	
	public static int nextInt(int lastNum)
	{
		if (lastNum > 1)
		{
			return nextInt(lastNum - 1) + nextInt(lastNum);
		}
		else
		{
			return lastNum;
		}
	}
}
