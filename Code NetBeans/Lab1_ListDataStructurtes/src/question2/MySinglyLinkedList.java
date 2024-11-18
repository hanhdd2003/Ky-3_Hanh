/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Hanh
 */
public class MySinglyLinkedList {

    Node head;
    Node tail;
    private int size;

    public MySinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    //---------------------1. add to head------------
    public void addToHead(String x) {
        Node newNode = new Node(x);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    //---------------------2. add to tail-------------
    public void addToTail(String x) {
        Node newNode = new Node(x);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    //-------------------3. add after p(value x)---------
    public void addAfter(Node p, String x) {
        if(checkNode(p)){
            Node newNode = new Node(x);
            int index = search(p.data);
            if(index == this.size-1){
                addToTail(x);
            }else{
                Node curr = foundNode(p);
                newNode.next = curr.next;
                curr.next = newNode;
                this.size++;
            }
        }else{
            System.out.println("Not found Node "+p);
        }
    }

    //--------------------4. traverse-----------
    public void traverse() {
        Node temp = this.head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //--------------------5. deleteFromHead------
    public String deleteFromHead() {
        if (this.size == 0) {
            System.out.println("List is empty");
        } else if(this.size == 1){
            String data = this.head.data;
            this.head = null;
            this.tail = null;
            this.size--;
            return data;
        }
        else {
            Node firstNode = this.head;
            Node secondNode = firstNode.next;
            String data = firstNode.data;
            this.head = secondNode;
            this.size--;
            return data;
        }
        return null;
    }

    //--------------------6. deleteFromTail() ------
    public String deleteFromTail() {
        if (this.head == null) {
            System.out.println("List is empty");
            return null;
        } else if (this.head.next == null) {
            String data = this.head.data;
            this.head = null;
            this.tail = null;
            this.size--;
            return data;
        } else {
            Node lastNode = this.head;
            Node newLast = this.head;
            String data = "";
            while (lastNode.next != null) {
                newLast = lastNode;
                data = lastNode.data;
                lastNode = lastNode.next;
            }
            
            newLast.next = null;
            this.tail = newLast;
            this.size--;
            return data;
        }
    }
    
    //----------------7. deleteAter(p) -----------------------
    public String deleteAfter(Node p){
        String data;
        if(checkNode(p)){
            int index = search(p.data);
            if(index == this.size-2){
                deleteFromTail();
            }else if(index == this.size-1){
                System.out.println("Can't delete " +p);
            }
            else{
                Node temp = foundNode(p);
                data = temp.next.data;
                temp.next = temp.next.next;
                this.size--;
                return data;
            }
        }else{
            System.out.println("Not found "+p);
        }
        return "";
    }
    
    //----------------8. del(x)--------------------
    public void del(String x){
        int a = search(x);
        if (a == -1) {
            System.out.println("Not Found " + x);
        }else if(a == 0){
            this.deleteFromHead();
            return;
        } else if(a==this.size -1){
            this.deleteFromTail();
            return;
        }
        else {
            Node prev = this.head;
            Node current = prev.next;
            Node next = current.next;
            while (current != null) {
                if (current.data == x) {
                    break;
                }
                prev = current;
                current = next;
                next = next.next;
            }
            prev.next = next;
            this.size--;
        }
    }
    
    //---------------9. search(x)-------------------
    public int search(String x){
        Node current = this.head;
        int count = 0;
        int index = -1;
        while (current != null) {
            if (current.data.equalsIgnoreCase(x)) {
                index = count;
                break;
            }
            current = current.next;
            count++;
        }
        return index;
    }
    
    //---------------10. count()--------------------
    public int count(){
        int count = 0; 
        Node temp = this.head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    //--------------11.del(i) ------------
   
    //-----------------12. sort ascending-----------------
    public void sort(){
        ArrayList<Node> list = new ArrayList<>();
        Node temp = this.head;
        for(int i=0 ; i<this.size ; i++){
            list.add(i, temp);
            temp = temp.next;
        }
        Comparator<Node> c = Comparator.comparing(Node::getData);
        Collections.sort(list, c);
        
        for(int i=0 ; i<list.size(); i++){
            System.out.print(list.get(i).data);
            if(i<list.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    //-----------------13-----------------
    
    
    //--------------14. toArray ------------------
    public String[] toArray(){
        Node current = this.head;
        String[] a = (String[]) new String[this.size];
        for(int i=0 ; i<this.size ; i++){
            a[i] = current.data;
            current = current.next;
        }
        return Arrays.copyOf(a, size);
    }
    //-----------------15-----------------
    //-----------------16-----------------
    
    public void addBefore(Node p, String x){
        if(!checkNode(p)){
            System.out.println("Not exists ");
            return;
        }else{
            Node newNode = new Node(x);
            
        }
    }
    
    public Node foundNode(Node p){
        if(!checkNode(p)){
            System.out.println("Not exists ");
            return null;
        }else{
            Node current = this.head;
            while(current != null){
                if(current.data == p.data){
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }
    
    public Boolean checkNode(Node p){
        Node temp = this.head;
        while(temp != null){
            if(temp.data == p.data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
