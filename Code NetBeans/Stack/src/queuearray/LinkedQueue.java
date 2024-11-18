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
public class LinkedQueue {
    private Node font;
    private Node back;
    private int size;

    public LinkedQueue() {
        this.back = null;
        this.font = null;
        this.size = 0;
    }
    
    public void enQueue(Student s){
        Node newNode = new Node(s);
        if(this.size == 0){
            this.font = this.back = newNode;
            this.size++;
        }else{
            this.back.next = newNode;
            this.back = newNode;
            this.size++;
        }
    }
    
    public Student deQueue(){
        if(this.size == 0){
            System.out.println("Queue is empty");
            return null;
        }else{
            Student s = this.font.data;
            this.font = this.font.next;
            this.size--;
            return s;
        }
    }
    
    public void traverse(){
        Node current = this.font;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    
}
