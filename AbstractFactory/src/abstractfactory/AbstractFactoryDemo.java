
package abstractfactory;
interface Shape {
    void show();
}
class Triangle implements Shape {
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        // implementation
    }
    public void show(){}
}
class Square implements Shape {
    public Square(int x1, int y1, int x2, int y2) {
        //implementation
    }
    public void show(){}
}

class ShapeFactory {
    public static Shape createShape(String nameOfProduct){
        if (nameOfProduct.equals("triangle")) {
            return new Triangle(1, 2, 3, 4, 5, 6);
        }
        return new Square(2, 1, 3, 4);
    }
}

public class AbstractFactoryDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Shape s = ShapeFactory.createShape("triangle");
        s.show();
    }
    
}
