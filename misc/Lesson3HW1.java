/*
 * define is there a leap year
 */
public class Lesson3HW1 {

	public static void main(String[] args) {
		short year = 1200;
		boolean equal;
		equal = ((year % 4) == 0 || (year % 400) == 0) && (year % 100) != 0 && year >= 1582;
		
		if (equal){
			System.out.println(year + " is a leap year");
		}
		else if (year < 1582){
			System.out.println("Gregorian calendar had not yet been introduced at " + year);
		}
		else {
			System.out.println(year + " is not a leap year");
		}		
	}

}
