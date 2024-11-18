package controller;
import java.util.Random;
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
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputNumOfArr() {
        int a;
        while (true) {
            try {
                System.out.println("Enter number of array: ");
                a = Integer.parseInt(sc.nextLine().trim());
                if (a >= 0) {
                    return a;
                }
            } catch (NumberFormatException e) {
                System.err.println("Enter number of array again: ");
            }
        }
    }

    public static int inputValueSearch() {
        int a;
        while (true) {
            try {
                System.out.println("Enter search value: ");
                a = Integer.parseInt(sc.nextLine().trim());
                if (a >= 0) {
                    return a;
                }
            } catch (NumberFormatException e) {
                System.err.println("Enter search value again: ");
            }
        }
    }

    public static int[] createArr(int size) {
        int[] a = new int[size];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(a.length) + 1;
        }
        return a;
    }

    public static void displayArr(int[] a) {
        System.out.print("The array: [");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static int searchNum(int num, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int sizeOfArr;
        int value;
        int[] arr;
        // enter number of array
        sizeOfArr = inputNumOfArr();
        // enter search value
        value = inputValueSearch();
        //create array
        arr = createArr(sizeOfArr);
        //display array
        displayArr(arr);
        //searh
        int result = searchNum(value, arr);
        if(result == -1){
            System.out.println("Not found " + value);
        }else{
            System.out.println("Found " + value +" at index: " +  result);
        }
    }
}
