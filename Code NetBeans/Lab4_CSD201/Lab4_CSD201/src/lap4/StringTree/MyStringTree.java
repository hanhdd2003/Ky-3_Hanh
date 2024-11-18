package lap4.StringTree;

import java.util.LinkedList;
import java.util.Queue;

public class MyStringTree {

    Node root;
    int size;

    public MyStringTree() {
        this.root = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return this.root == null;
    }

    void clear() {
        this.root = null;
    }

    Node search(String x) {
        if (isEmpty()) {
            return null;
        } else {
            Node cur = this.root;
            while (cur != null) {
                if (cur.getData().equalsIgnoreCase(x)) {
                    return cur;
                } else {
                    if (cur.getData().compareToIgnoreCase(x)<0) {
                        cur = cur.right;
                    } else {
                        cur = cur.left;
                    }
                }
            }
            return null;
        }
    }

    void insert(String x) {
        if (isEmpty()) {
            this.root = new Node(x);
        } else {
            Node cur = this.root;
            while (cur != null) {
                if (cur.getData().equalsIgnoreCase(x)) {
                    System.out.println("Value already exist ");
                } else {
                    if (cur.getData().compareToIgnoreCase(x) < 0) {
                        if (cur.right == null) {
                            cur.right = new Node(x);
                            this.size++;
                        } else {
                            cur = cur.right;
                        }
                    } else {
                        if (cur.left == null) {
                            cur.left = new Node(x);
                            this.size++;
                        } else {
                            cur = cur.left;
                        }

                    }
                }
            }
        }
    }

    void breadth() {
        if (isEmpty()) {
            return;
        }
        Queue<Node> qu = new LinkedList();
        qu.add(this.root);
        while (!qu.isEmpty()) {
            Node po = qu.poll();
            System.out.println(po.getData() + ", ");
            if (po.left != null) {
                qu.add(po.left);
            }
            if (po.right != null) {
                qu.add(po.right);
            }
        }
    }

    void preorderR(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preorderR(p.left);
        preorderR(p.right);
    }

    void inorderR(Node p) {
        if (p == null) {
            return;
        }
        inorderR(p.left);
        visit(p);
        inorderR(p.right);
    }

    void postorderR(Node p) {
        if (p == null) {
            return;
        }
        postorderR(p.left);
        postorderR(p.right);
        visit(p);
    }

    int size() {
        return this.size;
    }

    void dele(String x) {
        if (isEmpty()) {
            return;
        } else {
            Node cur = this.root;
            while (cur != null) {
                if (cur.getData().compareToIgnoreCase(x) < 0) {
                    cur = cur.right;
                }
                if (cur.getData().compareTo(x) > 0) {
                    cur = cur.left;
                }
                if (cur.getData().equalsIgnoreCase(x)) {
                    if (cur.left == null && cur.right == null) {
                        cur = null;
                    } else if (cur.left != null && cur.right != null) {
                        Node max = this.findMax(cur);
                        String temp = max.getData();
                        dele(max.getData());
                        cur.setData(temp);
                        this.size--;

                    } else {
                        if (cur.right != null) {
                            cur.setData(cur.right.getData());
                            cur.right = null;
                        } else {
                            cur.setData(cur.left.getData());
                            cur.left = null;
                        }
                    }
                }

            }
        }
    }

    String min() {
        if (isEmpty()) {
            return null;
        } else {
            Node cur = this.root;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur.getData();
        }
    }

    String max() {
        if (isEmpty()) {
            return null;
        } else {
            Node cur = this.root;
            while (cur.right != null) {
                cur = cur.right;
            }
            return cur.getData();
        }
    }

    Node findMax(Node p) {
        Node cur = p.left;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    Node findFatherMax(Node p) {
        Node cur = p.left;
        while (cur.right.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    void visit(Node p) {
        if (p == null) {
            return;
        } else {
            System.out.print(p.getData() + ", ");
        }
    }

}
