public class DeleteConsonantBeginWorldsVersionSubstring {

	/**
	 * deletes all worlds have length 5 characters and begins with consonants
	 * the version using String' substring method
	 * @param args
	 */
	public static void main(String[] args) {
		
		int end = -1;
		int start = 0;
		String separator = " ";
		String source = "Source string where searching a list of the worlds which start with consonants and have lenght of 5 characters. Final world";
		String result = "";
		do {
			start = end+1;
			end = source.indexOf(separator, start);
			if (source.length() - start == 5 && end == -1) {
				result += source.substring(start, source.length() - 5);
				break;
			}
			if ((end-start) == 5 && isConsonant(source.charAt(start))) {
				result += source.substring(start, end - 5);
				continue;
			}
			result += source.substring(start, end+1);
		} while (end != -1);
		System.out.println(source);
		System.out.println(result);

	}
	
	public static boolean isConsonant(char c) {
		String consonants = "BCDFGHJKLMNPQRSTVWXYZ" + "BCDFGHJKLMNPQRSTVWXYZ".toLowerCase();
		return consonants.contains(String.valueOf(c));
	}
}
