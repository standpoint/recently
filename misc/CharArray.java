import java.util.Arrays;
import java.util.Random;


public class CharArray {

	public static void main(String[] args) {

		int letters = 0;
		int digits = 0;
		int upperCases = 0;
		char[] ar = new char[30];
		Random r = new Random();
		for (int i = 0; i < ar.length; i++){
			ar[i] = (char)(32 + r.nextInt(93));
			if (Character.isDigit(ar[i])) {
				digits++;
				continue;
			}
			if (Character.isLetter(ar[i]) && Character.isUpperCase(ar[i])) {
				upperCases++;
				letters++;
				continue;
			} 
			if (Character.isLetter(ar[i])) {
				letters++;
			}
			
		}
		System.out.println(Arrays.toString(ar));
		System.out.println("Digits : " + (digits*100/ar.length));
		System.out.println("Letters : " + (letters*100/ar.length));
		System.out.println("UpperCase letters : " + (upperCases*100/ar.length));
		
		

	}

}
