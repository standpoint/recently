/*
 * Sorts the parts of the array which are separated by nulls
 * 
 */

import java.util.*;

public class SortNullSeparators {

	public static void main(String[] args) {
		final int n = 20;
		int[] ar = new int[n];
		int low, high;
		Random r = new Random();

		for (int i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt(10);
		}
		System.out.println(Arrays.toString(ar));
		low = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 0) {
				high = i;
				Arrays.sort(ar, low, high);
				low = i + 1;
			}
		}
		if (low != 0) {
			high = ar.length;
			Arrays.sort(ar, low, high);
			System.out.println(Arrays.toString(ar));
		}
		else {
			System.out.println("There are no one null at all - nothing to sort");
		}
		
		
	}

}
