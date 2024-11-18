
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class Tree {

    Node root;

    public Tree() {
        this.root = null;
    }

    public void BFS() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(this.root);
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        System.out.print(" " + node.key);
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
    
    // Duyệt cây theo BFS
    public void breadthFirstTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.key + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    
    public void depthFirstTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.key + " ");
        depthFirstTraversal(node.left);
        depthFirstTraversal(node.right);
    }

    // add recursive
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        // so sánh giá trị và di chuyển xuống cây
        if (data < root.key) {
            root.left = insert(root.left, data);
        } else if (data > root.key) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // traverse in-order
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public Node removeRecursive(int key, Node root) {
        // base case: nếu cây rỗng hoặc đã tìm thấy nút cần xóa
        if (root == null) {
            return root;
        }
        //tìm nút cần xóa
        if (key < root.key) {
            root.left = removeRecursive(key, root.left);
        } else if (key > root.key) {
            root.right = removeRecursive(key, root.right);
        } else {
            // nếu nút cần xóa có 1 hoặc không có con
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Nếu nút cần xóa có cả hai con
            // Tìm nút kế tiếp lớn hơn trong cây con trái (hoặc nút trước đó nhỏ hơn trong cây con phải)
            root.key = minValue(root.right);

            // Xóa nút kế tiếp
            root.right = removeRecursive(root.key, root.right);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Breadth First Traversal (BFS) of binary tree:");
        tree.BFS();
    }
}
