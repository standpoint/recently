/*
 * 	Printing (lim = 5):
 * 	....1
 * 	...22
 * 	..333
 * 	.4444
 * 	55555
 */
public class Lesson4HW2 {

	public static void main(String[] args) {
		final int lim = 5; 

		for (int i = 1, j = lim; i <= lim; i++){
			while (j > 1) {
				if (j > i) {
					System.out.print(".");
				}
				else {
					System.out.print(i);
				}
				j--;
			}
			System.out.println(i);
			j = lim;
		}
	}
}
