/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite2;

import java.util.ArrayList;
import java.util.List;

class Polish {
    String express;
    String result;
    List<Character> digit = new ArrayList<>();
    List<Character> operation = new ArrayList<>();
    public Polish(String expr) {
        express = expr;
    }
    public void transformToPolish(){
        for (int i = 0; i < express.length(); i++) {
            char w = express.charAt(i);
            switch(w) {
                case '(':   operation.add(w);
                    break;
                case ')':   {
                    int cap = operation.size()-1;
                    char sk = operation.remove(cap);
                    if (sk!='('){
                        digit.add(sk);
                    }
                    while (sk!='(') {
                        cap = operation.size()-1;
                        sk = operation.remove(cap);
                        if(sk!='(') {
                            digit.add(sk);
                        } else {
                            break;
                        }
                    }
                }
                    break;
                case '*': case '/': operation.add(w);
                    break;
                case '+': case '-': {
                    char op;
                    if (operation.size()>0) {
                        op = operation.get(operation.size()-1);
                        if (op == '*' || op == '/') {
                            for (int j = operation.size()-1; j >= 0; j--) {
                                digit.add(operation.remove(j));
                            }
                        }
                    }
                    operation.add(w);
                }
                    break;
                //варианты для чисел
                default: digit.add(w);
            }
        }
        for (int j = operation.size()-1; j >=0; j--) {
            digit.add(operation.remove(j));
        }
    }
    
    public List<Character> getPolish(){
                return digit;
    }
}
/**
 *
 * @author volodya
 */

interface Component{
    public int calculate();
    public boolean setLeft(Component c);
    public boolean setRight(Component c);
    public Component getLeft();
    public Component getRight();
}
class Operation implements Component{
    Component leftOperand;
    Component rightOperand;
    char op;
    public Operation(char op){
        this.op = op;
    }
    public boolean setLeft(Component c) {
        leftOperand = c;
        return true;
    }
    public boolean setRight(Component c) {
        rightOperand = c;
        return true;
    }
    public int calculate(){
        if (op == '*') {
            return leftOperand.calculate()*rightOperand.calculate();
        }
        if (op == '/') {
            return leftOperand.calculate()/rightOperand.calculate();
        }
        if (op == '+') {
            return leftOperand.calculate()+rightOperand.calculate();
        }
        return leftOperand.calculate()-rightOperand.calculate();
    }

    @Override
    public Component getLeft() {
        return leftOperand;
    }

    @Override
    public Component getRight() {
        return rightOperand;
    }
}
class Digit implements Component {
    int value;
    public Digit(int value){
        this.value = value;
    }
    @Override
    public int calculate(){
        return value;
    }
    @Override
    public boolean setLeft(Component c){
        return false;
    }
    @Override
    public boolean setRight(Component c){
        return false;
    }

    @Override
    public Component getLeft() {
        return null;
    }

    @Override
    public Component getRight() {
        return null;
    }
}

class Tree implements Component{
    Component root;
    List<Character> polish;
    public Tree(List<Character> polish){
        this.polish = polish;

    }
    public Tree(Component root) {
        this.root = root;
    }

    @Override
    public int calculate() {
        return root.calculate();
    }

    @Override
    public boolean setLeft(Component c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setRight(Component c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean addElementToTree(Component element, Component root){
        if (root == null) {
            root = element;
            return true;
        }
        if (root.getRight() == null && !(root instanceof Digit)){
            root.setRight(element);
            return true;
        }
        if (root.getRight() != null && !(root instanceof Digit)){
            if(addElementToTree(element, root.getRight())) {
                return true;
            }
        }
        if (root.getLeft() == null && !(root instanceof Digit)){
            root.setLeft(element);
            return true;
        }
        if (root.getLeft() != null && !(root instanceof Digit)){
            if(addElementToTree(element, root.getLeft())){
                return true;
            }
        }
        
        return false;
    }
    
    public Tree createTree(List<Character> polish) {
        Component root = null;
        while(!polish.isEmpty()) {
            char w = polish.remove(polish.size()-1);
        
            if (w == '+' || w == '*' || w == '-' || w == '/') {
                Component element = new Operation(w);
                if (root == null) {
                    root = element;
                } else {
                    addElementToTree(element, root);
                }                
            } else {
                Component digit = new Digit(w-'0');
                if (root == null) {
                    root = digit;
                } else {
                    addElementToTree(digit,root);
                }
            }
        }
        return new Tree(root);
    }

    @Override
    public Component getLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
public class Composite2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Polish p = new Polish("(5+6)*7+2*(3+4)");
        p.transformToPolish();
        Tree t = new Tree(p.getPolish());
        t = t.createTree(p.getPolish());
        System.out.println(t.calculate());
        
    }
    
}
