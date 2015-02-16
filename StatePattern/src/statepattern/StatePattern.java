package statepattern;

class Car {
    boolean isOn = false;
    public void start() {
        if(isOn) {
            System.out.println("The Car is On");
        } else {
            isOn = true;
        }
    }
    public void stop() {
        if(!isOn) {
            System.out.println("The Car is stopped");
        } else {
            isOn = false;
        }
    }
}

public class StatePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.start();
        c.stop();
        c.stop();
    }
    
}
