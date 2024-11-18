/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlyLlnkedlist;

/**
 *
 * @author Hanh
 */
public class Main {
    
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addFirst(1);
        myList.addAfterk(3, 5);
        myList.addLast(4);
//        int a = myList.findIndex(3);
//        if (a == -1) {
//            System.out.println("Not found!");
//        } else {
//            System.out.println("Found 3 index: " + a);
//        }
        myList.traverse();
//        myList.deleteFirst();
//        myList.traverse();
//        myList.deleteLast();
//        myList.traverse();
        System.out.println(myList.getNode_SecondHaveData(4));
        
    }
}
