
public class Lesson4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long f, s;
		s = 0;
		f = 1;

		for (int i = 1; i <= 5; i++){
			for (int j = 1; j <= i; j++){
				f = f * i;
			}
			s = s + f;
		}
		System.out.println((double)s/5);
	}

}
