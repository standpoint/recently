/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setdemo;

import java.util.*;

/**
 *
 * @author vladimir
 */
public class MyList<T extends InteriorItem> implements Container<T> {
    
    private final LinkedList<T> container;

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
    public void add(T item) {
        if (!this.contains(item)) {
            container.add(item);
        }
    }
    
    @Override
    public T get(int index) {
        return container.get(index);
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
    public boolean contains(T element) {
        return container.contains(element);
    }
    
    @Override
    public String toString() {
        String s = "";
        for (T item : container) {
            s += "{" + item + "}";
        };
        s += "\n";
        return s;
    }
}
