
public class DeleteConsonatBeginWorlds {

	/**
	 * deletes all worlds have length 5 characters and begins with consonants
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int start = -1;
		int end = 0;
		String separator = " ";
		StringBuffer source = new StringBuffer("source string where searching a list of the worlds which start with consonants and have lenght of 5 characters. Final world");
		System.out.println(source);
		do {
			end = start+1;
			start = source.indexOf(separator, end);
			if (source.length() - end == 5 && start == -1) {
				source.delete(end, source.length());
				break;
			}
			if ((start-end) == 5 && isConsonant(source.charAt(end))) {
				source.delete(end, start);
				start = end;
			}
		} while (start != -1);
		System.out.println(source);

	}
	
	public static boolean isConsonant(char c) {
		String consonants = "BCDFGHJKLMNPQRSTVWXYZ" + "BCDFGHJKLMNPQRSTVWXYZ".toLowerCase();
		return consonants.contains(String.valueOf(c));
	}
}
