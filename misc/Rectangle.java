public class Rectangle extends Quadrangle {
	
	public Rectangle() {
		super();
	}

	public Rectangle(Point p1, Point p2, Point p3, Point p4) {
		super(p1,p2,p3,p4);
	}
	
	public Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = new Point(p1.getX(),p2.getY());
		this.p3 = p2;
		this.p4 = new Point(p2.getX(),p1.getY());
	}
	
	public double square(){
		return p1.getDistance(p2)*p2.getDistance(p3);
	}
	
	public double perimeter() {
		return 2*p1.getDistance(p2) + 2*p2.getDistance(p3);
	}
	
	public void print(){
		System.out.println("Rectangle with the vertices ");
		p1.print();
		p2.print();
		p3.print();
		p4.print();
		System.out.printf("Perimeter: %.4f, square: %.4f\n", perimeter(),square());
	}

}
