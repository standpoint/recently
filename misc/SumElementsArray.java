/*
 * Finding sum of two-dimensional array' elemets
 * 
 */

import java.util.Random;

public class SumElementsArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int N = 4, M = 6;
		int[][] ar = new int[N][M];
		
		initArray(ar);
		printArray(ar);
		System.out.println("\n\n Sum of Array' elemets: " + sumElemetsArray(ar));
		

	}
	
	// Initialize Array
	public static void initArray (int[][] ar) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = r.nextInt(20);
			}
		}
	}
	
	// Print Array
	
	public static void printArray (int[][] ar) {
		
		for (int[] mas : ar) {
			System.out.println();
			for (int el : mas) {
				System.out.print(el + "\t");
			}
		}
	}
	
	// Find Sum of Array' elements

	public static int sumElemetsArray(int[][] ar) {
		
		int sum = 0;
		for (int[] mas : ar) {
			for (int el : mas) {
				sum += el;
			}
		}
		return sum;
	}

}
