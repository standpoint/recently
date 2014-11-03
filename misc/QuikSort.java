import java.util.Arrays;
import java.util.Random;


public class QuikSort {

	public static void main(String[] args) {
		
		final int n = 100000;
		int[] ar = new int[n];
		Random r = new Random();
		for (int i = 0; i<ar.length; i++) {
			ar[i] = r.nextInt(100);
		}
		printArray(ar);
		quickSort(ar,2,99998);
		printArray(ar);

	}
	
	static void quickSort (int ar [], int p, int r){
		
		int q = 0;
		if (p < r) {
			exchange(ar,p+(new Random().nextInt(r-p+1)),r);
			q = partition (ar, p, r);
			quickSort (ar, p, q-1);
			quickSort (ar, q + 1, r);
		}
	}

	static private int partition (int ar [], int p, int r){
	
		int pivot = ar [r];
		int i = p -1;
		for (int j = p; j <= r -1; j++) {
			if (ar [j] <= pivot) {
			    i++;
			    exchange (ar, i, j);
			}
		}
		exchange (ar, i+1, r);
		return i + 1;
	}
		
	public static void exchange(int[] ar, int i, int j) {

		int temp;
		temp = ar [i];
		ar [i] = ar [j];
		ar [j] = temp;
	}
		
	public static void printArray(int[] ar) {
			
		System.out.println(Arrays.toString(ar));
	}

}
