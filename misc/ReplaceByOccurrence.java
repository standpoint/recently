import java.util.Arrays;

import arraysextra.ArraysExtra;

/*
 * There are specified: array A[K], matrix B[N][M]. 
 * Needs to replace in B by zeroes those elements 
 * that have equal values in A.
 *     
 */

public class ReplaceByOccurrence {

	public static void main(String[] args) {
		
		final int K = 10, N = 5, M = 6;
		int[] a = new int[K];
		int[][] b = new int[N][M];
		ArraysExtra.initArray(a,10);
		ArraysExtra.initArray(b,10);
		ArraysExtra.printArray(a);
		ArraysExtra.printArray(b);
		Arrays.sort(a);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (Arrays.binarySearch(a, b[i][j]) >= 0) {
					Arrays.fill(b[i], j, j+1, 0);
				}
			}
		}
		ArraysExtra.printArray(b);
	}
}
