

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class DoubleLinkedList {

    Node head;
    Node tail;
    int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addAllStudent(Student s){
        Node newNode = new Node(s);
        if(this.size == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }
    public boolean adds() {
        Node curr = this.head;
        int i=0;
        while(i<this.size){
            if(curr.data.getAvg() >= 5){
                
            }
        }

        return false;
    }

    public Student highestAVG() {
        Student s = null;
        double temp = this.head.data.getAvg();
        Node curr = this.head;
        while(curr != null){
            if(curr.data.getAvg() > temp){
                temp = curr.data.getAvg();
                s = curr.data;
            }
            curr = curr.next;
        }
        return s;
    }

    public boolean removes(){
        Node curr = this.head;
        Node prevNode = this.head;
        while(curr != null){
            if(curr.data.getFe()<4 && curr.data.getAvg()<5){
                // xoa
                prevNode.next = curr.next;
                curr.next.prev = prevNode;
                this.size--;
            }
            prevNode = curr;
            curr = curr.next;
        }
        return false;
    }
    public void lisOfStudent(){
        Node curr = this.head;
        
        while(curr != null){
            
        }
    }
    
    public void traverse(){
        Node curr = this.head;
        while(curr != null){
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }
    
    public static void main(String[] args) {
        DoubleLinkedList link  = new DoubleLinkedList();
        Student s1 = new Student("HE1", "Hanh", 4, 5);
        Student s2 = new Student("HE2", "Thuy", 5, 8);
        Student s3 = new Student("HE3", "Chung", 7, 4);
        Student s4 = new Student("HE4", "Duc", 8, 7);
        Student s5 = new Student("HE5", "Hung", 3, 6);
        Student s6 = new Student("HE6", "Thang", 6, 9);
        Student s7 = new Student("HE7", "Thuong", 6, 5);
        Student s8 = new Student("HE8", "An", 5, 7);
        link.traverse();
        link.addAllStudent(s1);
        link.addAllStudent(s2);
        link.addAllStudent(s3);
        link.addAllStudent(s4);
        link.addAllStudent(s5);
        link.addAllStudent(s6);        
        link.addAllStudent(s8);
        link.addAllStudent(s7);
        link.traverse();
        System.out.println("-----------");
        link.removes();
        link.traverse();
    }
}
