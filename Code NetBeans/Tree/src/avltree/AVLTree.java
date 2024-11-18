/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Hanh
 */
public class AVLTree {

    private Node root;

    // Trả về chiều cao của một nút
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Cân bằng chiều cao của một nút
    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Xoay phải tại nút "y"
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Xoay trái tại nút "x"
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Thêm một khóa vào cây
    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Khóa đã tồn tại, không thực hiện gì
            return node;
        }

        // Cập nhật chiều cao của nút hiện tại
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Lấy chỉ số cân bằng
        int balance = balanceFactor(node);

        // Cân bằng lại cây
        if (balance > 1) {
            if (key < node.left.key) {
                return rotateRight(node);
            } else if (key > node.left.key) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balance < -1) {
            if (key > node.right.key) {
                return rotateLeft(node);
            } else if (key < node.right.key) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    // Thêm một khóa vào cây
    public void insert(int key) {
        root = insert(root, key);
    }

    // Duyệt cây theo thứ tự trước (Preorder)
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void breadthFirstTraversal() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.key + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);
        avlTree.breadthFirstTraversal();
        System.out.println("Duyệt cây theo thứ tự trước (Preorder):");
        avlTree.preOrder();
    }
}
