package arrays2d;

import java.util.Arrays;

public class Main 
{
	public static void main(String[] args)
	{
		int[] arr = {4, 3, 2, 1, 0};
		changeNeighbors(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

	private static void changeNeighbors(int[] arr, int i) 
	{
		if (i == 0)
		{
			arr[i + 1] -= 1;
		}
		else if (i == (arr.length - 1))
		{
			arr[i - 1] -= 1;
		}
		else
		{
			arr[i + 1] -= 1;
			arr[i - 1] -= 1;
		}
		arr[i] += 1;
	}
}
