/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;
interface Showable {
    void show();
}
class Picture implements Showable {
    public void show(){
        System.out.println("show the picture");
    }
}
class Frame implements Showable {
    Showable s;
    public Frame(Showable s){
        this.s = s;
    }
    public void show(){
        s.show();
        System.out.println("show the frame");
    }
}
class Color implements Showable {
    Showable s;
    public Color(Showable s){
        this.s=s;
    }
    public void show(){
        s.show();
        System.out.println("show the color");
    }
}
/**
 *
 * @author volodya
 */
public class Decorator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Picture pic = new Picture();
        Showable picInTheFrame = new Frame(pic);
        //picInTheFrame.show();
        Showable picInTheColorFrame = new Color(picInTheFrame);
        picInTheColorFrame.show();
    }
}
