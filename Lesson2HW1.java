/** Determines 
 * 1) is triangle exist and 
 * 2) what is the type of one: isosceles, equilateral or scalene
 *    
 * @version 1.0
 * @author volodya
 * 
 */
public class Lesson2HW1 {
	public static void main(String[] args) {
		double a, b, c;
		a = 15;
		b = 140;
		c = 16;
		
		// Check is triangle can exist with sides a,b,c at all
		if (a < (b + c) && b < (a + c) && c < (a + b)) {
			
			// Check type of the triangle
			if (a == b && b == c && a == c) {
				System.out.println("The triangle is an equilateral");
			}
			else if (a == b || b == c || a == c) {
				System.out.println("The triangle is an isosceles");
			}
			else {
				System.out.println("The triangle is an scalene");
			}
		} 
		else {
			System.out.println("Any trianges with such sides (" + a + ", " + b + ", " + c + ") are not exist");
		}
	}
}
