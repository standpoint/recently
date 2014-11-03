
public class MethodeOddOrEven {
	
	public static boolean isOdd (int a) {

		if (a%2 == 1) {
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 0;
		int[] ar = {0,2,1,4,6,5,7,9,6,8};
		
		for (int el:ar) {
			if (isOdd(el)){
				count++;
			}
		}
		System.out.println("Number of odds " + count);

	}

}
