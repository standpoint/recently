/*
 * Reverse source array
 */

import java.util.Arrays;
import java.util.Random;

public class Reverse {

	public static void main(String[] args) {
		final int n = 5;
		int[] srcarr = new int [n];
		int[] destarr = new int [n];
		Random r = new Random();
		for (int i = 0; i < srcarr.length; i++) {
			srcarr[i] = r.nextInt()/(int)1.0e8;
		}
		System.out.println(Arrays.toString(srcarr));
		for (int i = srcarr.length-1, j = 0; i >= 0; i--, j++ ) {
			destarr[j] = srcarr[i];
		}
		System.out.println(Arrays.toString(destarr));
	}

}
