
public class equals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int mask = 1;
		int a, b, i;
		a = -1230; 
		b = 1230;
		i = 30;
		
		if ((a & (mask << 31)) == 0 && (b & (mask << 31)) != 0) {
			System.out.println("a > b");
		} 
		else if ((b & (mask << 31)) == 0 && (a & (mask << 31)) != 0) {
			System.out.println("b > a");
		}
		else {
			for (i = 30; i >= 0; i--) {
	
					if ((a & (mask << i)) == 0 && (b & (mask << i)) != 0) {
						System.out.println("b > a");
						break;
					}
					else if ((b & (mask << i)) == 0 && (a & (mask << i)) != 0) {
						System.out.println("a > b");
						break;
					}
			}
			if (i == -1){
				System.out.println("a = b");
			}
		}
		
	}

}
