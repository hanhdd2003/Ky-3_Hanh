/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackarray;

/**
 *
 * @author Hanh
 */
public class LinkedListStack {
    Node top;
    int size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }
    
    public void push(Student s){
        Node stNode = new Node(s);
        if(this.size == 0) {
           this.top = stNode;
           this.size++;
        }else{
           stNode.next = this.top;
           this.top = stNode;
           this.size++;
        } 
    }
    
    public Student peak(){
        return this.top.student;
    }
    
    public Student pop(){
        Student s = this.top.student;
        this.top = this.top.next;
        if(this.size > 0){
            this.size--;
        }
        return s;
    }
    
    public void traverse(){
        Student s;
        if(this.size == 0 ){
            return;
        }
        Node current = this.top;
        while(current != null){
            System.out.println(current.student.toString() ); 
            current = current.next;
        }
        
        
    }
    public static void main(String[] args) {
        LinkedListStack myStack = new LinkedListStack();
        Student thuy = new Student("HE122345", "Ngọc Thủy");
        Student hanh = new Student("HE17029", "Đức Hanh");
        Student chung = new Student("HE2314234", "Đinh Việt Chung");
        //System.out.println(thuy.toString());
        myStack.push(thuy);
        myStack.push(hanh);
        myStack.push(chung);
        myStack.traverse();
    }
    
}
