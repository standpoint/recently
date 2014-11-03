public class AllDigitsSum {
	/**
	 * finds sum of all digits in the text
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		Integer sum = 0;
		String s = "This is a text contains such digits: 1, 5, 7, 0, 7. End of the text.\n";
		char[] chars = s.toCharArray();
		for (char el:chars){
			if (Character.isDigit(el)) {
				sum += Integer.decode(String.valueOf(el));
			}
		}
		System.out.println(s + "A sum of the digits in this text: " + sum);
	}
}
