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
		a = 6;
		b = 4;
		c = 4;

		// Check is triangle can exist with sides a,b,c at all
		if (a < (b + c) && b < (a + c) && c < (a + b)) {

			// Check type of the triangle
			if (a == b && b == c && a == c) {
				System.out.println("The triangle is an equilateral");
			}
			else if (a == b || b == c || a == c) {
				System.out.print("The triangle is an isosceles and ");
				if ((Math.pow(a, 2) + Math.pow(b, 2)) > Math.pow(c, 2) && 
					(Math.pow(b, 2) + Math.pow(c, 2)) > Math.pow(a, 2) &&
					(Math.pow(a, 2) + Math.pow(c, 2)) > Math.pow(b, 2)) {
					System.out.println("an acute-angle");
				}
				else if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2) || 
						(Math.pow(b, 2) + Math.pow(c, 2)) == Math.pow(a, 2) ||
						(Math.pow(a, 2) + Math.pow(c, 2)) == Math.pow(b, 2)) {
					System.out.println("a right-angle");
				}
				else {
					System.out.println("an obtuse");
				}				
			}
			else {
				System.out.print("The triangle is a scalene and ");
				if ((Math.pow(a, 2) + Math.pow(b, 2)) > Math.pow(c, 2) && 
					(Math.pow(b, 2) + Math.pow(c, 2)) > Math.pow(a, 2) &&
					(Math.pow(a, 2) + Math.pow(c, 2)) > Math.pow(b, 2)) {
					System.out.println("an acute-angle");
				}
				else if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2) || 
						(Math.pow(b, 2) + Math.pow(c, 2)) == Math.pow(a, 2) ||
						(Math.pow(a, 2) + Math.pow(c, 2)) == Math.pow(b, 2)) {
					System.out.println("a right-angle");
				}
				else {
					System.out.println("an obtuse");
				}
			}			
		}		
		else {
			System.out.println("Any trianges with such sides (" + a + ", " + b + ", " + c + ") are not exist");
		}
	}
}
