
public class Triangle {

	private int a;
	private int b;
	private int c;
	
	public static boolean isTriangle(int a, int b, int c) {
		return (a < (b + c) && b < (a + c) && c < (a + b));
	}
	
	public Triangle(){
		a = 10;
		b = 10;
		c = 10;
	}
	public Triangle(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int getA() {
		return a;
	}
	public void setA(int a){
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int calculatePerimeter(){
		return a+b+c;
	}
	
	public void printSides(){
		System.out.println("a = " + a + "; b = " + b + "; c = " + c);
	}
	
	public void printPerimeter(int p){
		System.out.println("Triangle' perimeter is " + p);
	}

	public boolean isAcute() {

		return ((Math.pow(a, 2) + Math.pow(b, 2)) > Math.pow(c, 2) && (Math.pow(b, 2) + Math.pow(c, 2)) > Math.pow(a, 2) && (Math.pow(a, 2) + Math.pow(c, 2)) > Math.pow(b, 2));
	}
	
	public static void sortByPerimetrs(Triangle[] triangles) {	// for sorting uses the insertionSort algorithm
		
		Triangle key;
	    int i;
	    
	    for (int j = 1; j < triangles.length; j++){
	        key = triangles[j];
	        i = j - 1;
	        while (i >= 0 && triangles[i].calculatePerimeter() > key.calculatePerimeter()) {
	            triangles[i + 1] = triangles[i];
	            i--;
	        }
	        triangles[i+1] = key;
	    }
	}
	
	public static void printTrianglesArray (Triangle[] triangles) {	// prints the array of Triangle' objects
		int i = 0;
		for(Triangle el:triangles) {
			System.out.println("Triangle #" + (i++) + ": ");
			el.printSides();
			el.printPerimeter(el.calculatePerimeter());
		}
	}
}
