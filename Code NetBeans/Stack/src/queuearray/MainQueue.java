/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearray;

import stackarray.Student;

/**
 *
 * @author Hanh
 */
public class MainQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        Student s1 = new Student("HE1243", "Đức");
        Student s2 = new Student("HE0093", "Hùng");
        Student s3 = new Student("HE1523", "Thắng");
        Student s4 = new Student("HE8653", "Chung");
        Student s5 = new Student("HE0003", "Thủy");
        /* queue.enQueue(s1);
        queue.enQueue(s2);
        queue.enQueue(s3);
        queue.enQueue(s4);
        queue.enQueue(s5);
        queue.traverse();*/

        LinkedQueue link = new LinkedQueue();
        link.enQueue(s1);
        link.enQueue(s2);
        link.enQueue(s3);
        link.enQueue(s4);
        link.enQueue(s5);
        link.traverse();
        System.out.println("------");
        System.out.println(link.deQueue());
        System.out.println(link.deQueue());
        System.out.println("------");

        link.traverse();
    }

}
