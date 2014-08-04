/*
 * finding all values of the arithmetic progression a(n) = a1 + (n-1)d
 * where a1 = 5; d = 3; n = 10
 *  
 */
public class Lesson4HW11 {
	
	public static void main(String[] args) {
		final int a1 = 5, d =3, n = 10;
		int a;
		for (int i = 1; i <= n; i++) {
			a = a1 + (i - 1)*d;
			System.out.print("a(" + i + ") = " + a + "; ");
		}
	}

}
