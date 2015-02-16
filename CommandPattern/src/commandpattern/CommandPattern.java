/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern;
class Lift{                     //reciever
    public void move(int floor){
        System.out.println("move to floor " + floor);
    }
}

abstract class Command{      //command
    Lift l = new Lift();
    abstract public void execute();
}
class First extends Command{
    public void execute(){
        l.move(0);
    }
}
class Second extends Command{
    public void execute(){
        l.move(1);
    }
}

class Panel{            //invoker
    Command[] commands = new Command[2];
    public Panel(){
        commands[0] = new First();
        commands[1] = new Second();
    }
    public void gotoFloor(int floor){
        commands[floor].execute();
    }
}
/**
 *
 * @author volodya
 */
public class CommandPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Panel panel = new Panel();
        panel.gotoFloor(1);
    }
}
