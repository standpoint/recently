
public class Trapezium extends Quadrangle {
	
	private int h;
	
	public Trapezium() {
		super(new Point(0,0), new Point(4,3), new Point(14,3), new Point(18,0));
	}
	
	public Trapezium(Point p1, Point p2, Point p3, Point p4) {
		super();
	}

	public int getH() {
		h = p2.getY() != p1.getY() ? Math.abs(p2.getY() - p1.getY()) : Math.abs(p3.getY()-p1.getY());
		return h;
	}
	
	public double square(){
		return 1/0.;
	}
	
	public void print(){
		System.out.println("Trapezium with the vertices ");
		p1.print();
		p2.print();
		p3.print();
		p4.print();
		System.out.println("height h: " + getH());
		System.out.printf("Perimeter: %.4f, square: %.4f\n", perimeter(),square());
	}
}
