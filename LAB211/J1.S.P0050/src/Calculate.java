
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class Calculate {

    private final Validate val = new Validate();
    private List<Double> num = new ArrayList<>();
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public int menu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        return val.choice();
    }

    private List<Double> superlative(double a, double b) {
        if (a == 0 && b == 0) {
            return new ArrayList<>();
        } else if (a != 0) {
            double x = -b / a;
            List<Double> result = new ArrayList<>();
            result.add(x);
            return result;
        }
        return null;
    }

    private List<Double> Quadratic(double a, double b, double c) {
        List<Double> result = new ArrayList<>();
        if (a == 0) {
            return superlative(b, c);
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                return null;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result.add(x);
                result.add(x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);

                result.add(x1);
                result.add(x2);
            }
        }
        return result;
    }

    public void calculateEquation() {
        double a = val.inNum("Enter A: ");
        double b = val.inNum("Enter B: ");
        num = this.superlative(a, b);
        if (num == null) {
            System.out.println("Equation have no solution");
            return;
        } else if (num.isEmpty()) {
            System.out.println("Equation have many solution");
        } else {
            String decimalNumber = decimalFormat.format(num.get(0));
            System.out.println("Solution: "+decimalNumber);
        }
        num.add(a);
        num.add(b);
        this.display();
        num.clear();
    }

    public void calcQuadratic() {

        double a = val.inNum("Enter A: ");
        double b = val.inNum("Enter B: ");
        double c = val.inNum("Enter C: ");

        num = this.Quadratic(a, b, c);
        if (num == null) {
            System.out.println("Equation have no solution");
            return;
        } else if (num.isEmpty()) {
            System.out.println("Equation have many solution");
        } else {
            String num1 = decimalFormat.format(num.get(0));
            String num2 = decimalFormat.format(num.get(num.size() - 1));
            System.out.println("Solution: "+num1 +" and "+num2);
        }
        num.add(a);
        num.add(b);
        num.add(c);
        this.display();
        num.clear();

    }

    public void display() {
        System.out.print("Number is Odd: ");
        for (Double double1 : num) {
            if (val.checkOddNumber(double1)) {
                String number = decimalFormat.format(double1);
                System.out.println(number);
            }
        }
        System.out.println();
        System.out.print("Number is Even: ");
        for (Double double1 : num) {
            if (val.checkEvenNumber(double1)) {
                String number = decimalFormat.format(double1);
                System.out.println(number);
            }
        }
        System.out.println();
        System.out.print("Number is Perfect Square: ");
        for (Double double1 : num) {
            if (val.checkPerfectSquare(double1)) {
                String number = decimalFormat.format(double1);
                System.out.println(number);
            }
        }
        System.out.println();
    }
}
