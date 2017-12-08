package sort;

public class MainSort 
{

	public static void main(String[] args)
	{
		printDigits(292);
	}
	
	public MainSort() 
	{
		
	}
	
	public static void printDigits(int n)
	{
		int mod = 10;
		while (mod / 10 < n)
		{
			System.out.println((int)((n % mod)/(mod / 10)));
			mod *= 10;
		}
	}

}
