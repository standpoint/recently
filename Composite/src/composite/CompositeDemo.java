/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;
interface Tree { 
    
}

class Leaf implements Tree {
    private int value;
    public Leaf(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}

class Node implements Tree {
    private Operator op;
    private Tree left;
    private Tree right;
    public Node(Tree left, Operator op, Tree right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
    public Tree getLeft() {
        return left;
    }
    public Tree getRight() {
        return right;
    }
    public Operator getOp() {
        return op;
    }
}

enum Operator {
    PLUS("+"), MINUS("-"), MULT("*"), DIV("/");
    private String name;
    private Operator(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
    public int apply(int left, int right) throws Exception {
        switch (this) {
            case PLUS:  return (left + right);
            case MINUS: return (left - right);
            case MULT:  return (left*right);
            case DIV:   return (left/right);
            default:    throw new Exception("Illegal operator found:\t" + name);
        }
    }
}
/**
 *
 * @author volodya
 */
public class CompositeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Tree t = new Node(
                new Node(
                    new Node(
                        new Leaf(2), Operator.PLUS, new Leaf(3)), 
                        Operator.MULT, 
                        new Leaf(6)), 
                    Operator.PLUS, 
                    new Node(
                        new Leaf(18), Operator.MULT, new Leaf(4)
                    )
            );
            System.out.println(evaluate(t));
        } catch (Exception e) {
            e.toString();
        }
    }
    
    public static int evaluate(Tree w) throws Exception {
        int answer;
        if (w instanceof Leaf) {
            return ((Leaf)w).getValue();
        } else {
            Tree l = ((Node)w).getLeft();
            Tree r = ((Node)w).getRight();
            Operator o = ((Node)w).getOp();
            int leftAnswer = evaluate(l);
            int rightAnswer = evaluate(r);
            answer = o.apply(leftAnswer, rightAnswer);
        }
        return answer;
    }
}
