import java.util.Arrays;

public class MatrixMain {

	public static void main(String[] args) {
		
//		int[] vector = new int[5];
//		Matrix mDefault = new Matrix();
		Matrix mParam = new Matrix(2,2);
//		Matrix mOccurance = new Matrix(5,5);
//		mDefault.fill();
		mParam.fill();
//		System.out.println("\nmDefault, Matrix object: ");
//		mDefault.print();
//		System.out.println("\nmParam, Matrix object: ");
		mParam.print();
//		System.out.println("\nMiniaml and maximal element in mDefault: " + mDefault.min() + ", " + mDefault.max());
//		System.out.println("\nMiniaml and maximal element in mParam: " + mParam.min() + ", " + mParam.max());
//		System.out.println("\nSum and product of elements in mDefault: " + mDefault.sum() + ", " + mDefault.product());
//		System.out.println("\nSum and product of elements in mParam: " + mParam.sum() + ", " + mParam.product());
//		ArraysExtra.initArray(vector,10);
//		mOccurance.fill();
//		System.out.println("\nBefore replaceAllOccurance()");
//		mOccurance.print();
//		System.out.println("\nVector: " + Arrays.toString(vector));
//		mOccurance.replaceAllOccurance(vector);
//		System.out.println("\nAfter replaceAllOccurance()");
//		mOccurance.print();
//		System.out.println("\nBase array in insertAfterMinRow()");
//		mDefault.print();
//		Matrix res = new Matrix();
//		res.setAr(mDefault.insertVectorAfterMinRow());
//		System.out.println("\nresArray is returned by insertAfterMinRow()");
//		res.print();
		System.out.println(Arrays.toString(mParam.arrayEvenPosElements()));
		System.out.println(Arrays.toString(mParam.arrayEvenPosElementsVersion()));
	}

}
