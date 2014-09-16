
public class BinSum {

	/**
	 * Find a sum of two variables values in binary style
	 * 
	 * @version 1.1
	 * @author Vladimir
	 * 
	 */
	public static void main(String[] args) {
		final byte mask = 1;
		int a = 126, b = 574, res = 0, i = 0, j = 0;
		boolean x = false;
		
		while(i < 31) {
			
			while (j < 31 && x){								
				
				// block is executing only if carry bit is "1"
				if (((a & (mask << j)) ^ (b & (mask << j))) == 0 && (a & (mask << j)) == 0) {	// a(j) = 0, b(j) = 0, x = true
					res |= mask << j;															// res(j) = 1
					x = false;
					i = ++j;
					break;
				}
				else if (((a & (mask << j)) ^ (b & (mask << j))) != 0) {
					res &= ~(mask << j);														// res(j) = 0
				}
				else {
					res |= mask << j;															// res(j) = 1
				}
				j++;
			}
			
			// block is executing only if carry bit is "0"
			if (((a & (mask << i)) ^ (b & (mask << i))) == 0 && (a & (mask << i)) == 0) {		// a(i) = 0, b(i) = 0
				res &= ~(mask << i);															// res(i) = 0
			} 
			else if (((a & (mask << i)) ^ (b & (mask << i))) == 0 && (a & (mask << i)) != 0) {	// a(i) = 1, b(i) = 1
				res &= ~(mask << i);															// res(i) = 0
				x = true;
			}
			else {																				// a(i) = 1, b(i) = 0 ( or a(i) = 0, b(i) = 1)
				res |= mask << i;
			}
			j = ++i;
		}

		System.out.println("a = " + a + " , b = " + b);
		System.out.println("a + b = " + res);
	}

}
