/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkChoice(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min && n > max) {
                    System.out.println("Enter integer in: [" + min + ", " + max + "]");
                    continue;
                }
                return n;
            } catch (Exception e) {
                System.out.println("Enter choice: ");
            }
        }
    }

    public int checkInt(String msg) {
        while (true) {
            try {
                System.out.println(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < 0) {
                    System.out.println("Enter greater than 0!");
                    continue;
                }
                return n;
            } catch (Exception e) {
                System.out.println("Enter integer: ");
            }
        }
    }

    public double checkdouble(String msg) {
        while (true) {
            try {
                System.out.println(msg);
                double n = Double.parseDouble(sc.nextLine());
                if (n < 0) {
                    System.out.println("Enter greater than 0!");
                    continue;
                }
                return n;
            } catch (Exception e) {
                System.out.println("Enter double: ");
            }
        }
    }

    public String checkString(String msg) {
        while (true) {
            System.out.println(msg);
            String s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println("Not empty");
                continue;
            }
            return s;
        }
    }
    public String checkInputCourse(String mess) {
        while (true) {
           String result = sc.nextLine();
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

}
