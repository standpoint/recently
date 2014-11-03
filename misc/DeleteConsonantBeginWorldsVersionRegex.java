public class DeleteConsonantBeginWorldsVersionRegex {
	/**
	 * deletes all worlds have length 5 characters and begins with consonants
	 * the version using regular expressions
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		String source = "Source string where searching a list of the worlds which start with consonants and have lenght of 5 characters. Final world";
		System.out.println(source);
		String[] result = worldSeparation(source);
		for (int i = 0; i < result.length; i++) {
			if (result[i].length() == 5 && isConsonant(result[i].charAt(0))) {
				continue;
			}
			System.out.print(result[i] + " ");
		}
	}
	
	public static String[] worldSeparation (String source) {
		return source.split("[ ,.]");
	}
	
	public static boolean isConsonant(char c) {
		String consonants = "BCDFGHJKLMNPQRSTVWXYZ" + "BCDFGHJKLMNPQRSTVWXYZ".toLowerCase();
		return consonants.contains(String.valueOf(c));
	}

}
