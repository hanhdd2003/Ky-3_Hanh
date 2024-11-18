
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

    

    public String iString() {
        String s;
        while (true) {
            try {
                System.out.print("Classes: ");
                s = sc.nextLine().trim();
                if (s.matches("[a-z A-Z 0-9]+")) {
                    return s;
                }
            } catch (Exception e) {
                System.out.println("Classes is a string");
            }
        }
    }

    public String iName() {
        String s;
        while (true) {
            try {
                System.out.print("Name: ");
                s = sc.nextLine().trim();
                if (s.matches("[a-z A-Z]+")) {
                    return s;
                }
            } catch (Exception e) {
                System.out.print("Name is a string: ");
            }
        }
    }

    public double iPoint(String subject) {
        double mark;
        while (true) {
            try {
                System.out.print(subject);
                mark = Double.parseDouble(sc.nextLine());
                if (0 <= mark && mark <= 10) {
                    return mark;
                } else if (mark < 0) {
                    System.out.println(subject + " is greater than zero");
                } else if (mark > 10) {
                    System.out.println(subject + " is less than ten");
                }
            } catch (NumberFormatException e) {
                System.out.println(subject + " is digit");
            }
        }
    }

    public boolean iYN() {
        char c;
        while (true) {
            try {
                System.out.print("Do you want to enter more student information?(Y/N): ");
                c = sc.next().charAt(0);
                sc.nextLine();
                if (c == 'y' || c == 'Y') {
                    return true;
                } else if (c == 'n' || c == 'N') {
                    return false;
                }
            } catch (Exception e) {
            }
        }
    }
}
