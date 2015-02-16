package memento;

import java.util.*;

class Originator {
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public Memento saveStateToMemento() {
        return new Memento(state);
    }
    public void getStateFromMemento(Memento state) {
        this.state = state.getState();
    }
}

class Memento {
    private String state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}

class CareTaker {
    private final List<Memento> mementoList = new ArrayList<Memento>();;
    public void add(Memento state) {
        mementoList.add(state);
    }
    public Memento get(int index) {
        return mementoList.get(index);
    }
}

public class MementoPattern {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
