import java.util.Arrays;
import java.util.Random;

public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int n = 20;
		int[] ar = new int[n];
		Random r = new Random();
		for (int i = 0; i<ar.length; i++) {
			ar[i] = r.nextInt(100);
		}
		System.out.println("Source array \t" + Arrays.toString(ar));

		//insertion sort (сортировка вставкой)
		    int key;
		    int i;
		    for (int j = 1; j < ar.length; j++){
		        key = ar [j];
		        i = j - 1;
		        while (i >= 0 && ar [i] > key) {
		            ar [i + 1] = ar [i];
		            i--;
		        }
		        ar [i+1] = key;
		    }
		    System.out.println("(1) \t\t" + Arrays.toString(ar));
		    
		    
		//selection sort (сортировка выборкой)
		int start;
		int small;
		int temp;
		for (start = 0; start < ar.length; start++){
			small = start;
		  for (i = start + 1; i < ar.length; i++ ) {
		  	if (ar [i] < ar [small]) {
		      	small = i;
		      }
		  }
		  temp = ar [start];
		  ar [start] = ar [small];
		  ar [small] = temp;
		 }


		//Bubble Sort,or Straight Exchange Sort (пузырьковая или обменная сортировка)
		for (i = 0; i < ar.length  - 1; i++) {
		            for (int j = ar.length - 1; j > i; j--){
		                if (ar [j-1] > ar [j]) {
		                    temp = ar [j-1];
		                    ar [j-1] = ar [j];
		                    ar [j] = temp;
		                 }
		            }
		        }
	}

}
