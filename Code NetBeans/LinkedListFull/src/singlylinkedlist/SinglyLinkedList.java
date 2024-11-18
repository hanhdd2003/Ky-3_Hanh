/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 *
 * @author Hanh
 */
public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
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
            head = newNode;
        }
        size++;
    }

    // Phương thức thêm một phần tử vào cuối danh sách
    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (this.size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
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
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Các phương thức khác (contains, printList, size, isEmpty) giống như ví dụ trước.
    // Phương thức kiểm tra xem phần tử có tồn tại trong danh sách không
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

    void insertionSort() {
        if (head == null || head.next == null) {
            return; // Already sorted
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            if (sorted == null || current.data <= sorted.data) {
                current.next = sorted;
                sorted = current;
            } else {
                Node search = sorted;
                while (search.next != null && current.data > search.next.data) {
                    search = search.next;
                }
                current.next = search.next;
                search.next = current;
            }
            current = next;
        }

        head = sorted;
    }
// quick sort

    void quickSort(Node low, Node high) {
        if (low != null && low != high && low != high.next) {
            Node pivot = partition(low, high);
            quickSort(low, pivot);
            quickSort(pivot.next, high);
        }
    }

    Node partition(Node low, Node high) {
        int pivotData = high.data;
        Node i = low;
        for (Node j = low; j != high; j = j.next) {
            if (j.data <= pivotData) {
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
                i = i.next;
            }
        }
        int temp = i.data;
        i.data = high.data;
        high.data = temp;
        return i;
    }
// merge sort

    Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
// bubbler sort

    void bubbleSort() {
        Node current, tail;
        for (tail = null; tail != head; tail = current) {
            for (current = head; current.next != tail; current = current.next) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addToFront(3);
        list.addToFront(2);
        list.addToFront(1);

        list.addToEnd(4);
        list.addToEnd(5);

        list.printList(); // In danh sách: 1 2 3 4 5
    }
}
