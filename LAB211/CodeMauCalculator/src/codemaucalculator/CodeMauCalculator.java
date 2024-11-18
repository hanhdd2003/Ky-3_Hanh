package codemaucalculator;

import java.util.Scanner;

public class CodeMauCalculator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        calculator();
    }

    static int menu() {
        int choice;
        System.out.println("Menu: ");
        System.out.println("1. Nomal calculation");
        System.out.println("2. BMI calculation");
        System.out.println("3. exit");
        System.out.print("please choice an option(1-3): ");
        choice = inputChoice(0, 4);
        return choice;
    }

    static void calculator() {
        do {
            switch (menu()) {
                case 1:
                    calNomal();
                    break;
                case 2:
                    calBMI();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }

        } while (menu() != 3);
    }

    static int inputChoice(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice > min && choice < max) {
                    return choice;
                }
                System.out.println("Input again");
            } catch (NumberFormatException e) {
                System.out.println("Input one number in rage " + min + " to " + max);
            }
        }
    }

    static double inputDouble() {
        double input;
        while (true) {
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Input again");
            }
        }
    }

    static String inputOprator() {
        String op;
        while (true) {
            try {
                op = sc.nextLine().trim();
                if (op.equalsIgnoreCase("+") || op.equalsIgnoreCase("-") || op.equalsIgnoreCase("^")
                        || op.equalsIgnoreCase("*") || op.equalsIgnoreCase("/") || op.equalsIgnoreCase("=")) {
                    return op;
                }
                System.out.print("Input again: ");
            } catch (Exception e) {
                System.out.print("Input again: ");
            }
        }
    }

    static void calNomal() {
        double memmory;
        String op;
        System.out.print("Enter Number: ");
        memmory = inputDouble();
        do {
            
                System.out.print("Enter oparetor: ");
            op = inputOprator();
            if (op.equalsIgnoreCase("+")) {
                System.out.print("Enter Number: ");
                memmory += inputDouble();
            }
            if (op.equalsIgnoreCase("-")) {
                System.out.print("Enter Number: ");
                memmory -= inputDouble();
            }
            if (op.equalsIgnoreCase("*")) {
                System.out.print("Enter Number: ");
                memmory *= inputDouble();
            }
            if (op.equalsIgnoreCase("/")) {
                System.out.print("Enter Number: ");
                double a = inputDouble();
                if(a == 0){
                    System.out.println("Can device 0");
                }
                memmory /= a;
            }
            if (op.equalsIgnoreCase("^")) {
                System.out.print("Enter Number: ");
                memmory = Math.pow(memmory, inputDouble());
            }
            

        } while (!op.equalsIgnoreCase("="));
        System.out.println("Resul: " + memmory);
    }

    static void calBMI() {
        System.out.print("Enter Weight(kg): ");
        double weight = inputDouble();
        System.out.print("Enter Height(cm): ");
        double height = inputDouble();
        height = height / 100;
        System.out.printf("BMI number: %.2f\n", (weight / (height * height)));
        System.out.println(BMIstatus(weight / (height * height)));
    }

    static String BMIstatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }

    }
}
