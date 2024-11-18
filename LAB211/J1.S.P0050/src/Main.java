/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Main {

    public static void main(String[] args) {
        Calculate calc = new Calculate();
        int choice;
        while (true) {
            choice = calc.menu();
            switch (choice) {
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    calc.calculateEquation();
                    break;
                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    calc.calcQuadratic();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
