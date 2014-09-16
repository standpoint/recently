public class TriangleMain {

	public static void main(String[] args) {

		final int N = 10;
		int a, b, c;
		int countAcute = 0;
		a = b = c = 0;
		Triangle[] triangles = new Triangle[N];
		for (int i = 0; i < N; i++) {
			while(!(Triangle.isTriangle(a, b, c))) {
				a = (int)(Math.random()*20);
				b = (int)(Math.random()*20);
				c = (int)(Math.random()*20);
			}
			triangles[i] = new Triangle(a,b,c);
			if (triangles[i].isAcute()) countAcute++;
			a = b = c = 0;
		}
		Triangle.printTrianglesArray(triangles);
		System.out.println("Number of acute-triangles = " + countAcute);
		
		// sort the array by triangles' perimeters
		Triangle.sortByPerimetrs(triangles);
		System.out.println("After sorting by perimetrs : ");
		Triangle.printTrianglesArray(triangles);
		
	}
}
