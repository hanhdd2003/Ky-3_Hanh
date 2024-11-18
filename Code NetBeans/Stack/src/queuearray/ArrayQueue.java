
import stackarray.Student;

public class ArrayQueue {

    private Student[] student;
    private int size;
    private int cap;
    private int front;
    private int back;

    public ArrayQueue(int cap) {
        this.cap = cap;
        this.front = -1;
        this.back = -1;
        this.student = new Student[this.cap];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enQueue(Student s) {
        if (this.size == this.cap) {
            System.out.println("Queue is full. Cannot add student.");
            return;
        }
        this.back = (this.back + 1) % this.cap;
        student[back] = s;
        this.size++;
    }

    public Student deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null; // Hoặc bạn có thể ném một ngoại lệ EmptyQueueException
        } else {
            front = (front + 1) % cap;
            Student s = student[front];
            student[front] = null;
            this.size--;
            return s;
        }
    }

    public void traverse() {
        for (int i = 0; i < this.size; i++) {
            Student s = student[(front + 1 + i) % this.cap];
            if (s != null) {
                System.out.println(s);
            }
        }
    }
}
