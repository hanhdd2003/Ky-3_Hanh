/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import question1.*;

/**
 *
 * @author Hanh
 */
public class Main {

    public static void main(String[] args) {
        MySinglyLinkedList my = new MySinglyLinkedList();
        my.addToTail("Chuỗi 3,");
        my.addToTail("Chuỗi 4,");
        my.addToTail("Chuỗi 5,");
        my.addToTail("Chuỗi 6,");
        my.addToHead("Chuỗi 6,");
        my.addToHead("Chuỗi 2,");
        my.addToHead("Chuỗi 1,");
        my.addAfter(new Node("Chuỗi 5,"), "Chuỗi 999,");
        my.traverse();
        System.out.println(my.count());
        
      
    }
}
