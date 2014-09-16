import java.util.Arrays;
import arraysextra.ArraysExtra;

public class InsertRawAfterMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int M = 5, N = 3;
		int[][] ar = new int[M][N];
		int[][] resArray = new int[ar.length+1][ar[0].length];  
		ArraysExtra.initArray(ar,25);
		insertRawAfterMin(ar, resArray);
		ArraysExtra.printArray(resArray);
	}
	
	static void insertRawAfterMin(int[][] ar, int[][] resArray){
		
		for (int i = 0, j = 0; i < ar.length; i++, j++) {
			System.arraycopy(ar[i], 0, resArray[j], 0, ar[i].length);
			if (i == findRawIndexMin(ar)) {
				j++;
				Arrays.fill(resArray[j], 1);
			}
		}
	}
	
	static int findRawIndexMin(int[][] ar) {
		
		int min = ArraysExtra.findMin(ar[0]);
		int index = 0;
		for (int i = 0; i < ar.length; i++)
			if (ArraysExtra.findMin(ar[i]) < min) {
				min = ArraysExtra.findMin(ar[i]);
				index = i;
			}
		return index;
	}

}
