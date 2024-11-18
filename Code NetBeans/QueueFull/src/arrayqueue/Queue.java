/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue;

/**
 *
 * @author Hanh
 */
public class Queue {
    private int capacity; // Kích thước tối đa của queue
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = capacity-1;
        this.size = 0;
    }

    // Phương thức Enqueue: Thêm một phần tử vào rear của queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    // Phương thức Dequeue: Loại bỏ phần tử từ front của queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Giá trị không hợp lệ
        }
        int removedItem = arr[front];
        front = (front + 1) % capacity;
        size--;
        return removedItem;
    }

    // Phương thức Peek: Xem phần tử ở front của queue mà không loại bỏ nó
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Giá trị không hợp lệ
        }
        return arr[front];
    }

    // Phương thức isEmpty: Kiểm tra xem queue có trống hay không
    public boolean isEmpty() {
        return size == 0;
    }

    // Phương thức isFull: Kiểm tra xem queue có đầy hay không
    public boolean isFull() {
        return this.size == this.capacity;
    }
public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int current = this.front;
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.arr[current] + " ");
            current = (current + 1) % this.capacity;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue queue = new Queue(100);

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
