/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Hanh
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Phương thức chèn một giá trị vào cây
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Phương thức đệ quy để chèn giá trị vào cây
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // tim kiem
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    // Xóa một nút với giá trị `key` khỏi cây BST
    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Lấy số lượng nút trong cây BST
    int size() {
        return sizeRec(root);
    }

    int sizeRec(Node root) {
        if (root == null) {
            return 0;
        }
        return sizeRec(root.left) + sizeRec(root.right) + 1;
    }

    // Duyệt cây theo thứ tự BFS (Breadth-First Search)
    public void bfsTraversal() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // Duyệt cây theo thứ tự DFS (Depth-First Search) - Pre-order
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
    }

    private void preOrderTraversalRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    // Duyệt cây theo thứ tự DFS (Depth-First Search) - In-order
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRec(root.right);
        }
    }

    // Duyệt cây theo thứ tự DFS (Depth-First Search) - Post-order
    public void postOrderTraversal() {
        postOrderTraversalRec(root);
    }

    private void postOrderTraversalRec(Node root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Chèn các giá trị vào cây
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Duyệt cây theo BFS:");
        tree.bfsTraversal();

        System.out.println("\nDuyệt cây theo Pre-order DFS:");
        tree.preOrderTraversal();

        System.out.println("\nDuyệt cây theo In-order DFS:");
        tree.inOrderTraversal();

        System.out.println("\nDuyệt cây theo Post-order DFS:");
        tree.postOrderTraversal();
    }
}
