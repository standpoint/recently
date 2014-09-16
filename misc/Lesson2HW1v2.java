/** Lesson2HW1v2 - homework of the 2nd lesson 
 * 
 * Determines 
 * 1) is triangle exist
 * 2) what is the type of one: isosceles, equilateral or scalene
 *    
 * @version 2.0
 * @author volodya
 *    
 */

import java.math.*;

public class Lesson2HW1v2 {

	//Method 'checkAngle' check is the triangle acute-angled, right-angle or obtuse
	public static void checkAngle(BigDecimal aa, BigDecimal bb, BigDecimal cc) {

		if (aa.compareTo(BigDecimal.valueOf(90.000000)) < 0 && bb.compareTo(BigDecimal.valueOf(90.000000)) < 0 && cc.compareTo(BigDecimal.valueOf(90.000000)) < 0) {
			System.out.println(" и остроугольным");
		}
		else if (aa.compareTo(BigDecimal.valueOf(90.000000)) == 0 || bb.compareTo(BigDecimal.valueOf(90.000000)) == 0 || cc.compareTo(BigDecimal.valueOf(90.000000)) == 0) {
			System.out.println(" и прямоугольным");
		}
		else {
			System.out.println(" и тупоугольным");
		}
	}


	public static void main(String[] args) {
		
		// Coordinates of three points A(x1,y1), B(x2,y2), C(x3,y3) and segments a,b,c 
		final double x1, y1, x2, y2, x3, y3;
		double a, b, c, angle1, angle2, angle3;
		
		x1 = 0.0;
		y1 = 0.0;
		x2 = 2.0;
		y2 = 3.46410162; // (x3-x1)*sqrt(3)/2 (equal to: side*cos(30)) ~ 3.46410161514
		x3 = 4.0;
		y3 = 0.0;
		
		String err = "Невозможно построить треугольник с вершинами в заданных точках A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ").";
		
		BigDecimal alpha = new BigDecimal(0.0);
		BigDecimal betta = new BigDecimal(0.0);
		BigDecimal gamma = new BigDecimal(0.0);

		// Define sides of expected triangle
		a = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
		b = Math.sqrt(Math.pow((x3 - x2),2) + Math.pow((y3 - y2),2));
		c = Math.sqrt(Math.pow((x3 - x1),2) + Math.pow((y3 - y1),2));
		
		try {
			
			// Define angles of expected triangle
			angle1 = Math.toDegrees(Math.acos((Math.pow(b, 2)+Math.pow(c, 2)-Math.pow(a, 2))/(2*b*c)));
			angle2 = Math.toDegrees(Math.acos((Math.pow(a, 2)+Math.pow(c, 2)-Math.pow(b, 2))/(2*a*c)));
			angle3 = Math.toDegrees(Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/(2*a*b)));
			alpha = BigDecimal.valueOf(angle1).setScale(6, RoundingMode.HALF_UP);
			betta = BigDecimal.valueOf(angle2).setScale(6, RoundingMode.HALF_UP);
			gamma = BigDecimal.valueOf(angle3).setScale(6, RoundingMode.HALF_UP);

			// Check is triangle can exist with these angles at all (alpha + betta + gamma < 180 degrees)
			if (((alpha.add(betta.add(gamma))).setScale(5, RoundingMode.HALF_UP)).compareTo(BigDecimal.valueOf(180.0)) == 0 
					&& alpha.compareTo(BigDecimal.valueOf(0.0)) != 0
					&& betta.compareTo(BigDecimal.valueOf(0.0)) != 0
					&& gamma.compareTo(BigDecimal.valueOf(0.0)) != 0) {

				// Check type of the triangle
				if (alpha.compareTo(betta) == 0 && betta.compareTo(gamma) == 0 && alpha.compareTo(gamma) == 0) {
					System.out.println("Треугольник с вершинами A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ") является равносторонним");
				}
				else if (alpha.compareTo(betta) == 0 || betta.compareTo(gamma) == 0 || alpha.compareTo(gamma) == 0) {
					System.out.print("Треугольник с вершинами A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ") является равнобедренным");
					checkAngle(alpha,betta,gamma);
				}
				else {
					System.out.print("Треугольник с вершинами A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ") является разносторонним");
					checkAngle(alpha,betta,gamma);
				}
			} 
			else {
				System.out.println(err);
			}
			
		}
		catch (NumberFormatException s){
			System.out.println(err);
		}

	}
}