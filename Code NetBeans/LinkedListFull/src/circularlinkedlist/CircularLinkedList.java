/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlinkedlist;

/**
 *
 * @author Hanh
 */
public class CircularLinkedList {

    private Node head;
    private Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    // Phương thức thêm một phần tử vào đầu danh sách
    public void addToFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Đặt liên kết đến đầu để tạo thành vòng tròn
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Cập nhật liên kết cuối với đầu để duy trì vòng tròn
        }
    }

    // Phương thức thêm một phần tử vào cuối danh sách
    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Đặt liên kết đến đầu để tạo thành vòng tròn
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Cập nhật liên kết cuối với đầu để duy trì vòng tròn
        }
    }

    // Các phương thức khác (remove, contains, printList) giống như ví dụ trước.
    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.addToFront(3);
        list.addToFront(2);
        list.addToFront(1);

        list.addToEnd(4);
        list.addToEnd(5);

        list.printList(); // In danh sách: 1 2 3 4 5
    }
}
