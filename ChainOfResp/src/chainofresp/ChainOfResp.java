/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresp;
class Command{
    Command c;                              // next command in the chain
    String name;
    static int commands, executes;
    public Command(String name){
        this.name = name;
        commands++;
    }
    public void addCommand(Command c){
        this.c = c;
    }
    public void execute(String nameCommand){
        executes++;
        if(name.equals(nameCommand) && executes <= commands){
            System.out.println("execute command " + name);
        } else if (c != null && executes <= commands) {
            c.execute(nameCommand);
        } else {
            System.err.println("bad command: " + nameCommand);
            executes = 0;
            commands = 0;
        }
    }
}
/**
 *
 * @author volodya
 */
public class ChainOfResp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Command a = new Command("a");
        Command b = new Command("b");
        Command c = new Command("c");
        a.addCommand(b);
        b.addCommand(c);
        c.addCommand(a);
        c.execute("b");
        c.execute("d");
        b.execute("a");
    }
    
}
