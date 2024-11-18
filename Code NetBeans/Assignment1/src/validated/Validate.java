/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validated;

import java.util.Scanner;

/**
 *
 * @author Hanh
 */
public class Validate {

    private final Scanner sc = new Scanner(System.in);

    public String inString(String s) {
        String a;
        while (true) {
            try {
                System.out.print(s);
                a = sc.nextLine();
                return a;
            } catch (Exception e) {
            }
        }
    }

    public double inDouble(String s) {
        double a;
        while (true) {
            try {
                System.out.print(s);
                a = Double.parseDouble(sc.nextLine());
                if (a > 0) {
                    return a;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Enter number");
            }
        }
    }

    public int inInt(String s) {
        int a;
        while (true) {
            try {
                System.out.print(s);
                a = Integer.parseInt(sc.nextLine());
                if (a > 0) {
                    return a;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Enter number");
            }
        }
    }

    public String inPhone() {
        String a;
        while (true) {
            try {
                System.out.print("Enter phonenumber: ");
                a = sc.nextLine();
                if (a.matches("^0\\d{9}$")) {
                    return a;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Enter number");
            }
        }
    }

}
