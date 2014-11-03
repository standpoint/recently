import java.util.Arrays;


public class Third {

	public static void main(String[] args) {
		
		final int n = 17;
		int[] arr1 = new int[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = i;
		}
		int j = 0;
		for (int i = 0; i < arr1.length; i++, j++) {
			if (i < (arr1.length - 1)) {
				if ((i+1)%3 == 0) {
				i++;
			}
			
			arr1[j] = arr1[i];
			}
			else {
				arr1[j] = arr1[i];
				break;
			}
		}
		
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr1, 0, j)));

	}

}
