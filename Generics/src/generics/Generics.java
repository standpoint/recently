package generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyComporator<T extends C> implements Comparator<T> {

    @Override
    public int compare(T t, T t1) {
        return t.getValue()-t1.getValue();
    }
    
}

class C{
    int value;
    public C(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
class D extends C{
    public D(int value){
        super(value);
    }
}
class E{}
class A extends E{
    public<T> T ff(T a){
        return a;
    }
}
class B extends A{}
public class Generics {
    
    public static void f(List<? super A> l){    // ? super A - любой класс, базовый по отношению к A
        B pa = new B();
        l.add(pa);
        
    }

    public static void main(String[] args) {
        MyComporator<D> m = new MyComporator<>();
        ArrayList<E> a = new ArrayList<>();
        //B pa = new B();
        f(a);
        
    }
    
}
