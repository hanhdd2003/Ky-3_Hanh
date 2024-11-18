/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedliststack;

/**
 *
 * @author Hanh
 */
public class LinkedListStack {

    private Node top;

    public LinkedListStack() {
        this.top = null;
    }

    // Phương thức push: Đẩy phần tử vào đỉnh của stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Phương thức pop: Lấy ra và loại bỏ phần tử ở đỉnh của stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Giá trị không hợp lệ
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Phương thức peek: Xem phần tử ở đỉnh của stack mà không loại bỏ nó
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Giá trị không hợp lệ
        }
        return top.data;
    }

    // Phương thức isEmpty: Kiểm tra xem stack có trống hay không
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek: " + stack.peek()); // Hiển thị phần tử ở đỉnh: 3

        stack.pop(); // Lấy ra phần tử ở đỉnh: 3
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }
    }
}
