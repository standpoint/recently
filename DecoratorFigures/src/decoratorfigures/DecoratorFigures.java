/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorfigures;
interface Inscribing {
    
    void inscribe();
    void show();
}

class Square implements Inscribing {
    Inscribing in;
    public Square(){
        
    }
    public Square(Inscribing in){
        this.in = in;
        
    }
    public void inscribe(){
        //in.inscribe();
        System.out.print("square is inscribed in ");
        //in.show();
    }
    public void show() {
        System.out.println("square");
    }
    
}
class Triangle implements Inscribing {
    
    Inscribing in;
    public Triangle(){
        
    }
    public Triangle(Inscribing in){
        this.in = in;
        
    }
    public void inscribe(){
        in.inscribe();
        System.out.print("triangle is inscribed in ");
        in.show();
    }
    public void show() {
        System.out.println("triangle");
    }
    
}

class Circle implements Inscribing {
    Inscribing in;
    public Circle(){
        
    }
    public Circle(Inscribing in){
        this.in = in;
        
    }
    public void inscribe(){
        in.inscribe();
        System.out.print("circle is inscribed in ");
        in.show();
    }
    public void show() {
        System.out.println("circle");
    }
    
}
/**
 *
 * @author volodya
 */
public class DecoratorFigures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Square square = new Square();
        
        Inscribing circle = new Circle(square);
        Inscribing triangle = new Triangle(circle);
        triangle.inscribe();
        // TODO code application logic here
    }
    
}
