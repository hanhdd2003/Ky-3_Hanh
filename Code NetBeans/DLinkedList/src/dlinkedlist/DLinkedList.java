/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlinkedlist;

/**
 *
 * @author Hanh
 */
public class DLinkedList {
    Node head;
    Node tail;
    private int size;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // add: add first, last, before k, after k.
    // traverse: in list
    //remove: first, last, k 
    //get: lay k
    //contain:  boolean , kiem tra chua hay khong
    
    public boolean isEmpty(){
        return this.size == 0;
        //return this.head = null;
        // return this.tail = null;
    }
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        }else{
            newNode.next = this.head;
            this.head.prev = newNode;  
            this.head = newNode;
            this.size++;
        }
    }
    
    public void addLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        }else{
            newNode.prev = tail;
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
        }
    }
    
    public void addBeforeK(int data, int k){
        if( k < 0 || k > this.size){
            System.out.println("IVALID INDEX");
            return;
        }else if(k == 0){
            this.addFirst(data);
            return;
        }else if(k == this.size){
            this.addLast(data);
            return;
        }
        
        Node current = this.head;
        int count = 0;
        while(current != null){
            if(count == k){
                Node newNode = new Node(data);
                current.prev.next = newNode;
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev = newNode;
                this.size++;
            }
            current = current.next;
            count++;
        }
    }
    
    public void addAfterK(int data, int k){
        if( k <-1 || k >this.size-1){
            System.out.println("IVALID INDEX");
            return;
        }else if (k == -1){
            this.addFirst(data);
            return;
        }else if(k == this.size-1){
            this.addLast(data);
            return;
        }
        Node current = this.head;
        int count = 0;
        while(current != null){
            if(count == k){
                Node newNode = new Node(data);
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
                this.size++;
            }
            current = current.next;
            count++;
        }
    }
    
    public void traverse(){
        Node current = this.head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    
}
