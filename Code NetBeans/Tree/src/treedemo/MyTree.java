package treedemo;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyTree {

    Node root;

    public MyTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int c) {
        Node node = new Node(c);
        if (isEmpty()) {
            root = node;
        } else {
            // ta đi tìm node cha của node can add 
            
            
        }
    }

    private void visit(Node p) {
        
    }

    private void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    private void posOrder(Node p) {
        if (p == null) {
            return;
        }
        posOrder(p.left);
        posOrder(p.right);
        visit(p);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void preOrder() {
        preOrder(root);
    }

    void posOrder() {
        posOrder(root);
    }

    void inOrder() {
        inOrder(root);
    }

    void bfs() {
        Deque<Node> d = new ArrayDeque<>();
        d.add(root);
        while (!d.isEmpty()) {
            Node cur = d.pop();
            visit(cur);
            if (cur.left != null) {
                d.add(cur.left);
            }
            if (cur.right != null) {
                d.add(cur.right);
            }
        }
    }
    
    
    
}
    



class main {

    public static void main(String[] args) {
        MyTree t = new MyTree();
        

        t.bfs();

    }
}
