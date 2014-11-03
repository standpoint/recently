import java.util.Arrays;


public class IndxOddMinEvenMaxV3 {

	public static void main(String[] args) {

		int[] arr = {0,-2, 2, 4, 3, 7, 9, 12, 1, 0, 15};
		System.out.println("Source array: " + Arrays.toString(arr));

		if (maxEven(arr) >= 0 || minOdd(arr) >= 0) {
			System.out.println("The index of the minimal odd element is " + minOdd(arr));
			System.out.println("The index of the maximal even element is " + maxEven(arr));
			System.out.println("Sum of these ones is " + (arr[maxEven(arr)]+arr[minOdd(arr)]));
		}
	}
	
	public static int maxEven(int[] ar) {
		int maxEvenIndex = -1;
		for (int i = 0; i < ar.length; i++){
			if (ar[i] != 0) {
				if (ar[i]%2 == 0 && maxEvenIndex >= 0 && ar[i] > ar [maxEvenIndex]) {
					maxEvenIndex = i;
				}
				else if (ar[i]%2 == 0 && maxEvenIndex < 0) {
					maxEvenIndex = i;
				}
			}
		}
		return maxEvenIndex;
	}
	
	public static int minOdd(int[] ar) {
		int minOddIndex = -1;
		for (int i = 0; i < ar.length; i++){
			if (ar[i]%2 != 0 && minOddIndex >= 0 && ar[i] < ar [minOddIndex]) {
				minOddIndex = i;
			}
			else if (ar[i]%2 != 0 && minOddIndex < 0) {
				minOddIndex = i;
			}
		}
		return minOddIndex;
	}

}
