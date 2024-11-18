package treedemo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Node {
    int key;
    Node left;
    Node right;
    Node mid;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.mid = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getMid() {
        return mid;
    }

    public void setMid(Node mid) {
        this.mid = mid;
    }
    
    
}
