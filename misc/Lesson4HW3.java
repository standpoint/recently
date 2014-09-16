/*
 * 	Printing (lim = 5):
 * 	....1
 * 	...2.
 * 	..3..
 * 	.4...
 * 	5....
 */
public class Lesson4HW3 {

	public static void main(String[] args) {
		final int lim = 5; 

		for (int i = 1, j = lim; i <= lim; i++){
			while (j > 1) {
				if (j > i || (j > 1 && j < i)) {
					System.out.print(".");
				}
				else {
					System.out.print(i);
				}
				j--;
			}
			if (i == 1) {
				System.out.println(i);
			}
			else {
				System.out.println(".");				
			}
			j = lim;
		}
	}
}
