import java.util.Random;

public class QuadrangleDemo {

	public static void main(String[] args) {
		
//		Point p1 = new Point(10,10);
//		Point p2 = new Point(10,20);
//		Point p3 = new Point(20,20);
//		Point p4 = new Point(20,10);
//		Quadrangle quad = new Quadrangle(); 
//		Rectangle rect1 = new Rectangle();
//		Rombus romb = new Rombus();
//		Trapezium trap = new Trapezium();
//		Rectangle rect2 = new Rectangle(p1,p2,p3,p4);
//		quad.print();
//		rect1.print();
//		rect2.print();
//		romb.print();
//		trap.print();
//		p1.setX(0);
//		p1.setY(0);
//		Rectangle rect3 = new Rectangle(p1, p3);
//		rect3.print();
		Quadrangle[] quads = new Quadrangle[3];
		quads[0] = new Rectangle(new Point(0,0), new Point(15,15));
		quads[1] = new Rombus();
		quads[2] = new Trapezium();
//		for (Quadrangle q:quads) {
//			q.print();
//		}
		int i = 0;
		for (int j = 0; j < 5; j++) {
			Random r = new Random();
			i = r.nextInt(2);
			increase(quads[i]);
			quads[i].print();
		}

	}
	
	public static void increase(Quadrangle figure) {
		System.out.println("increasing...");
		figure.p1.setX(figure.p1.getX()*2);
		figure.p1.setY(figure.p1.getY()*2);
		figure.p2.setX(figure.p2.getX()*2);
		figure.p2.setY(figure.p2.getY()*2);
		figure.p3.setX(figure.p3.getX()*2);
		figure.p3.setY(figure.p3.getY()*2);
		figure.p4.setX(figure.p4.getX()*2);
		figure.p4.setY(figure.p4.getY()*2);
	}
}
