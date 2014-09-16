/*
 * Sorts the array in the reverse order
 */

import java.util.*;

public class ReverseSort {

	public static void main(String[] args) {
		final int dim = 5;
		int[] ar = new int[dim];
		int[] res = new int[dim];
		Random r = new Random();
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt(25);
		}
		System.out.println(Arrays.toString(ar));
		
		Arrays.sort(ar);
		for (int i = (ar.length - 1), j = 0; i >= 0; i--, j++) {
			res[j] = ar[i];
		}
		System.out.println(Arrays.toString(res));

	}
}
