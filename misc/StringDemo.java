import java.util.Arrays;


public class StringDemo {

	public static void main(String[] args) {

		String demo = "0123aaa5678ghij9defABbcCDEFGHIJa";
//		char[] chars = (demo.substring(5,15)).toCharArray();
//		Arrays.sort(chars);
//		System.out.println(demo.substring(0,5) + new String(chars) + demo.substring(15));
		int i = -1;
		int j = -1;
		int count = -1;
		
		do {
			i = (demo.substring(++j)).indexOf('a');
			j += i;
			count++;
		} while (i != -1);
		
		System.out.println("Number of 'a' occurance in " + demo + " : " + count);
	}
}
