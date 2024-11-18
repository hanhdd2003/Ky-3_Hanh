
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

    public int choice() {
        int i;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                i = Integer.parseInt(sc.nextLine());
                if (i >= 1 && i <= 3) {
                    return i;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Must enter number from 1 tto 3");
            }
        }
    }

    

    public double inNum(String s) {
        double a;
        while (true) {
            try {
                System.out.print(s);
                a = Double.parseDouble(sc.nextLine());
                return a;
            } catch (NumberFormatException e) {
                System.out.println("Must enter number");
            }
        }
    }
    public boolean checkOddNumber(double num){
        return num%2 != 0;
    }
    public boolean checkEvenNumber(double num){
        return num%2==0;
    }
    public boolean checkPerfectSquare(double num){
        double square = Math.sqrt(num);
        return square*square == num;
    }
    
}
