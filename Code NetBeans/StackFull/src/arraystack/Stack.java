/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraystack;

/**
 *
 * @author Hanh
 */
public class Stack {
    private int maxSize; // Kích thước tối đa của stack
    private int top;     // Vị trí của phần tử ở đỉnh của stack
    private int[] stackArray; // Mảng lưu trữ các phần tử

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Khởi tạo top là -1 để biểu thị stack rỗng
    }

    // Phương thức push: Đẩy phần tử vào đỉnh của stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
    }

    // Phương thức pop: Lấy ra và loại bỏ phần tử ở đỉnh của stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Giá trị không hợp lệ
        }
//        int value = stackArray[top];
//        stackArray[top--] = null;
//        return value;
        return stackArray[top--];
    }

    // Phương thức peek: Xem phần tử ở đỉnh của stack mà không loại bỏ nó
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Giá trị không hợp lệ
        }
        return stackArray[top];
    }

    // Phương thức isEmpty: Kiểm tra xem stack có trống hay không
    public boolean isEmpty() {
        return (top == -1);
    }

    // Phương thức isFull: Kiểm tra xem stack đã đầy hay chưa
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

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
