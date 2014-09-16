public class NumberInterrogatives {
/**
 * finds number of interrogative sentences in the text
 * 
 * @param args
 */
	
	public static void main(String[] args) {
		
		int count = 0;
		String text = "Will that do? Is that any help to your book? Of course, \n"
				+ "you've really tied me down, asking me to stick to the day of the \n"
				+ "bomb. There are lots of other good anecdotes about the bomb and \n"
				+ "Father, from other days. For instance, do you know the story about \n"
				+ "Father on the day they first tested a bomb out at Alamogordo? After \n"
				+ "the thing went off, after it was a sure thing that America \n"
				+ "could wipe out a city with just one bomb, a scientist turned to \n"
				+ "Father and said, 'Science has now known sin.' And do you know what \n"
				+ "Father said? He said, 'What is Sin?'";
		for(int i = 0; i < text.length(); i++){
			if (text.charAt(i) == '?' && (i+1) == text.length()) {
				count++;
				break;
			}
			if (text.charAt(i) == '?' && text.charAt(i+1) == ' ' && Character.isUpperCase(text.charAt(i+2))) {
				count++;
			}
		}
		System.out.println("\"" + text + "\"");
		System.out.println("\nA number of interrogative sentences in the text: " + count);
	}
}
