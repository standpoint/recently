/*
 * finds indexes of minimal odd and maximal even elements in the array and their sum
 * @version 2.0
 * 
 */
public class IndxOddMinEvenMaxV2 {

	public static void main(String[] args) {

		int minOddIndex = -1, maxEvenIndex = -1;
		int[] arr = {0,-2, 2, 4, 3, 7, 9, 12, 1, 0, 15};

		for (int i = 0; i < arr.length; i++){
			if (arr[i] != 0) {
				if (arr[i]%2 == 0 && maxEvenIndex >= 0 && arr[i] > arr [maxEvenIndex]) {
					maxEvenIndex = i;
					continue;
				}
				else if (arr[i]%2 == 0 && maxEvenIndex < 0) {
					maxEvenIndex = i;
					continue;
				}
				if (arr[i]%2 != 0 && minOddIndex >= 0 && arr[i] < arr [minOddIndex]) {
					minOddIndex = i;
				}
				else if (arr[i]%2 != 0 && minOddIndex < 0) {
					minOddIndex = i;
				}
			}
		}
		if (maxEvenIndex >= 0 || minOddIndex >= 0) {
			System.out.println("The index of the minimal odd element is " + minOddIndex);
			System.out.println("The index of the maximal even element is " + maxEvenIndex);
			System.out.println("Sum of these ones is " + (arr[maxEvenIndex]+arr[minOddIndex]));
		}
	}
}