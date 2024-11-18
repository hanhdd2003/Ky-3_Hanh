package newconvert;

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
public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int choice() {
        int i;
        String s;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                s = sc.nextLine().trim();
                if (!s.isEmpty() && s.matches("[1-4]+")) {
                    return Integer.parseInt(s);
                } else {
                    continue;
                }
            } catch (Exception e) {
            }
        }
    }

    public int isDecimal() {
        String s;
        while (true) {
            try {
                System.out.print("Enter Decimal: ");
                s = sc.nextLine().trim();
                if (!s.isEmpty() && s.matches("-?[0-9]*")) {
                    return Integer.parseInt(s);
                } else {
                    continue;
                }
            } catch (Exception e) {
            }
        }
    }

    public String isBinary() {
        String s;
        while (true) {
            try {
                System.out.print("Enter Binary: ");
                s = sc.nextLine().trim();
                if (this.isValidBin(s) && !s.isEmpty()) {
                    return s;
                } else {
                    continue;
                }
            } catch (Exception e) {
            }
        }
    }

    public String isHexadecimal() {
        String s;
        while (true) {
            try {
                System.out.print("Enter HexaDecimal: ");
                s = sc.nextLine().trim();
                if (s.matches("[0-9A-Fa-f]+") && !s.isEmpty()) {
                    return s;
                } else {
                    continue;
                }
            } catch (Exception e) {
            }
        }
    }

    public Boolean isValidBin(String s) {
        for (char c : s.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Validation val = new Validation();
        System.out.println(val.choice());
    }
}
