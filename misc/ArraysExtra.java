package arraysextra;
import java.util.Random;

/*
 * ArraysExtra contains some useful methods for working with arrays:
 * 	void initArray(int[] ar)
 * 	void initArray(int[] ar, int n) 
 * 	void initArray(int[][] ar)
 * 	void initArray(int[][] ar, int n)
 * 	void printArray(int[] ar)
 * 	void printArray(int[][] ar)
 * 	int findMax(int[] ar)
 * 	int findMin(int[] ar)
 * 	int findMax(int[][] ar)
 * 	int findMin(int[][] ar)
 * 	int sumElements(int[] ar)
 * 	int sumElements(int[][] ar)  
 * 
 */


public class ArraysExtra {
	
	/* 
	 * Initialize one-dimensional array early by Random.nextInt() method
	 * The array has been declared before 
	 */

	public static void initArray (int[] ar) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
				ar[i] = r.nextInt();
		}
	}

	/* 
	 * Initialize one-dimensional array early by Random.nextInt(n) method
	 * The array has been declared before 
	 */
	
	public static void initArray (int[] ar, int n) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
				ar[i] = r.nextInt(n);
		}
	}
	
	/* 
	 * Initialize two-dimensional array early by Random.nextInt() method
	 * The array has been declared before 
	 */
	
	public static void initArray(int[][] ar) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = r.nextInt();
			}
		}
	}
	
	/* 
	 * Initializes two-dimensional array early by Random.nextInt(n) method
	 * The array has been declared before 
	 */
	
	public static void initArray(int[][] ar, int n) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = r.nextInt(n);
			}
		}
	}
	
	/*
	 * Outputs to console passed array like raw of the elements separated by tabs
	 */
	
	public static void printArray(int[] ar) {
		
		for (int el : ar) {
			System.out.print(el + "\t");
		}
		System.out.println();
	}

	/*
	 * Outputs to console passed array like raws of the elements separated by tabs
	 */
	
	public static void printArray (int[][] ar) {
		
		for (int[] mas : ar) {
			System.out.println();
			for (int el : mas) {
				System.out.print(el + "\t");
			}
		}
		System.out.println();
	}
	
	/*
	 * Returns the value of maximal element of one-dimensional array
	 */
	
	public static int findMax(int[] ar) {
		
		int max = ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > max) {
				max = ar [i];
			}
		}
		return max;
	}
	
	public static float findMax(float[] ar) {
		
		float max = ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > max) {
				max = ar [i];
			}
		}
		return max;
	}
	
	/*
	 * Returns the value of minimal element of one-dimensional array
	 */
	
	public static int findMin(int[] ar) {
		
		int min = ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] < min) {
				min = ar [i];
			}
		}
		return min;
	}
	
	public static float findMin(float[] ar) {
		
		float min = ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] < min) {
				min = ar [i];
			}
		}
		return min;
	}

	
	/*
	 * Returns the value of maximal element of two-dimensional array
	 */
	
	public static int findMax(int[][] ar) {
		
		int max = findMax(ar[0]);
		for (int i = 0; i < ar[0].length; i++)
			if (findMax(ar[i]) > max) {
				max = findMax(ar[i]);
			}
		return max;
	}
	
	public static float findMax(float[][] ar) {
		
		float max = findMax(ar[0]);
		for (int i = 0; i < ar[0].length; i++)
			if (findMax(ar[i]) > max) {
				max = findMax(ar[i]);
			}
		return max;
	}
	
	/*
	 * Returns the value of maximal element of two-dimensional array
	 */
	
	public static int findMin(int[][] ar) {
		
		int min = findMin(ar[0]);
		for (int i = 0; i < ar[0].length; i++)
			if (findMin(ar[i]) < min) {
				min = findMin(ar[i]);
			}
		return min;
	}
	
	public static float findMin(float[][] ar) {
		
		float min = findMin(ar[0]);
		for (int i = 0; i < ar[0].length; i++)
			if (findMin(ar[i]) < min) {
				min = findMin(ar[i]);
			}
		return min;
	}
	
	/*
	 * Returns the sum of all elements of one-dimensional array
	 */
	
	public static int sumElements(int[] ar) {

		int sum = 0;
		for (int el:ar) {
			sum += el;
		}
		return sum;
	}
	
	/*
	 * Returns the sum of all elements of two-dimensional array
	 */
	
	public static int sumElements(int[][] ar) {
		
		int sum = 0;
		for (int[] mas : ar) {
			sum += sumElements(mas);
		}
		return sum;
	}
	
	/*
	 * Returns index of the raw with that contains element of two-dimensional array
	 */
	
	public static int rawMax(float[][] ar) {
		
		float max = findMax(ar[0]);
		int rawMax = 0;
		for (int i = 0; i < ar[0].length; i++)
			if (findMax(ar[i]) > max) {
				max = findMax(ar[i]);
				rawMax = i;
			}
		return rawMax;
		
	}

}
