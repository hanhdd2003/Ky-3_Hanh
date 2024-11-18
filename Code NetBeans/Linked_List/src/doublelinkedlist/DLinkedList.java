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
    public boolean isEmpty() {
        return this.size == 0;
        //return this.head = null;
        // return this.tail = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            newNode.prev = tail;
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
        }
    }

    public void addBeforeK(int data, int k) {
        if (k < 0 || k > this.size) {
            System.out.println("IVALID INDEX");
            return;
        } else if (k == 0) {
            this.addFirst(data);
            return;
        } else if (k == this.size) {
            this.addLast(data);
            return;
        }

        Node current = this.head;
        int count = 0;
        while (current != null) {
            if (count == k) {
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

    public void addAfterK(int data, int k) {
        if (k < -1 || k > this.size - 1) {
            System.out.println("IVALID INDEX");
            return;
        } else if (k == -1) {
            this.addFirst(data);
            return;
        } else if (k == this.size - 1) {
            this.addLast(data);
            return;
        }
        Node current = this.head;
        int count = 0;
        while (current != null) {
            if (count == k) {
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

    public void removeFromFront() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }
    }

    public void removeFromEnd() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        }
    }

    public void deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || head == null) {
            return;
        }

        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        } else {
            head = nodeToDelete.next;
        }

        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        } else {
            tail = nodeToDelete.prev;
        }
    }

    public void deleteNodeBeforeK(int k) {
        Node current = search(k);
        if (current != null && current.prev != null) {
            deleteNode(current.prev);
        }
    }

    public void deleteNodeAfterK(int k) {
        Node current = search(k);
        if (current != null && current.next != null) {
            deleteNode(current.next);
        }
    }

    public void addNodeBeforeK(int k, int data) {
        Node current = search(k);
        if (current != null) {
            Node newNode = new Node(data);
            newNode.prev = current.prev;
            newNode.next = current;
            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode;
            }
            current.prev = newNode;
        }
    }

    public void addNodeAfterK(int k, int data) {
        Node current = search(k);
        if (current != null) {
            Node newNode = new Node(data);
            newNode.prev = current;
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
        }
    }

    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void sortFromStartToK(int k) {
        if (head == null || head.next == null || k <= 1) {
            return; // Không cần sắp xếp nếu danh sách rỗng, có một nút hoặc k <= 1
        }

        Node current = head;
        Node start = head;
        int count = 1;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k || current == null) {
            return; // Không đủ nút hoặc không tìm thấy vị trí k
        }

        Node prevK = current;
        prevK.next = null; // Tách danh sách từ vị trí k
        sortList(start); // Sắp xếp danh sách từ đầu đến k

        // Nối lại danh sách đã sắp xếp
        while (start.next != null) {
            start = start.next;
        }
        start.prev = prevK;
        prevK.next = start;
    }

    public void sortFromKToEnd(int k) {
        if (head == null || head.next == null) {
            return; // Không cần sắp xếp nếu danh sách rỗng hoặc chỉ có một nút
        }

        Node current = head;
        int count = 1;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k || current == null) {
            return; // Không đủ nút hoặc không tìm thấy vị trí k
        }

        Node start = current.next;
        start.prev = null; // Tách danh sách từ vị trí k
        sortList(start); // Sắp xếp danh sách từ vị trí k đến cuối

        // Nối lại danh sách đã sắp xếp
        while (current.next != null) {
            current = current.next;
        }
        current.next = start;
        start.prev = current;
    }

    public void sortList(Node start) {
        if (start == null || start.next == null) {
            return; // Không cần sắp xếp nếu danh sách rỗng hoặc chỉ có một nút
        }

        Node current = start;
        while (current != null) {
            Node temp = current;
            while (temp != null) {
                if (current.data > temp.data) {
                    int tempData = current.data;
                    current.data = temp.data;
                    temp.data = tempData;
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }

    public void bubbleSort() {
        if (head == null || head.next == null) {
            return; // Không cần sắp xếp nếu danh sách rỗng hoặc chỉ có một nút
        }

        boolean swapped;
        Node end = null;

        do {
            swapped = false;
            Node current = head;

            while (current.next != end) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            end = current;
        } while (swapped);
    }

}
