/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workermanager;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Validation {
    private final static Scanner sc = new Scanner(System.in);

    public Validation() {
    }
    
    public static int inputInt(int min, int max){
        int output;
        while(true){
            try {
                output = Integer.parseInt(sc.nextLine());
                if(output>max || output <min){
                    System.out.println("Enter number have to graeter than "+min+" and less than "+max); 
                }else{
                    return output;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter one number");
            }
        }
    }
    
     public static double inputDouble(double min, double max){
        double output;
        while(true){
            try {
                output = Integer.parseInt(sc.nextLine());
                if(output>max || output <min){
                    System.out.println("Enter number again"); 
                }else{
                    return output;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter one number");
            }
        }
    }
    
    public static String inputID(){
        String output;
        while(true){
            try {
                output = sc.nextLine();
                if(output.matches("^[A-Za-z1-9]+$")){
                    return output;
                }else{
                    System.out.println("Try input again");
                }
            } catch (Exception e) {
            }
        }
    }
    
    public static String inputString(){
        String output;
        while(true){
            try {
                output = sc.nextLine();
                if(output.matches("^[A-Za-z\\s]+$")){
                    return output;
                }else{
                    System.out.println("Try input again");
                }
            } catch (Exception e) {
            }
        }
    }
}
