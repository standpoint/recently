/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
class Car {     // facade for motor and clutch
    Motor m;
    Clutch c;
    
    public void move(){
        m.start();
        c.move();
    }
}
class Motor{
    public void start(){};
}
class Clutch {
    public void move(){};
}
/**
 *
 * @author volodya
 */
public class Facade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
