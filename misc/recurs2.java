
public class recurs2 {

	public static void main(String[] args) {
		int i, n, k, s;
		n = 5;
		k = 0;
		s = 0;
		
		for (i = 1; i <= n; i = i + 2){
			k++;
			s = s + i;
		}
		System.out.println((double)s/k);
	}

}
