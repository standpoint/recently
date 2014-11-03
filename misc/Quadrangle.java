public abstract class Quadrangle {

	Point p1;
	Point p2;
	Point p3;
	Point p4;

	public Quadrangle() {
		this(new Point(0,0), new Point(0,5), new Point(5,5), new Point(5,0));
	}
	
	public Quadrangle(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	public double perimeter() {
		return p1.getDistance(p2) + p2.getDistance(p3) + p3.getDistance(p4) + p4.getDistance(p1);
	}
	
	public void print() {
		System.out.println("Quadrangle with the vertices ");
		p1.print();
		p2.print();
		p3.print();
		p4.print();
		System.out.printf("Perimeter of one: %.4f\n\n", perimeter());
	}
	
	public abstract double square();

}