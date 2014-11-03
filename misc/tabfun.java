
public class TabFun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final double h = 0.25;
		double x, y;
		x = -5;
		while (x <= 5) {
			y = calculateY(x);
			printXY(x, y);
			x = x + h;
		}

	}

	public static void printXY(double x, double y) {
		System.out.println("x = " + x + "   " + "y = " + y);
	}

	public static double calculateY(double x) {
		double y = 0;
		if (x > 0) {
			y = Math.sin(x) / Math.sqrt(Math.pow(x, 2) + 1);
		}
		else if (x <= 0) {
			y = Math.log(1 + Math.pow(x, 2)) / (1 + Math.pow(x, 2)); 
		}
		return y;
	}

}
