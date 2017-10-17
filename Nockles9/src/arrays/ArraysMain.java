package arrays;

import java.util.Arrays;

public class ArraysMain 
{
	private String[] suits;
	private String[] values;
	private int[] testArray;
	
	public ArraysMain()
	{
		testArray = new int[50];
		// suits = new String[4];
		// suits[0] = "Clubs";
		// suits[1] = "Hearts";
		// suits[2] = "Diamonds";
		// suits[3] = "Spades";
		// values = new String[13];
		// for (int i = 0; i < values.length; i += 1)
		// {
		// 	values[i] = "" + (i + 1);
		// }
		// values[0] = "Ace";
		// values[12] = "King";
		// values[11] = "Queen";
		// values[10] = "Jack";
		populate1toN(testArray);
		// populate(testArray);
		// countOccurences(testArray, 2, 12);
		// swap(testArray, 0, 1);
		// shuffle(testArray);
		// reverseOrder(testArray);
		// testArray = subArray(testArray, 10, 5);
		System.out.println(Arrays.toString(testArray));
		// printCards(suits, values);
	}
	
	private int[] subArray(int[] arr, int psn, int length)
	{
		int[] finalArr = new int[length];
		for (int i = psn; i < (psn + length); i += 1)
		{
			finalArr[i - psn] = arr[i];
		}
		return finalArr;
	}
	
	private void reverseOrder(int[] arr)
	{
		for (int i = 0; i < (int)(arr.length / 2); i += 1)
		{
			swap(arr, i, (arr.length - 1) - i);
		}
	}
	
	private void printCards(String[] suitArr, String[] valueArr)
	{
		for (int i = 0; i < suitArr.length; i += 1)
		{
			for (int o = 0; o < valueArr.length; o += 1)
			{
				System.out.println(valueArr[o] + " of " + suitArr[i]);
			}
		}
	}
	
	private void shuffle(int[] arr)
	{
		for (int i = 0; i < arr.length; i += 1)
		{
			int rnd = (int)(Math.random() * arr.length);
			swap(arr, i, rnd);
		}
	}
	
	private void swap(int[] arr, int value1, int value2) 
	{
		int tempValue = arr[value1];
		arr[value1] = arr[value2];
		arr[value2] = tempValue;
	}

	private void populate1toN(int[] arr)
	{
		for (int i = 0; i < arr.length; i += 1)
		{
			arr[i] = i + 1;
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
