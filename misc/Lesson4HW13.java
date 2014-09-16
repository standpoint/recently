
public class Lesson4HW13 {

	public static void main(String[] args) {
		final double a, eps;
		double x,xx;	// xx = x(n+1)
		int n = 0;
		x = a = 29;
		xx = (a + 2)/3;
		eps = 0.001;
		while (Math.abs(xx - x) > eps) {
			x = xx;
			xx = (x + 2*Math.sqrt(a/x))/3;
			n++;
		}
		System.out.format("Iterations number is " + n + ", cube root of %.3f = %.3f", a, xx);

	}

}
