import java.util.Arrays;
import java.util.Random;

/*
 * Swaps two elements of the array
 *  
 */
public class SwapTwoElements {

	public static void main(String[] args) {

		final int n = 10, j = 3, k = 5;	// number of elements in the array
		int temp;
		int[] arr = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt(10);
		}
		System.out.println("The array contains the elements: " + Arrays.toString(arr) + "\n");
		temp = arr [k];
		arr[k] = arr[j];
		arr[j] = temp; 
		System.out.println("Spwaped array: " + Arrays.toString(arr));
		
	}

}
