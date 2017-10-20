package arrays;

import java.util.Arrays;

public class PassByValuesExamples 
{
	public static void main(String[] args)
	{
		String s = "Hello";
		Person p = new Person("Random", "Dude", Borough.NY_BOROUGHS[0]);
		int x = 5;
		int[] arr = {1, 2, 3};
		test3(arr);
		System.out.println(p + " " + x + " " + Arrays.toString(arr));
	}
	
	private static void test1(Person p, int x, int[] arr) 
	{
		p.setFirstName("Original");
	}
	
	private static void test3(int[] arr)
	{
		arr[0] = 999;
		arr[1] = 998;
		arr[2] = 997;
	}

	public static void changeEverything(String s, int x, int[] arr)
	{
		s = "Goodbye";
		x = -5;
		arr = new int[2];
		arr[0] = -1;
		arr[1] = -2;
	}
}