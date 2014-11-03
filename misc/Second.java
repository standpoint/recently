import java.util.Arrays;

public class Second {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] arr1 = {'0','1','a','3','4','a','6','a','8','a','A','B','C','a'};
		char[] temp = {'"','p','a','s','t','-','a','n','y','-','s','y','m','b','o','l','s','"'};
		char[] arr2 = new char[arr1.length*temp.length];
		int i, j = 0, k = 0;
		
		for (i = 0; i < arr1.length; i++) {
			if (arr1[i] == 'a') {
				System.arraycopy(arr1, k, arr2, j, i-(k-1));
				j += (i-k)+1;
				System.arraycopy(temp, 0, arr2, j, temp.length);
				j += temp.length;
				k = i + 1;
			}
		}
		System.arraycopy(arr1, k, arr2, j, i-k);
		
		for (char el:Arrays.copyOf(arr2, j + i - k)) {
			System.out.print(el);
		}

	}

}
