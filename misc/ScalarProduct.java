import arraysextra.*;

public class ScalarProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int N = 3;
		final float[][] A = new float [N][N];
		ArraysExtra.initArray(A,10);
		ArraysExtra.printArray(A);
		int rmax = ArraysExtra.rawMax(A);
		int cmin = ArraysExtra.colMin(A);
		System.out.println("Scalar product of "+ rmax +"th raw and "+ cmin +"th column is " + scalarProduct(A,rmax,cmin));
	}
	
	private static float scalarProduct(float[][] ar, int raw, int col) {
		int sprod = 0;
		for (int i = 0; i < ar[raw].length; i++){
			sprod += ar[raw][i]*ar[i][col];
		}
		return sprod;
	}

}
