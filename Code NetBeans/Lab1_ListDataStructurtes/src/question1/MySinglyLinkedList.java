/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

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
    public void addToHead(int x) {
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
    public void addToTail(int x) {
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
    public void addAfter(Node p, int x) {
        if (checkNode(p)) {
            Node newNode = new Node(x);
            int index = search(p.data);
            if (index == this.size - 1) {
                addToTail(x);
            } else {
                Node curr = foundNode(p);
                newNode.next = curr.next;
                curr.next = newNode;
                this.size++;
            }
        } else {
            System.out.println("Not found Node " + p);
        }
    }

    //--------------------4. traverse-----------
    public void traverse() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //--------------------5. deleteFromHead------
    public int deleteFromHead() {
        if (this.size == 0) {
            System.out.println("List is empty");
        } else if (this.size == 1) {
            int data = this.head.data;
            this.head = null;
            this.tail = null;
            this.size--;
            return data;
        } else {
            Node firstNode = this.head;
            Node secondNode = firstNode.next;
            int data = firstNode.data;
            this.head = secondNode;
            this.size--;
            return data;
        }
        return -1;
    }

    //--------------------6. deleteFromTail() ------
    public int deleteFromTail() {
        if (this.head == null) {
            System.out.println("List is empty");
            return -1;
        } else if (this.head.next == null) {
            int data = this.head.data;
            this.head = null;
            this.tail = null;
            this.size--;
            return data;
        } else {
            Node lastNode = this.head;
            Node newLast = this.head;
            int data = 0;
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
    public int deleteAfter(Node p) {
        int data;
        if (checkNode(p)) {
            int index = search(p.data);
            if (index == this.size - 2) {
                deleteFromTail();
            } else if (index == this.size - 1) {
                System.out.println("Can't delete " + p);
            } else {
                Node temp = foundNode(p);
                data = temp.next.data;
                temp.next = temp.next.next;
                this.size--;
                return data;
            }
        } else {
            System.out.println("Not found " + p);
        }
        return 0;
    }

    //----------------8. del(x)--------------------
    public void del(int x) {
        int a = search(x);
        if (a == -1) {
            System.out.println("Not Found " + x);
        } else if (a == 0) {
            this.deleteFromHead();
            return;
        } else if (a == this.size - 1) {
            this.deleteFromTail();
            return;
        } else {
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
    public int search(int x) {
        Node current = this.head;
        int count = 0;
        int index = -1;
        while (current != null) {
            if (current.data == x) {
                index = count;
                break;
            }
            current = current.next;
            count++;
        }
        return index;
    }

    //---------------10. count()--------------------
    public int count() {
        int count = 0;
        Node temp = this.head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    //--------------11.del(i) ------------
    //-----------------12. sort ascending-----------------
    public void sort() {
        ArrayList<Node> list = new ArrayList<>();
        Node temp = this.head;
        for (int i = 0; i < this.size; i++) {
            list.add(i, temp);
            temp = temp.next;
        }
        Comparator<Node> c = Comparator.comparing(Node::getData);
        Collections.sort(list, c);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).data);
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    //-----------------13-----------------

    //--------------14. toArray ------------------
    public int[] toArray() {
        Node current = this.head;
        int[] a = (int[]) new int[this.size];
        for (int i = 0; i < this.size; i++) {
            a[i] = current.data;
            current = current.next;
        }
        return Arrays.copyOf(a, size);
    }
    //-----------------15-----------------
    //-----------------16-----------------

    public void addBefore(Node p, int x) {
        if (!checkNode(p)) {
            System.out.println("Not exists ");
            return;
        } else {
            Node newNode = new Node(x);

        }
    }

    public Node foundNode(Node p) {
        if (!checkNode(p)) {
            System.out.println("Not exists ");
            return null;
        } else {
            Node current = this.head;
            while (current != null) {
                if (current.data == p.data) {
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }

    public Boolean checkNode(Node p) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.data == p.data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //-----------------17-----------------
    //-----------------18-----------------
    public int max() {
        Node curr = this.head;
        int max = this.head.data;
        while (curr != null) {
            if (curr.data > max) {
                max = curr.data;
            }
            curr = curr.next;
        }
        return max;
    }

    //-----------------19-----------------
    public int min() {
        Node curr = this.head;
        int min = this.head.data;
        while (curr != null) {
            if (curr.data < min) {
                min = curr.data;
            }
            curr = curr.next;
        }
        return min;
    }

    //-----------------20-----------------
    public int sum() {
        int data = 0;
        Node current = this.head;
        while (current != null) {
            data = data + current.data;
            current = current.next;
        }
        return data;
    }

    //-----------------21-----------------
    public double avg() {
        return (double) this.sum() / this.size;
    }
    //-----------------22. sorted-----------------

    //-----------------23-----------------
    //-----------------24-----------------
    //-----------------25-----------------
}
