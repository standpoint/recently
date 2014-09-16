/*
 * 	Printing (lim = 5):
 * 	....1
 * 	...2
 * 	..3
 * 	.4
 * 	5
 */
public class Lesson4HW1 {

	public static void main(String[] args) {
		final int lim = 5; 

		for (int i = 1, j = lim; i <= lim; i++){
			while (j > i) {
				System.out.print(".");
				j--;
			}
			System.out.println(i);
			j = lim;
		}
	}
}
