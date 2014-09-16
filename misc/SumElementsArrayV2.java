/*
 * Finding sum of two-dimensional array' elements using method finds sum of one-dim array   
 * 
 */

import java.util.Random;

public class SumElementsArrayV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int N = 2, M = 2;
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
			sum += sumSimpleArray(mas);
		}
		return sum;
	}
	
	public static int sumSimpleArray(int[] ar) {

		int sum = 0;
		for (int el:ar) {
			sum += el;
		}
		return sum;
	}

}
