
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
    private final Scanner sc = new Scanner(System.in);

    public Validate() {
    }
    
    public char inOperator(){
        char c;
        while (true) {            
            try {
                System.out.print("Enter Operator: ");
                c = sc.nextLine().charAt(0);
                if(this.charValid(c)){
                    return c;
                }else{
                    throw new StringIndexOutOfBoundsException();
                }
                
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Please input (+, -, *, /, ^, =)");
            }
        }
    }
    public boolean charValid(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || '=' == c;
    }
    
    public int choice(){
        int c;
        while (true) {            
            try {
                System.out.print("Please choice one option: ");
                c = Integer.parseInt(sc.nextLine());
                if(0>=c && c>3){
                    throw new NumberFormatException();
                }
                return c;
            } catch (NumberFormatException e) {
                System.out.println("Choice from 1 to 3");
            }
        }
    }
    public double inValue(){
        double c;
        while (true) {            
            try {
                System.out.print("Enter number: ");
                c = Double.parseDouble(sc.nextLine());
                return c;
            } catch (NumberFormatException e) {
                System.out.println("Enter digit");
            }
        }
    }
    public double inBMI(String s){
        double c;
        while (true) {            
            try {
                System.out.print(s);
                c = Double.parseDouble(sc.nextLine());
                if(c<0){
                    throw new NumberFormatException();
                }
                return c;
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }
        }
    }
}
