/*
 * Converts decimal (byte) to binary with recursive method
 */

public class RecursiveDecToBin {
	
	public static int[] ar = new int[8];

	public static void main(String[] args) {
		
		byte dec = -128;
		int decSigned;			

		// input decimal are correcting for the sign
		
		if (dec < 0) {
			ar[0] = 1;
			decSigned = 128 + dec;
		}
		else {
			ar[0] = 0;
			decSigned = dec;
		}
		
		recusiveDecToBin(decSigned, ar.length-1);
		printArray("Decimal " + dec + " is binary ",ar);
	}
	
	public static void printArray(String s, int[] ar) {
		
		System.out.print(s);
		for(int el:ar) {
			System.out.print(el);
		}
	}
	
	public static void recusiveDecToBin(int dec, int pos) {

		if (pos == 0) {
			return;
		}
		else {
			ar[pos] = dec%2;
			recusiveDecToBin((dec/2),pos-1);
		}
	}
	
}
