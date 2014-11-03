
/**
 * Finds a variable(variables) that contain maximum value
 * 
 * @author volodya
 * @version 1.0
 */

public class MaxOfThree {
	
	public static void main(String[] args) {
		int a, b, c, value;
		char max;
		a = 100;
		b = 200;
		c = 200;
		
		// Assume that value of the variable 'a' is the maximum
		max = 'a';
		value = a;
		
		// Check is the value of variables 'b' or 'c' more than 'a'
		if (b >= a && b >= c){
			max = 'b';
			value = b;
		}
		else if (c >= b && c >= a){
			max = 'c';
			value = c;
		}
		
		// Check is variable containing the maximum value unique and printing the result		
		if (a == b && b == c)
			System.out.println("All variables are equal to each other. Value is " + value);
		else if (a == b && a == value)
			System.out.println("Variables 'a' and 'b' are equal and contain maximum value: " + value);
		else if (a == c && a == value)
			System.out.println("Variables 'a' and 'c' are equal and contain maximum value: " + value);
		else if (b == c && b == value)
			System.out.println("Variables 'b' and 'c' are equal and contain maximum value: " + value);
		else
			System.out.println("Variable '" + max + "' contains maximum value: " + value);
	}
}
