package algorithms;

public class RecursionExercises 
{
	private static int numFactors = 0;
	
	public static void main(String[] args)
	{
		int value = 18;
		System.out.println(value+"! is equal to "+factorial(value));
		System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
	}

	public static int countPrimeFactors(int value, int testPrime)
	{
		if (testPrime >= value)
		{
			return numFactors;
		}
		else if (value % testPrime == 0)
		{
			if (countPrimeFactors(testPrime, 2) == 0)
			{
				numFactors += 1;	
			}
			return countPrimeFactors(value / testPrime, testPrime);
		}
		else
		{
			return countPrimeFactors(value, testPrime + 1);
		}
	}
	 //
	public static int factorial(int value)
	{
		return 0;
	}
}
