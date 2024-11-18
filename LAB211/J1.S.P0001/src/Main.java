
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

    public static int inputPosNumber() {
        // loop until input correct
        while (true) {
            try {
                int i = Integer.parseInt(sc.nextLine().trim());
                if (i >= 0) {
                    return i;
                } else {
                    System.err.println("Please input positive number");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }

        }
    }

    public static int[] createArray(int a) {
        int[] array = new int[a];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(a);//random đi từ 0 den a-1
        }

        return array;
    }

    public static void displayArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static int[] bubbleSort(int[] arr) {
        boolean swapped;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        //1. input positive number
        System.out.println("Enter number of array: ");
        int posNum = inputPosNumber();
        //2. create array
        int[] arr = createArray(posNum);
        //3. display array unsorted
        displayArr(arr);
        //4. display array sorted
        int[] sortedArr = bubbleSort(arr);
        displayArr(sortedArr);
    }

}
