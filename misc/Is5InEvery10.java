import java.util.*;

public class Is5InEvery10 {

	public static void main(String[] args) {
		final int dim = 40;
		int[] ar = new int[dim];
		Random r = new Random();
		boolean isFive = false, nextDec = true;
		int num = 0;
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt(10);
			if (i%9 == 0) {
				nextDec = true;
				isFive = false;
			}
			if (ar[i] == 5 && nextDec && !isFive) {
				num++;
				isFive = true;
				nextDec = false;
			}
			
		}
		System.out.println(Arrays.toString(ar));
		System.out.println(num);
		
		

	}

}
