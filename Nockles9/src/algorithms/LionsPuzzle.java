package algorithms;

public class LionsPuzzle 
{

	public static void main(String[] args) 
	{
		int numberOfLions = 101;
		if (willEat(numberOfLions))
		{
			System.out.println("Eat the sheep!");
		}
		else
		{
			System.out.println("Don't eat the sheep!");
		}
	}

	private static boolean willEat(int numberOfLions)
	{
		if (numberOfLions == 1)
		{
			return true;
		}
		else
		{
			return !(willEat(numberOfLions - 1));
		}
	}
}
