
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class Validate {

    private Scanner sc = new Scanner(System.in);

    public String inID() {
        String s;
        while (true) {
            try {
                System.out.print("Enter id: ");
                s = sc.nextLine();
                if (s.matches("^[a-zA-Z0-9]+$")) {
                    return s.toUpperCase();
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("ID is not correct format");
            }
        }
    }

    public String inName() {
        String s;
        while (true) {
            try {
                System.out.print("Enter name: ");
                s = sc.nextLine();
                if (s.matches("^[a-zA-Z\\s+]+$")) {
                    return s;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Name is not correct format");
            }
        }
    }

    public int inAge() {
        int s;
        while (true) {
            try {
                System.out.print("Enter age: ");
                s = Integer.parseInt(sc.nextLine());
                if (18 <= s && s <= 50) {
                    return s;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Age is not correct format");
            }
        }
    }

    public double inSalary() {
        double s;
        while (true) {
            try {
                System.out.print("Enter Salary: ");
                s = Double.parseDouble(sc.nextLine());
                if (s > 0) {
                    return s;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Salary is not correct format");
            }
        }
    }

    public String inWorkLocation() {
        String s;
        while (true) {
            try {
                System.out.print("Enter Work Location: ");
                s = sc.nextLine();
                if (s.matches("^[a-zA-Z0-9\\s+]+$")) { 
                    return s;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Work location is not correct format");
            }
        }
    }
    
    public int choice(int min, int max){
        int s;
        while (true) {            
            try {
                System.out.print("Enter your choice: ");
                s = Integer.parseInt(sc.nextLine());
                if(s>= min && s <= max){
                    return s;
                }else{
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter choice from "+min + " to "+max);
            }
        }
    }
}
