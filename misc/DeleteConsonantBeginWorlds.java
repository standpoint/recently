public class DeleteConsonantBeginWorlds {

	/**
	 * deletes all worlds have length 5 characters and begins with consonants
	 * the version using StringBuffer
	 * @param args
	 */
	public static void main(String[] args) {
		
		int end = -1;
		int start = 0;
		String separator = " ";
		StringBuffer source = new StringBuffer("source string where searching a list of the worlds which start with consonants and have lenght of 5 characters. Final world");
		System.out.println(source);
		do {
			start = end+1;
			end = source.indexOf(separator, start);
			if (source.length() - start == 5 && end == -1) {
				source.delete(start, source.length());
				break;
			}
			if ((end-start) == 5 && isConsonant(source.charAt(start))) {
				source.delete(start, end);
				end = start;
			}
		} while (end != -1);
		System.out.println(source);

	}
	
	public static boolean isConsonant(char c) {
		String consonants = "BCDFGHJKLMNPQRSTVWXYZ" + "BCDFGHJKLMNPQRSTVWXYZ".toLowerCase();
		return consonants.contains(String.valueOf(c));
	}
}
