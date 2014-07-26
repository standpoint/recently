/** Determines 
 * 1) is triangle exist and 
 * 2) what is the type of one: isosceles, equilateral or scalene
 *    
 * @version 1.0
 * @author volodya
 * 
 */
public class Lesson2HW1 {

	//Method 'checkAngle' check is the triangle acute-angled, right-angle or obtuse
	public static void checkAngle(double a, double b, double c) {

		if ((Math.pow(a, 2) + Math.pow(b, 2)) > Math.pow(c, 2) && 
				(Math.pow(b, 2) + Math.pow(c, 2)) > Math.pow(a, 2) &&
				(Math.pow(a, 2) + Math.pow(c, 2)) > Math.pow(b, 2)) {
			System.out.println(" и остроугольным");
		}
		else if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2) || 
				(Math.pow(b, 2) + Math.pow(c, 2)) == Math.pow(a, 2) ||
				(Math.pow(a, 2) + Math.pow(c, 2)) == Math.pow(b, 2)) {
			System.out.println(" и прямоугольным");
		}
		else {
			System.out.println(" и тупоугольным");
		}
	}

	public static void main(String[] args) {

		// Coordinates of three points A(x1,y1), B(x2,y2), C(x3,y3) and segments a,b,c 
		int x1, y1, x2, y2, x3, y3;
		double a, b, c;
		x1 = 10;
		y1 = 5;
		x2 = 25;
		y2 = -20;
		x3 = 100;
		y3 = 0;

		// Define sides of expected triangle
		a = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
		b = Math.sqrt(Math.pow((x3 - x2),2) + Math.pow((y3 - y2),2));
		c = Math.sqrt(Math.pow((x3 - x1),2) + Math.pow((y3 - y1),2));

		// Check is triangle can exist with sides a,b,c at all
		if (a < (b + c) && b < (a + c) && c < (a + b)) {

			// Check type of the triangle
			if (a == b && b == c && a == c) {
				System.out.println("Треугольник с вершинами A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ") является равносторонним");
			}
			else if (a == b || b == c || a == c) {
				System.out.print("Треугольник с вершинами A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ") является равнобедренным");
				checkAngle(a,b,c);
			}
			else {
				System.out.print("Треугольник с вершинами A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ") является разносторонним");
				checkAngle(a,b,c);
			}
		} 
		else {
			System.out.println("Невозможно построить треугольник с вершинами в заданных точках A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ").");
		}
	}
}
