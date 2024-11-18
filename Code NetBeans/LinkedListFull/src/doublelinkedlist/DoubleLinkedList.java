/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinkedlist;

/**
 *
 * @author Hanh
 */
public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Phương thức thêm một phần tử vào đầu danh sách
    public void addToFront(int data) {
        Node newNode = new Node(data);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head = newNode;
            newNode.prev = null;
        }
        size++;
    }

    // Phương thức thêm một phần tử vào cuối danh sách
    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
        }
        size++;
    }

    // Phương thức xóa một phần tử khỏi danh sách
    public boolean remove(int data) {
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }
        if (tail.data == data) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            if (tail == null) {
                head = null;
            }
            size--;
            return true;
        }
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Các phương thức khác (contains, printList, size, isEmpty) giống như ví dụ trước.
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Phương thức in danh sách
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.addToFront(3);
        list.addToFront(2);
        list.addToFront(1);

        list.addToEnd(4);
        list.addToEnd(5);

        list.printList(); // In danh sách: 1 2 3 4 5
    }
}
