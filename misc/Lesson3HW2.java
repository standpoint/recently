
public class Lesson3HW2 {

	public static void main(String[] args) {
		double prod, summ;
		int n = 2;
		summ = 0;
		prod = 1;		
		for (int i = 1; i <= n; i++){
			for(int j = 1; j <= i; j++){
				prod = prod * (j + 1);
			}
			summ = summ + prod / Math.pow((Math.pow(2, i) + 1), 2);
		}
		System.out.println("S = " + summ);
	}

}
