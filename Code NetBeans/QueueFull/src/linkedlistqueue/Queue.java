/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistqueue;

/**
 *
 * @author Hanh
 */
public class Queue {

    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Phương thức Enqueue: Thêm một phần tử vào rear của queue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Phương thức Dequeue: Loại bỏ phần tử từ front của queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Giá trị không hợp lệ
        }
        int removedItem = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return removedItem;
    }

    // Phương thức Peek: Xem phần tử ở front của queue mà không loại bỏ nó
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Giá trị không hợp lệ
        }
        return front.data;
    }

    // Phương thức isEmpty: Kiểm tra xem queue có trống hay không
    public boolean isEmpty() {
        return front == null;
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Peek: " + queue.peek()); // Hiển thị phần tử đầu: 1

        queue.dequeue(); // Loại bỏ phần tử đầu: 1
        queue.enqueue(4);
        queue.printQueue();
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }

    }
}
