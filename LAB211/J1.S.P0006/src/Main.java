
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Random rand = new Random();
    public static int inNumArr() {
        int a;
        while (true) {
            try {
                logger.info("Enter number of array: ");
                a = Integer.parseInt(sc.nextLine().trim());
                if (a >= 0) {
                    return a;
                }
           } catch (NumberFormatException e) {
               String error = e+"";
                logger.log(Level.WARNING, error);
            }
        }
    }
    
    public static int inValue() {
        int a;
        while (true) {
            try {
                logger.info("Enter search value: ");
                a = Integer.parseInt(sc.nextLine().trim());
                if (a >= 0) {
                    return a;
                }
            } catch (NumberFormatException e) {
                String error = e+"";
                logger.log(Level.WARNING, error);
            }
        }
    }
    
    public static int[] createArr(int[] a) {
        
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(a.length);
        }
        return a;
    }
    
    public static void display(int a[], String text) {
        logger.info(()->text + " ");
        logger.info("[");
        String number;
        for (int i = 0; i < a.length; i++) {
            number=a[i]+"";
            logger.info(number);
            if (i < a.length - 1) {
                logger.info(", ");
            }
        }
        logger.info("]");
        logger.info("\n");
    }
    
    public static int[] sortByBubble(int[] a) {
        int temp;
        boolean swapped;
        for (int i = 0; i < a.length; i++) {
            swapped = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return a;
    }
    
    public static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int size;
        int value;
        int arr[];
        int result;
        //enter number of array
        size = inNumArr();
        //enter search value
        value = inValue();
        //create array
        arr = new int[size];
        createArr(arr);
        //sort array
        sortByBubble(arr);
        //display array
        display(arr, "sorted array: ");
        //search
        result = binarySearch(arr, value);
        if (result == -1) {
            System.out.println("Can't not found " + value);
        } else {
            System.out.println("Found " + value + " at index: " + result);
            
        }

        /*        int[] a = {20, 17, 15, 14, 10, 8, 7, 4, 2, 0};
        display(a, "a: ");
        result = binarySearch(a, 4);
        if (result == -1) {
            System.out.println("Can't not found " + 4);
        } else {
            System.out.println("Found " + 4 + " at index: " + result);

        }*/
    }
}
