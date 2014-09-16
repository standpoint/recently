import java.util.*;

public class StepArray {

	/**
	 * Creates new step array</br>
	 * 1234</br>
	 * 123</br>
	 * 12</br>
	 * 1</br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int N = 4;
		Random r = new Random();
		int[][] ar = new int[N][];
		
		for (int i = 0; i < ar.length; i++ ) {
			ar[i] = new int[ar.length-i];
			for (int j = 0; j < ar[i].length; j++) {
				ar[i][j] = j+1;
			}
		}
		
		for (int[] mas:ar) {
			System.out.println(Arrays.toString(mas));
		}
	}

}
