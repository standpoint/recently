
public class SuffixReplacing {
/**
 * Changes surnames that end with "ov" to "enko"
 * 
 * @param args
 */
	public static void main(String[] args) {
		
		StringBuffer source = new StringBuffer("Petrov Popovich Ivanov Sidorov");
		String oldSuffix = "ov";
		String newSuffix = "enko";
		int i = -1;
		System.out.println(source);
		do {
			i = source.indexOf(oldSuffix, i+1);
			if (isSuffix(source, oldSuffix, i)) {
				source.replace(i, i+oldSuffix.length(), newSuffix);
				i += newSuffix.length()-1;
			}
			else i += oldSuffix.length()-1;
		} while (i >= 0 && i+1 < source.length());
		System.out.println(source);

	}
	
	public static boolean isSuffix(StringBuffer sourceString, String suffix, int i){
		
		return (i+suffix.length() == sourceString.length() || sourceString.charAt(i+suffix.length()) == ' ');
	}

}
