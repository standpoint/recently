import java.util.*;

// Removes every third element from the array

public class RemoveEveryThird {

	public static void main(String[] args) {
		final int n = 12;
		int[] srcarr = new int [n];
		int[] destarr = new int [n];
		Random r = new Random();
		for (int i = 0; i < srcarr.length; i++) {
			srcarr[i] = r.nextInt(15);
		}
		System.out.println(Arrays.toString(srcarr));
		int j = 0, k = 0;
		for (int i = 0; i < srcarr.length; i += 3, j += 2) {
			if (i <= srcarr.length - 2) {
				System.arraycopy(srcarr, i, destarr, j, 2);
				k = j + 2;
			}
			else {
				System.arraycopy(srcarr, i, destarr, j, (srcarr.length - i));
				k = j + srcarr.length - i;
				break;
			}
		}
		int [] result = Arrays.copyOf(destarr, k);
		System.out.println(Arrays.toString(result));

	}

}
