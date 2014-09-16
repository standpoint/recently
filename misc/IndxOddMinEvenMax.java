/*
 * finds indexes of minimal odd and maximal even elements in the array and their sum
 * @version 1.0
 * 
 */
public class IndxOddMinEvenMax {

	public static void main(String[] args) {
		
		int[] arr = {-2, 2, 4, 3, 7, 9, 12, 1, 0, 15};
		int minodd = 0, maxeven = 0;
		for (int i = 0; i < arr.length; i++){
			if (arr[i]%2 == 0) {
				maxeven = arr[i];
				break;
			}
		}
		for (int i = 0; i < arr.length; i++){
			if (arr[i]%2 != 0) {
				minodd = arr[i];
				break;
			}
		}
		int j = 0, k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (arr[i]%2 != 0 && arr[i] < minodd) {
					minodd = arr[i];
					j = i;
				}
				if (arr[i]%2 == 0 && arr[i] > maxeven) {
					maxeven = arr [i];
					k = i;
				}
			}
		}
		if (minodd != 0 && maxeven != 0) {
			System.out.println("The index of the minimal odd element is " + j);
			System.out.println("The index of the maximal even element is " + k);
			System.out.println("Sum of these ones is " + (maxeven+minodd));
		}
		else {
			System.out.println("incorrect source data");
		}
	}

}
