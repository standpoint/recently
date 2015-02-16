/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setdemo;
/**
 *
 * @author vladimir
 */
interface Container<T extends InteriorItem> {
    
    void add(T element);
    T get(int index);
    int size();
    Container copy();
    boolean contains(T element);
}
