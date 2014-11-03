import java.util.*;

public class SortPosNeg {

	public static void main(String[] args) {
		final int dim = 5;
		int[] ar = new int[dim];
		Random r = new Random();
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt();
		}
		System.out.println(Arrays.toString(ar));
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		int i;
		for (i = 0; i < ar.length && ar[i] < 0; i++);

		if (i > 0 && i < ar.length) {
			int[] res = new int[ar.length];
			System.arraycopy(ar, (i), res, 0, (ar.length - (i)));
			System.arraycopy(ar, 0, res, (ar.length - (i)), i);
			System.out.println(Arrays.toString(res));
		}
		else {
			System.out.println(Arrays.toString(ar));
		}
		
	}

}
