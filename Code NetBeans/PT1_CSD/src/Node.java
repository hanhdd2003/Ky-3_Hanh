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
    Student data;
    Node next;
    Node prev;

    public Node(Student data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
}
