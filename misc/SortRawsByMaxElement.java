import arraysextra.ArraysExtra;

/*
 * There is array MAS[N][M].
 * Sort this one ascending of maximal elements in every row.
 * 
 */
public class SortRawsByMaxElement {

	public static void main(String[] args) {
		
		final int N = 5, M = 6;
		int[][] mas = new int [N][M];
		ArraysExtra.initArray(mas, 10);
		System.out.print("Original array:");
		ArraysExtra.printArray(mas);
		System.out.println("\nMaximal elements in every row in the original row's order:");
		for (int i = 0; i < mas.length; i++) {
			System.out.print(ArraysExtra.findMax(mas[i])+"\t");
		}
		System.out.print("\n\nThe array was sorted ascending of maximal elements in every row:");
		sortByMaxInRow(mas);
		ArraysExtra.printArray(mas);
	}
	
	public static void sortByMaxInRow(int[][] ar) {
		
		// uses insertion sort algorithm
		
		int[] key = new int[ar[0].length];
	    int i;
	    
	    for (int j = 1; j < ar.length; j++){
	        System.arraycopy(ar[j], 0, key, 0, key.length);
	        i = j - 1;
	        while (i >= 0 && ar[i][ArraysExtra.findIndexMax(ar[i])] > ArraysExtra.findMax(key)) {
	        	System.arraycopy(ar[i], 0, ar[i+1], 0, ar[i].length);
	            i--;
	        }
	        System.arraycopy(key, 0, ar[i+1], 0, key.length);
	    }
	}
}
