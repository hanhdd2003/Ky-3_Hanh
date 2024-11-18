
import java.util.Arrays;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class BubbleArray {

    private final Validate val = new Validate();


    public int menu() {
        System.out.println("======== Bubble Sort program ========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
        return val.choice();
    }

    public int[] createArray() {
        int size = val.lengthOfArray();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = val.inValue("Enter Number " + (i + 1) + ": ");
        }
        return Arrays.copyOf(array, size);
    }

    public void display(int[] a, String s) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]");
            if (count < a.length - 1) {
                System.out.print(s);
            }
            count++;
        }
        System.out.println();
    }

    public int[] ascending(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] descending(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
