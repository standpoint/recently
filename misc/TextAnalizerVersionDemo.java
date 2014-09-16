public class TextAnalizerVersionDemo {

	public static void main(String[] args) {
		
		String sourceText = "Arguments referenced by the format specifiers in the format string.";
		final char entry = 'e';
		TextAnalizerVersion.setSourceText(sourceText);
		TextAnalizerVersion.setEntry(entry);

		System.out.println("source text: \n" + sourceText + "\n");
		System.out.println("sorted by entries of '" + entry + "': ");
		(new TextAnalizerVersion()).print();
	}
}
