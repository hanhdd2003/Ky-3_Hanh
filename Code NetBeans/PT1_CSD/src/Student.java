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
    private String studentID;
    private String name;
    private double pe;
    private double fe;
    private double avg;

    public Student(String studentID, String name, double pe, double fe) {
        this.studentID = studentID;
        this.name = name;
        this.pe = pe;
        this.fe = fe;
        this.avg = (fe+pe)/2;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "[" + studentID + ", " + name + ", " + pe + ", " + fe + ", " + avg + "]";
    }
    
    
}
