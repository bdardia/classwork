package arrays;

public class ArraysMain 
{
	private int[] testArray;
	
	public ArraysMain()
	{
		testArray = new int[5000];
		populate(testArray);
		countOccurences(testArray, 2, 12);
	}
	
	private void populate1toN(int[] arr)
	{
		for (int i = 0; i < arr.length; i += 1)
		{
			arr[i] = i;
		}
	}
	
	private void countOccurences(int[] arr, int start, int end) 
	{
		int[] counter = new int[end - start + 1];
		for (int value: arr)
		{
			counter[value - start] += 1;
		}
		for (int i = 0; i < counter.length; i += 1)
		{
			System.out.println("The value " + (i + start) + " was rolled " + counter[i] + " times");
		}
	}

	public void populate(int[] intArray)
	{
		for (int i = 0; i < intArray.length; i += 1)
		{
			int dieSum = diceRoll(2);
			intArray[i] = dieSum;
		}
	}
	
	public void arrayNotes()
	{
		// 2 ways to construct an array:
		int[] firstWay = {1, 2, 3, 4, 5, 6};
		int[] secondWay = new int[5];
		// Ways to iterate through arrays:
		for (int i = 0; i < secondWay.length; i += 1)
		{
			System.out.println(secondWay[i]);
		}
		for (int value: secondWay)
		{
			System.out.println(value);
		}
	}
	
	public static void main(String[] args)
	{
		ArraysMain sample = new ArraysMain();
		// Arrays are collections of primitives and objects
		// This is the only collection of primitives
		
		// Size cannot be edited
		// The elements of the array are references to objects
		// In other words, changing an element of the array changes the reference, not the object
	}
	
	public int diceRoll(int n)
	{
		int finalSum = 0;
		
		for (int i = 0; i < n; i += 1)
		{
			int rnd = (int)(Math.random() * 6) + 1;
			finalSum += rnd;
		}
		return finalSum;
	}
}
