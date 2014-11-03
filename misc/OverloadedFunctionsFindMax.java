import java.util.Random;


public class OverloadedFunctionsFindMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int N = 2, M = 2;
		final int A = 5, B = 7, C = 9;
		int[][] ar = new int[N][M];
		int[] arr = new int[N];
		initArray(ar);
		initArray(arr);
		System.out.println("a = " + A + "\tb = " + B + "\tc = " + C);
		System.out.println("Max of a and b: " + findMax(A,B));
		System.out.println("Max of a, b and c: " + findMax(A,B,C));
		printArray(ar);
		System.out.println("\n Max: " + findMax(ar) + "\n");
		printArray(arr);
		System.out.println("\n Max: " + findMax(arr) + "\n");
		System.out.println("Sum of max elements in every string: " + sumMaxInRaw(ar));

	}
	
	public static int findMax(int a, int b) {

		if (b > a) return b;
		return a;
	}
	
	public static int findMax(int a, int b, int c) {
		
		if (a > b && a > c) return a;
		else if (b > a && b > c) return c;
		return c;
	}
	
	public static int findMax(int[] ar) {
		
		int max = ar[0];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > max) {
				max = ar [i];
			}
		}
		return max;
	}
	
	public static int findMax(int[][] ar) {
		
		int max = findMax(ar[0]);
		for (int i = 0; i < ar[0].length; i++)
			if (findMax(ar[i]) > max) {
				max = findMax(ar[i]);
			}
		return max;
	}
	
	public static void initArray (int[] ar) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
				ar[i] = r.nextInt(20);
		}
	}

	
	public static void initArray (int[][] ar) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = r.nextInt(20);
			}
		}
	}
	
	public static void printArray (int[] ar) {
		
		for (int el : ar) {
			System.out.print(el + "\t");
		}
		System.out.println();
	}
	
	public static void printArray (int[][] ar) {
		
		for (int[] mas : ar) {
			System.out.println();
			for (int el : mas) {
				System.out.print(el + "\t");
			}
		}
		System.out.println();
	}
	
	public static int sumMaxInRaw(int[][] ar) {
		
		int[] mas = new int[ar.length];
		for (int i = 0; i < ar[0].length; i++) {
			mas[i] = findMax(ar[i]);
		}
		return SumElementsArrayV2.sumSimpleArray(mas);
	}
	
//	public static int sumSimpleArray(int[] ar) {
//
//		int sum = 0;
//		for (int el:ar) {
//			sum += el;
//		}
//		return sum;
//	}


}
