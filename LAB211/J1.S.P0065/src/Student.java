/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Student {
    private String studentName;
    private String className;
    private double maths;
    private double physical;
    private double chemistry;

    public Student() {
    }
    
    

    public Student(String studentName, String className, double maths, double physical, double chemistry) {
        this.studentName = studentName;
        this.className = className;
        this.maths = maths;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public char getType() {
        if(this.getAvg() > 7.5){
            return 'A';
        }else if(this.getAvg() >= 6 && this.getAvg() <= 7.5){
            return 'B';
        }else if (this.getAvg() >= 4 && this.getAvg() <6){
            return 'C';
        }else{
            return 'D';
        }
    }

    

    public double getAvg() {
        return (maths + physical + chemistry)/3;
    }

    public void display(){
            System.out.println("Name: " + this.getStudentName());
            System.out.println("Classes: " + this.getClassName());
            System.out.printf("AVG: %.2f\n" ,this.getAvg());
            System.out.println("Type: " + this.getType());
    }
}
