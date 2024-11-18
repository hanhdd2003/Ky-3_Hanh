
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
        int s;
        while (true) {
            try {
                System.out.print("Please choice one option: ");
                s = Integer.parseInt(sc.nextLine());
                if (0 < s && s <= 4) {
                    return s;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input from 1 to 4");
            }
        }
    }

    public int lengthOfArray() {
        int s;
        while (true) {
            try {
                System.out.println("Input Length Of Array");
                System.out.print("Enter number: ");
                s = Integer.parseInt(sc.nextLine());
                if (s > 0) {
                    return s;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number and is greater than zero");
            }
        }
    }

    public int inValue(String a) {
        int s;
        while (true) {
            try {
                System.out.print(a);
                s = Integer.parseInt(sc.nextLine());
                return s;
            } catch (NumberFormatException e) {
            }
        }
    }
}
