
public class Lesson1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		int a = 20;
		int b = 20;
		if (a > b)
			max = a;
		else if (a == b) System.out.println("a eqv b");
		else 
		{
			max = b;
			System.out.println("max = " + max);
		}
	}

}
