import java.util.Random;


public class TwoDimensionalArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Random r = new Random();
		final int N = 4;
		final int M = 6;
		
		//initializing the array
		
		int[][] ar = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ar[i][j] = r.nextInt(20);
			}
		}
		
		//or this way
		
		int[][] arr = new int [N][];
		for (int i = 0; i < N; i++) {
			arr[i] = new int[M];
			for (int j = 0; j < M; j++) {
				arr[i][j] = r.nextInt(20);
			}
		}
		
		// printing the array this way
		
//		for (int i = 0; i < ar.length; i++) {
//			System.out.println();
//			for (int j = 0; j < ar[0].length; j++) {
//				System.out.print(ar[i][j] + "\t");
//			}
//		}
		
		// or such way
		
		for (int[] mas : ar) {
			System.out.println();
			for (int el : mas) {
				System.out.print(el + "\t");
			}
		}
		

	}

}
