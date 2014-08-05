/*
 * Defines sum of minimal and maximal values of the array elements
 * 
 */

import java.util.*;

public class MinMaxSum {

	public static void main(String[] args) {
		
		final int n = 25;	// number of elements in the array
		int[] arr = new int[n];
		int max, min;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt(100);
		}
		System.out.println("The array contains the elements: " + Arrays.toString(arr));
		
		max = min = arr[0];
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr [i];
			}
			if (arr[i] < min) {
				min = arr [i];
			}
		}
		System.out.println("Sum is " + (min + max) + " (min = " + min + ", max = " + max + " )");

	}

}
