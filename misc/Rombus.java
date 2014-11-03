
public class Rombus extends Quadrangle {
	
	private double d1;
	private double d2;
	
	public Rombus(){
		super(new Point(0,0), new Point(4,3), new Point(9,3), new Point(5,0));
	}
	
	public Rombus(Point p1, Point p2, Point p3, Point p4) {
		super(p1,p2,p3,p4);
	}
	
	public double getDiag1(){			//Getter for d1
		d1 = p1.getDistance(p3);
		return d1;
	}
	public double getDiag2(){			//Getter for d2
		d2 = p2.getDistance(p4);
		return d2;
	}
	
	public double square(){
		return d1*d2/2.;
	}
	
	public double perimeter() {
		return 4*p1.getDistance(p2);
	}
	
	public void print(){
		System.out.println("Rombus with the vertices ");
		p1.print();
		p2.print();
		p3.print();
		p4.print();
		System.out.printf("diagonals d1: %.4f, d2: %.4f\n", getDiag1(), getDiag2());
		System.out.printf("Perimeter: %.4f, square: %.4f\n", perimeter(),square());
	}

}
