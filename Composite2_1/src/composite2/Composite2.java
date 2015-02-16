/*
 * Simple calculator based on polish notation and composite pattern
 * Can use real and integer multidigital numbers as operands
 */
package composite2;

import java.util.ArrayList;
import java.util.List;

class Polish {
    String express;
    List<String> result;
    List<String> digit = new ArrayList<>();
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
                        digit.add(String.valueOf(sk));
                    }
                    while (sk!='(') {
                        cap = operation.size()-1;
                        sk = operation.remove(cap);
                        if(sk!='(') {
                            digit.add(String.valueOf(sk));
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
                                digit.add(String.valueOf(operation.remove(j)));
                            }
                        }
                    }
                    operation.add(w);
                }
                    break;
                //варианты для чисел
                default: {
                    StringBuilder s = new StringBuilder();
                    while (Character.isDigit(w) || w == '.') {
                        s.append(w);
                        w = (++i < express.length()) ? express.charAt(i) : '`';
                    }
                    i--;
                    digit.add(s.toString());
                }
            }
        }
        for (int j = operation.size()-1; j >=0; j--) {
            digit.add(String.valueOf(operation.remove(j)));
        }
    }
    
    public List<String> getPolish(){
                return digit;
    }
}
/**
 *
 * @author volodya
 */

interface Component{
    public float calculate();
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
    @Override
    public boolean setLeft(Component c) {
        leftOperand = c;
        return true;
    }
    @Override
    public boolean setRight(Component c) {
        rightOperand = c;
        return true;
    }
    @Override
    public float calculate(){
        if (op == '*') {
            return leftOperand.calculate()*rightOperand.calculate();
        }
        if (op == '/') {
            return (float)leftOperand.calculate()/rightOperand.calculate();
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
    float value;
    public Digit(float value){
        this.value = value;
    }
    @Override
    public float calculate(){
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
    List<String> polish;
    public Tree(List<String> polish){
        this.polish = polish;

    }
    public Tree(Component root) {
        this.root = root;
    }

    @Override
    public float calculate() {
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
    
    private static boolean addElementToTree(Component element, Component root){
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
    
    public static Tree createTree(List<String> polish) {
        Component root = null;
        while(!polish.isEmpty()) {
            String w = polish.remove(polish.size()-1);
            char op = w.charAt(0);
            if (op == '+' || op == '*' || op == '-' || op == '/') {
                Component element = new Operation(op);
                if (root == null) {
                    root = element;
                } else {
                    addElementToTree(element, root);
                }                
            } else {
                Component digit = new Digit(Float.parseFloat(w));
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
     * @throws composite2.InvalidArgs
     */
    public static void main(String[] args) throws InvalidArgs{
        // TODO code application logic here
//        try {
//            if (args.length != 1) {
//                throw new InvalidArgs();
//            }
            String express;
            express = "(9.1+40.9)*0.1-1/2";
            Polish p = new Polish(express);
            p.transformToPolish();
            Tree t;
            System.out.println("Express: " + express);
            System.out.println("Polish Notation: " + p.getPolish());
            t = Tree.createTree(p.getPolish());
            System.out.println("Result: " + t.calculate());
            
//        } catch (InvalidArgs e) {
//            System.err.println(e.value);
//        }

        
    }
}
