/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

import question1.*;

/**
 *
 * @author Hanh
 */
public class Main {

    public static void main(String[] args) {
        MyDoubleLinkedList my = new MyDoubleLinkedList();
        my.addToTail(3);
        my.addToTail(4);
        my.addToTail(5);
        my.addToTail(6);
        my.addToHead(2);
        my.addToHead(1);
        my.addAfter(new Node(1), 994);
        my.traverse();
        System.out.println(my.count());
        my.traverse();
        
        
        /*System.out.println(my.sum());
        System.out.println(my.avg());
        System.out.println(my.max());
        System.out.println(my.min());
        Node curr = new Node(994);
        System.out.println(my.checkNode(curr));*/
    }
}
