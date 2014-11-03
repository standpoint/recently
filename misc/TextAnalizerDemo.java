public class TextAnalizerDemo {

	public static void main(String[] args) {
		
		String sourceText = "Arguments referenced by the format specifiers in the format string.";
		final char entry = 'e';
		System.out.println(sourceText);
		System.out.println(TextAnalizer.getResultText(sourceText, entry));
	}
}
