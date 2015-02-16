/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;
interface Chucken{          // this is flyweight
    void state();
}

class FriedChucken implements Chucken{
    public void state(){
        System.out.println("fried chucken");
    }
}
class BoiledChucken implements Chucken{
    public void state(){
        System.out.println("boiled chucken");
    }
}
class ChuckenFactory{
    public static Chucken returnChucken(int st){
        switch(st){
            case 1: return new FriedChucken();
            case 2: return new BoiledChucken();
            default:    return null;
        }
    }
}

/**
 *
 * @author volodya
 */
public class Flyweight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Chucken c = ChuckenFactory.returnChucken(1);
        c.state();
        c = ChuckenFactory.returnChucken(2);
        c.state();
    }
    
}
