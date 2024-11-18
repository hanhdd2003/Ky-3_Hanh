package Validate;

import java.util.Scanner;

public class Validate {

    private final Scanner inputScanner = new Scanner(System.in);

    public String inputString(String prompt) {
        String userInput;
        while (true) {
            try {
                System.out.print(prompt);
                userInput = inputScanner.nextLine();
                return userInput;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public double inputDouble(String prompt) {
        double userInput;
        while (true) {
            try {
                System.out.print(prompt);
                userInput = Double.parseDouble(inputScanner.nextLine());
                if (userInput > 0) {
                    return userInput;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive number");
            }
        }
    }

    public int inputInt(String prompt) {
        int userInput;
        while (true) {
            try {
                System.out.print(prompt);
                userInput = Integer.parseInt(inputScanner.nextLine());
                if (userInput > 0) {
                    return userInput;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive number");
            }
        }
    }

    public String inputPhone() {
        String phoneNumber;
        while (true) {
            try {
                System.out.print("Enter phone number: ");
                phoneNumber = inputScanner.nextLine();
                if (phoneNumber.matches("^0\\d{9}$")) {
                    return phoneNumber;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone number format. Please enter a valid phone number.");
            }
        }
    }
}
