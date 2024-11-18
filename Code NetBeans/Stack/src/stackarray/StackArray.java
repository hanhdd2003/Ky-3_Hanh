package stackarray;

public class StackArray {

    private int capacity;
    private Student[] students;
    private int size;
    private int top;

    public StackArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.top = -1;
        this.students = new Student[capacity];
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public void push(Student s) {
        if (this.size >= this.capacity) {
            System.out.println("Hết chỗ thêm rồi");
            return;
        }
        this.students[this.top + 1] = s;
        this.top++;
        this.size++;

    }

    public Student pop() {
        if (this.size == 0) {
            return null;
        } else {
            Student s = this.students[top];
            this.students[top] = null;
            this.size--;
            this.top--;
            return s;
        }
    }

    public Student peak() {
        if (this.size == 0) {
            return null;
        } else {
            return this.students[top];
        }
    }

    public void clear() {
        if (this.size == 0) {
            System.out.println("Danh sách rỗng");
            return;
        } else {
            this.students = null;
            return;
        }
    }

    public void traverse() {
        Student s;
        for (int i = 0; i < size; i++) {
            s = students[i];
            System.out.println(s + " ");
            top -= i;
        }
    }

    public static void main(String[] args) {
        StackArray myStack = new StackArray(10);
        Student thuy = new Student("HE122345", "Ngọc Thủy");
        Student hanh = new Student("HE17029", "Đức Hanh");
        //System.out.println(thuy.toString());
        myStack.push(thuy);
        myStack.push(hanh);
        myStack.traverse();
    }
}
