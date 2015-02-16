package setdemo;

import java.util.*;

/**
 * Container implementation by LinkedList
 * @author vladimir
 */
public class MyList implements Container {
    
    private final LinkedList container;

    /**
     *
     */
    public MyList() {
        this.container = new LinkedList();
    }
    
    public MyList(MyList mylist) {

        this.container = (LinkedList)mylist.container.clone();
    }
    
    @Override
    public void add(int element) {
        if (!this.contains(element)) {
            container.add(element);
        }
    }
    
    @Override
    public int get(int index) {
        return (int)container.get(index);
    }
    
    @Override
    public int size() {
        return container.size();
    }
    
    @Override
    public MyList copy() {
        return (new MyList(this));
    }
    
    @Override
    public boolean contains(int element) {
        return container.contains(element);
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Object c : container) {
            s += "{" + c + "}";
        };
        s += "\n";
        return s;
    }
}
