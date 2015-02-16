package visitorpattern;
class Myclass {
    public void accept(Visitor v){
        v.visit(this);
    }
}

interface Visitor{
    void visit(Myclass m);
}

class ConcreteVisitorA implements Visitor {
    public void visit(Myclass pa){
        //realization 1
    }
}

class ConcreteVisitorB implements Visitor {
    public void visit(Myclass pb){
        //realization 2
    }
}

public class VisitorPattern {

    public static void main(String[] args) {
        Myclass m = new Myclass();
        Visitor v = new ConcreteVisitorA();
        m.accept(v);
        Visitor v1 = new ConcreteVisitorB();
        m.accept(v1);
    }
    
}
