package strategypattern;

import java.util.ArrayList;
import java.util.List;

interface Sort{
    void sort(List<Integer> l);
}
class MySort implements Sort{
    public void sort(List<Integer> l) {
        //реализация алгоритма сортировки
    }
}
// добавить еще несколько классов реализаций сортировки по аналогии с MySort

class Massive {
    List<Integer> l = new ArrayList<Integer>();
    public void add(int element) {
        l.add(element);
    }
    public void sort(Sort s) {
        s.sort(l);
    }
}

public class StrategyPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Massive m = new Massive();
        m.sort(new MySort());
    }
    
}
