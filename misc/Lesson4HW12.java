/*
 * Defines if the number is the prime 
 */
public class Lesson4HW12 {
	
	public static boolean prime(long a) {
		for(long i = 2; i <= Math.sqrt(a); i++)
	        if ( (a % i) == 0) {
	        	return false;
	        }
		return true;
		
	}

	public static void main(String[] args) {
		long a = 99990001;		
		if (prime(a)) {
			System.out.println(a + " is the prime number");
		}
		else System.out.println(a + " is not the prime number");

	}

}
