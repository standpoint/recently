package setdemo;
/**
 * Container interface for data in the Set
 * @author vladimir
 */
interface Container {
    
    void add(int element);
    int get(int index);
    int size();
    Container copy();
    boolean contains(int element);
}
