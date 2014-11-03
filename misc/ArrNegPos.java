/* 
 * Sort the array[n] such way: firstly negative and zero elements, then - positives. 
 * Order is stay the same as in the source array
 *
 */
import java.util.Arrays;
import java.util.Random;

public class ArrNegPos {

	public static void main(String[] args) {
		final int n = 20;
		int j = 0, k = 0;
		int[] srcarr = new int [n];
		int[] destarr1 = new int [n];
		int[] destarr2 = new int [n];
		Random r = new Random();
		for (int i = 0; i < srcarr.length; i++) {
			srcarr[i] = r.nextInt()/(int)1.0e8;
		}
		System.out.println(Arrays.toString(srcarr));
		
		for (int i = 0; i < srcarr.length; i++) {
			if (srcarr[i] <= 0) {
				destarr1[j] = srcarr[i];
				j++;
			}
			else {
				destarr2[k] = srcarr[i];
				k++;
			}
		}
		System.arraycopy(destarr2, 0, destarr1, j, k);
		System.out.println(Arrays.toString(destarr1));

	}

}
