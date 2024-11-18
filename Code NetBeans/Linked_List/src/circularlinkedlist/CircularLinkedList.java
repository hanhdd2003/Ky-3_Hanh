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

    public void addNodeBeforeK(int k, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        if (head.data == k) {
            addToFront(data);
            return;
        }

        Node current = head;
        while (current.next != head) {
            if (current.next.data == k) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public void addNodeAfterK(int k, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node current = head;
        while (current.next != head) {
            if (current.data == k) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }

        if (current.data == k) {
            newNode.next = head;
            current.next = newNode;
        }
    }

    public void deleteNode(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != head) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void deleteFront() {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }

        current.next = head.next;
        head = head.next;
    }

    public void deleteEnd() {
        if (head == null) {
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node current = head;
        Node prev = null;
        while (current.next != head) {
            prev = current;
            current = current.next;
        }

        prev.next = head;
    }

    public void deleteNodeBeforeK(int k) {
        if (head == null) {
            return;
        }

        if (head.data == k) {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != head) {
            if (current.next.data == k) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void deleteNodeAfterK(int k) {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current.next != head) {
            if (current.data == k) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        if (current.data == k) {
            head = head.next;
            current.next = head;
        }
    }

    public void traverse() {
        if (head == null) {
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
    }

    public int getNodeValue(int data) {
        if (head == null) {
            return -1; // Giá trị không tồn tại
        }

        Node current = head;
        do {
            if (current.data == data) {
                return current.data;
            }
            current = current.next;
        } while (current != head);

        return -1; // Giá trị không tồn tại
    }

    public void sortList() {
        if (head == null || head.next == head) {
            return; // Danh sách rỗng hoặc chỉ có một phần tử, không cần sắp xếp
        }

        Node current = head;
        do {
            Node index = current.next;
            do {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            } while (index != head);
            current = current.next;
        } while (current != head);
    }

    public Node findNode(int x) {
        if (head == null) {
            return null; // Danh sách rỗng
        }

        Node current = head;
        do {
            if (current.data == x) {
                return current; // Tìm thấy nút có giá trị x
            }
            current = current.next;
        } while (current != head);

        return null; // Không tìm thấy nút có giá trị x
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
