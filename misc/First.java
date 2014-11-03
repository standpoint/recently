public class First {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] arr1 = {'a','b','x','a','a','x'};
		int k = 0;
		
		// numbering 'a'
		for (char el:arr1) {
			if (el == 'a') {
				k++;
			}
		}

		char[] arr2 = new char[arr1.length+k*2];
		for (int i = 0, j = 0; i < arr1.length; i++, j++) {
			arr2[j] = arr1[i];
			if (arr1[i] == 'a') {
				arr2[++j] = '!';
				arr2[++j] = '=';
			}
		}
		
		// print result
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]);
		}
	}
}
