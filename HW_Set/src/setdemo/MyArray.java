package setdemo;

import java.util.Arrays;

/**
 * Container implementation by array of primitives
 * @author vladimir
 */
class MyArray implements Container {

    private int[] container;
    private int capacity;
    private int size;

    public MyArray() {
        size = 0;
        capacity = 16;
        container = new int[capacity];
    }

    public MyArray(MyArray myarray) {
        this.size = myarray.size;
        this.container = myarray.container.clone();
    }

    @Override
    public void add(int element) {
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
    public int get(int index) {
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
    public boolean contains(int element) {
        int[] temp = Arrays.copyOf(container, size);
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
