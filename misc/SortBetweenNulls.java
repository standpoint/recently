/*
 * Sorts the array's parts that are placed between nulls
 */

import java.util.Arrays;
import java.util.Random;

public class SortBetweenNulls {

	public static void main(String[] args) {
		final int n = 20;
		int low = 0, high = 0;
		int[] ar = new int[n];
		boolean isBegin = true;
		boolean isSort = false;
		Random r = new Random();
		for (int i = 0; i<ar.length; i++) {
			ar[i] = r.nextInt(7);
		}
		System.out.println("Source array " + Arrays.toString(ar));
		for (int i = 0; i<ar.length; i++) {
			if (ar[i] == 0 && isBegin) {
				low = i;
				isBegin =! isBegin;
				isSort = true;
			}
			else if (ar[i] == 0 && !isBegin){
				high = i;
				Arrays.sort(ar, low, high);
				isBegin = true;
				isSort = true;
				i--;
			}
		}
		if (isSort) {
			System.out.println("Result array " + Arrays.toString(ar));
		}
		else {
			Arrays.sort(ar);
			System.out.println("Result array " + Arrays.toString(ar));
		}
	}

}
