package arrays;

import java.util.Arrays;

public class ArraysMain 
{
	private String[] suits;
	private String[] values;
	private int[] testArray;
	
	public ArraysMain() {
		wednesdayMethods();
	}

	private void wednesdayMethods() {
		int[] diceRolls = new int[10000];
		populate(diceRolls);
		int[] data = longestConsecutiveSeqAndIndex(diceRolls);
		int max = 1;
		int longest = data[0];
		System.out.println("The longest sequence is " + 
				longest + " rolls. It happened on roll #"+data[1]+
				" the sequence was: "
				+ Arrays.toString(subArray(diceRolls, 
						data[1], data[0]))+".");
		while(longest != 11) {
			populate(diceRolls);
			data = longestConsecutiveSeqAndIndex(diceRolls);
			longest = data[0];
			if(longest > max) {
				max = longest;
				System.out.println("The longest sequence is " + 
						longest + " rolls. It happened on roll #"+data[1]+
						" the sequence was: "
						+ Arrays.toString(subArray(diceRolls, 
								data[1], data[0]))+".");
			}
		}
	}
		
		// testArray = new int[50];
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
		// populate1toN(testArray);
		// populate(testArray);
		// countOccurences(testArray, 2, 12);
		// swap(testArray, 0, 1);
		// shuffle(testArray);
		// reverseOrder(testArray);
		// testArray = subArray(testArray, 10, 5);
		// frontToBack(testArray);
		// System.out.println(longestConsecutiveSequence(testArray));
		// System.out.println(Arrays.toString(testArray));
		// printCards(suits, values);
	
	private int[] longestConsecutiveSeqAndIndex(int[] arr) {
		//use an int[] to store the data
		int[] data = new int[2];//element at zero is length, at 1 is position


		data[0] = 1;
		int currentCount = 1;
		for(int i = 0; i < arr.length; i++) {
			while(i + currentCount < arr.length && 
					isConsecutive(arr, i, i+currentCount)) {
				currentCount++;
			}
			if(currentCount > data[0]) {
				data[0] = currentCount;
				//also store the index where this sequence started
				data[1] = i;
			}
			i = i + currentCount-1;//saves time
			currentCount = 1;
		}
		return data;
	}
	
	private int longestConsecutiveSequence(int[] arr)
	{
		int finalCount = 0;
		int tempCount = 0;
		int tempIndex = 1;
		
		for (int i = 1; i < arr.length; i += 1)
		{
			if (isConsecutive(arr, tempIndex, i))
			{
				tempCount += 1;
			}
			else
			{
				tempIndex = i;
				if (tempCount > finalCount)
				{
					finalCount = tempCount;
				}
				tempCount = 1;
			}
		}
		
		
		return finalCount;
	}
	
	private boolean isConsecutive(int[] arr, int start, int end)
	{
		boolean consecutive = true;
		
		for (int i = start + 1; i < end; i += 1)
		{
			if (arr[i] != (arr[i - 1] + 1))
			{
				consecutive = false;
			}
		}
		
		return consecutive;
	}
	
	private void cycleThrough(int[] arr, int z)
	{
		for (int i = 0; i < z; i += 1)
		{
			frontToBack(arr);
		}
	}
	
	private int[] frontToBack(int[] arr)
	{
		int tempVal = 0;
		
		for (int i = 0; i < arr.length; i += 1)
		{
			if (i == 0)
			{
				tempVal = arr[arr.length - 1];
				arr[arr.length - 1] = arr[0];
			}
			else
			{
				arr[i - 1] = arr[i];
			}
		}
		
		return arr;
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
		for (int i = 0; i < (arr.length / 2); i += 1)
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
