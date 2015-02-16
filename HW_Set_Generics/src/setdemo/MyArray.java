/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setdemo;

import java.util.Arrays;

/**
 *
 * @author vladimir
 */
class MyArray implements Container<InteriorItem> {

    private InteriorItem[] container;
    private int capacity;
    private int size;

    public MyArray() {
        size = 0;
        capacity = 16;
        container = new InteriorItem[capacity];
    }

    public MyArray(MyArray myarray) {
        this.size = myarray.size;
        this.container = myarray.container.clone();
    }

    @Override
    public void add(InteriorItem element) {
        if (!contains(element)) {
            if (size < container.length) {
                container[size] = element;
                size++;
            } else {
                capacity *= 2;
                container = Arrays.copyOf(container, capacity);
                container[size] = element;
                size++;
            }
        }

    }

    @Override
    public InteriorItem get(int index) {
        if (index < size) {
            return container[index];
        } else {
            // if index out of range 0..size, return last added element
            return container[size-1];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyArray copy() {
        return (new MyArray(this));
    }

    @Override
    public boolean contains(InteriorItem element) {
        InteriorItem[] temp = Arrays.copyOf(container, size);
        Arrays.sort(temp);
        return (Arrays.binarySearch(temp, element) >= 0);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += "{" + container[i] + "}";
        }
        s += "\n";
        return s;
    }
}
