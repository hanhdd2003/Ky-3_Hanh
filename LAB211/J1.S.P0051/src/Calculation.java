/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Calculation {

    private final Validate val = new Validate();

    public int menu() {
        System.out.println("======== Calculator Program ========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        return val.choice();
    }

    public void normalCalculator() {
        double memory;
        char c;
        double temp;
        System.out.println("------- Normal Calculator -------");
        memory = val.inValue();
        do {
            c = val.inOperator();
            if (c == '=') {
                break;
            }
            temp = val.inValue();
            switch (c) {
                case '+':
                    memory += temp;
                    break;
                case '-':
                    memory -= temp;
                    break;
                case '*':
                    memory *= temp;
                    break;
                case '/':
                    if (temp != 0) {
                        memory /= temp;
                    } else {
                        System.out.println("Can't divide 0");
                        continue;
                    }
                    break;
                case '^':
                    memory = Math.pow(memory, temp);
                    break;
            }
            System.out.println("Memory: " + memory);
        } while (c != '=');
        System.out.println("Result: " + memory);
        System.out.println();
    }

    public void bmiCalculator() {
        double weight = val.inBMI("Enter Weight(kg): ");
        double height = val.inBMI("Enter Height(cm): ") / 100;
        double bmi = weight / (height * height);
        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + this.bmiStatus(bmi).toUpperCase());
        System.out.println();
    }

    public String bmiStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi <= 25) {
            return "Standard";
        } else if (bmi <= 30) {
            return "Overweight";
        } else if ( bmi <= 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    public static void main(String[] args) {
        Calculation cal = new Calculation();
        cal.bmiCalculator();
    }
}
