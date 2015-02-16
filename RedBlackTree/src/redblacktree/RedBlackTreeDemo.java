package redblacktree;

class RedBlackTree<Key extends Comparable<Key>, Value> {
    
    enum Color {RED,BLACK}
    private Node root;
    
    class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private Color color;
        private int subtreeCount;
        
        public Node(Key key, Value value, Color color, int n) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.subtreeCount = n;
        }
    }
    
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return (x.color == Color.RED);
    }
    
    private int subtreeSize(Node x) {
        if (x == null) {
            return 0;
        }
        return x.subtreeCount;
    }
    
    // number of entries
    public int size() {
        return subtreeSize(root);
    }
    
    public boolean isEmpty() {
        return (root == null);
    }
    
    public Value get(Key key) {
        return get(root, key);
    }
    
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }
    
    public boolean contains(Key key) {
        return (get(key) != null);
    }
    
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = Color.BLACK;
    }
    
    private Node rotateRight(Node x) {
        Node t = x.left;
        x.left = t.right;
        t.right = x;
        t.color = t.right.color;
        t.right.color = Color.RED;
        t.subtreeCount = x.subtreeCount;
        x.subtreeCount = subtreeSize(x.left) + subtreeSize(x.right) + 1;
        return t;
    }
    
    private Node rotateLeft(Node x) {
        Node t = x.right;
        x.right = t.left;
        t.left = x;
        t.color = t.left.color;
        t.left.color = Color.RED;
        t.subtreeCount = x.subtreeCount;
        x.subtreeCount = subtreeSize(x.left) + subtreeSize(x.right) + 1;
        return t;
    }
    
    private void swapColors(Node x) {
        if (x.color == Color.BLACK) {
            x.color = Color.RED;
        } else {
            x.color = Color.BLACK;
        }
        if (x.left.color == Color.BLACK) {
            x.left.color = Color.RED;
        } else {
            x.left.color = Color.BLACK;
        }
        if (x.right.color == Color.BLACK) {
            x.right.color = Color.RED;
        } else {
            x.right.color = Color.BLACK;
        }
    }
    
    // put in subtree under x
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key,value,Color.RED,1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left,key,value);
        } else if (cmp > 0) {
            x.right = put(x.right,key,value);
        } else {
            x.value = value;
        }
        
        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            swapColors(x);
        }
        x.subtreeCount = subtreeSize(x.left) + subtreeSize(x.right) + 1;
        return x;
    }
    
    
    
    
    
}
public class RedBlackTreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
