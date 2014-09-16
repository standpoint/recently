/*
 * Defines the index of the biggest positive element of the array
 *  
 */

import java.util.Arrays;
import java.util.Random;


public class IndexMaxPositive {

	public static void main(String[] args) {

		final int n = 10;	// number of elements in the array
		int[] arr = new int[n];
		int maxi, max;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt();
		}
		System.out.println("The array contains the elements: " + Arrays.toString(arr) + "\n");
		max = arr[0];
		maxi = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr [i];
				maxi = i;
			}
			
		}
		if (max > 0) {
			System.out.println("The index of the biggest positive element (" + max + ") of the array is " + maxi);
		}
		else {
			System.out.println("There are not any positive elemet in the array");
		}

	}

}
