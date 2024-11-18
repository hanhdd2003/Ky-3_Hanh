/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatebmi;

import java.util.*;
import java.util.logging.Logger;

public class CalculateBMI {

    private static final Logger logger = Logger.getLogger(CalculateBMI.class.getName());
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int Choice;
        do {
            //Step1: Display Menu
            menu();
            //Step2: Selection option from choice of user
            Choice = getChoice("Please choice one option: ");
            //Step3: Display option from choice of user
            switch (Choice) {
                case 1:
                    logger.info("----- Normal Calculator -----");
                    normalCalculator();
                    break;
                case 2:
                    logger.info("----- BMI Calculator -----");
                    bmiStatus();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (Choice <= 3);
    }

    private static void menu() {
        logger.info("========== Calculator Program ==========");
        logger.info("1. Normal Calculator");
        logger.info("2. BMI Calculator");
        logger.info("3. Exit");
    }

    private static int getChoice(String msg) {
        boolean checkValid = false;
        double choice = 0;
        String input;
        while (!checkValid) {
            logger.info(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                logger.info("The input not exit");
                continue;
            }
            try {
                choice = Double.parseDouble(input);
                if (choice > 0 && choice < 4) {
                    if (choice == (int) choice) {
                        checkValid = true;
                    } else {
                        checkValid = false;
                        logger.info("The input must integer");
                    }
                } else {
                    checkValid = false;
                    logger.info("The input must in from 1 to 3");
                }
            } catch (NumberFormatException ex) {
                logger.info("The input must number");
            }
        }
        return (int) choice;
    }

    private static double inputNumber() {
        String inputS;
        int input;
        while (true) {
            inputS = sc.nextLine();
            try {
                input = Integer.parseInt(inputS);
                return input;
            } catch (NumberFormatException e) {
                logger.info("Try input again");
            }
        }

    }

    private static String checkInputOperator() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                logger.info("Input should not be empty");
            } else {
                switch (input.toLowerCase()) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "^":
                    case "=":
                        return input;
                    default:
                        logger.info("Please input one of the following operators: +, -, *, /, ^, =");
                        break;
                }
            }
        }
    }

    private static void normalCalculator() {
        double memory;
        String operator;
        double temp;
        logger.info("Enter Number: ");
        memory = inputNumber();
        do {
            logger.info("Enter operator: ");
            operator = checkInputOperator();
            if (!operator.equalsIgnoreCase("=")) {
                logger.info("Enter Number: ");
            }

            switch (operator) {
                case "+":
                    memory += inputNumber();
                    break;
                case "-":
                    memory -= inputNumber();
                    break;
                case "*":
                    memory *= inputNumber();
                    break;
                case "/":
                    temp = inputNumber();
                    if (temp == 0) {
                        logger.info("can not divide 0");
                    } else {
                        memory /= temp;
                    }
                    break;
                case "^":
                    memory = Math.pow(memory, inputNumber());
                    break;
                case "=":
                    String mess = "Result: " + memory;
                    logger.info(mess);
                    break;
                default:
                    break;
            }
            if (!operator.equalsIgnoreCase("=")) {
                String mess = "Result: " + memory;
                logger.info(mess);
            }

        } while (!operator.equalsIgnoreCase("="));

    }

    private static double bmiCalculator() {
        logger.info("Enter Weight(kg): ");
        double Weight = inputNumber();
        logger.info("Enter Height(cm): ");
        double Height = inputNumber();
        double NumberBMI = Weight / (Height * Height) * 10000;
        logger.info(() -> "BMI Number: " + NumberBMI);
        logger.info("");
        return NumberBMI;
    }

    private static void bmiStatus() {
        double numberBMI = bmiCalculator();
        if (numberBMI < 19) {
            logger.info("BMI Status: UNDER-STANDARD");
        } else if (numberBMI > 40) {
            logger.info("BMI Status: VERY FAT-SHOULD LOSE WEIGHT");
        } else {
            if (numberBMI < 25) {
                logger.info("BMI Status: STANDARD");
            } else if (numberBMI > 30) {
                logger.info("BMI Status: FAT - SHOULD LOSE WEIGHT");
            } else {
                logger.info("BMI Status: OVERWEIGHT");
            }
        }
    }
}
