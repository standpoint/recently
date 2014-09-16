import java.util.Arrays;
import java.util.Random;


public class SortMethodes {

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
		System.out.println("Source array ");
		printArray(ar);

		//insertion sort
		insertionSort(ar);
		System.out.println("Insertion sort ");
		printArray(ar);
		    
		    
		//selection sort
		selectionSort(ar);
		System.out.println("Selection sort ");
		printArray(ar);


		//Bubble Sort,or Straight Exchange Sort
		bubbleSort(ar);
		System.out.println("Bubble sort ");
		printArray(ar);
		

	}

	public static void printArray(int[] ar) {
		
		System.out.println(Arrays.toString(ar));
	}
	
	public static void swap(int[] ar, int i, int j) {
		int temp;
		temp = ar [i];
		ar [i] = ar [j];
		ar [j] = temp;
	}

	public static void bubbleSort(int[] ar) {
		
		int i;
//		int temp;
		
		for (i = 0; i < ar.length  - 1; i++) {
            for (int j = ar.length - 1; j > i; j--){
                if (ar [j-1] > ar [j]) {
                	swap(ar,j-1,j);
                 }
            }
        }
	}

	public static void selectionSort(int[] ar) {
		
		int i;
		int start;
		int small;
//		int temp;
		
		for (start = 0; start < ar.length; start++){
			small = start;
			for (i = start + 1; i < ar.length; i++ ) {
				if (ar [i] < ar [small]) {
		      	small = i;
		      }
			}
			swap(ar, start, small);
		}
	}

	public static void insertionSort(int[] ar) {
		
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
	}

}
