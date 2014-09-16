
public class RecursiveSum {

	public static void main(String[] args) {
		int step = 2;
		int base = 0;
		int n = 7;
		int sum = recursiveSum(n,base,step);
		System.out.println(sum);

	}
	
	public static int recursiveSum (int _n, int _base, int _step) {
		
		if (_n == 1) {
			return _base;
		}
		else {
			return (_base*_n+(_n-1)*_step)+recursiveSum(_n-1,_base,_step);
		}
	}

}
