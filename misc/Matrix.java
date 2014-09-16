import java.util.Arrays;
import java.util.Random;

import arraysextra.ArraysExtra;


public class Matrix {
	
	private int[][] ar;
	private static final int[] EMPTY_ARRAY = new int[0];
	
	public Matrix(){
		
		this.ar = new int[3][3];
	}
	
	int[][] getAr() {
		return ar;
	}

	void setAr(int[][] ar) {
		this.ar = ar;
	}

	public Matrix(int N, int M) {
		
		this.ar = new int[N][M];
	}
	
	public void fill() {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = r.nextInt();
			}
		}
	}
	
	public void fill(int n) {
		
		Random r = new Random();		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = r.nextInt(n);
			}
		}
	}
	
	public int min() {

		int min = ar[0][0];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				if (ar[i][j] < min) {
					min = ar[i][j];
				}
			}
		}
		return min;
	}
	
	public int max() {
		
		int max = ar[0][0];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				if (ar[i][j] > max) {
					max = ar[i][j];
				}
			}
		}
		return max;
	}
	
	public long sum() {
		
		long sum = 0;
		for(int[] mas : ar) {
			for(int el : mas) {
				sum += el;
			}
		}
		return sum;
	}
	
	public long product() {
		
		long prod = 1;
		for(int[] mas : ar) {
			for(int el : mas) {
				prod *= el;
			}
		}
		return prod;
	}
	
	public void print() {
		
		for (int[] mas : ar) {
			System.out.println();
			for (int el : mas) {
				System.out.print(el + "\t");
			}
		}
		System.out.println();
	}
	
	public void replaceAllOccurance(int[] vector) {
		
		Arrays.sort(vector);
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				if (Arrays.binarySearch(vector, ar[i][j]) >= 0) {
					Arrays.fill(ar[i], j, j+1, 0);
				}
			}
		}
	}
	
	public int[][] insertVectorAfterMinRow(){
		
		int[][] resArray = new int[ar.length+1][ar[0].length];
		for (int i = 0, j = 0; i < ar.length; i++, j++) {
			resArray[j] = Arrays.copyOf(ar[i], ar[0].length);
			if (i == findRawIndexMin(ar)) {
				j++;
				Arrays.fill(resArray[j], 1);
			}
		}
		return resArray;
	}
	
	private int findRawIndexMin(int[][] ar) {
		
		int min = ArraysExtra.findMin(ar[0]);
		int index = 0;
		for (int i = 0; i < ar.length; i++)
			if (ArraysExtra.findMin(ar[i]) < min) {
				min = ArraysExtra.findMin(ar[i]);
				index = i;
			}
		return index;
	}
	
	public int[] arrayEvenPosElements() {
		
		int k = 0;
		int[] res = new int[0];
		for (int i = 0; i < ar.length; i++){
			for (int j = 0; j < ar[i].length; j++) {
				if (ar[i][j] > 0 && ar[i][j]%2 == 0) {
					res = Arrays.copyOf(res,(++k));
					res[k-1] = ar[i][j];
				}
			}
		}
		return res;
	}
	
	public int[] arrayEvenPosElementsVersion() {
		
		int k = 0;
		int[] res = new int[ar.length*ar[0].length];
		for (int i = 0; i < ar.length; i++){
			for (int j = 0; j < ar[i].length; j++) {
				if (ar[i][j] > 0 && ar[i][j]%2 == 0) {
					res[k++] = ar[i][j];
				}
			}
		}
		if (k != 0) return Arrays.copyOf(res, k);
		else return EMPTY_ARRAY;
	}
}
