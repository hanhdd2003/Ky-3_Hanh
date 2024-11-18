
import java.util.Arrays;
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
    private static Scanner sc = new Scanner(System.in);
    
    public static int iPosNum(){
        int i;
        String s;
        while(true){
            try {
                System.out.println("Enter number of array: ");
                s = sc.nextLine().trim();
                if(!s.isEmpty()){
                    i = Integer.parseInt(s);
                    if(i>=0){
                        return i;
                    }else{
                        continue;
                    }
                }else{
                    continue;
                }
            } catch (Exception e) {
            }
        }
    }
    
    public static int[] createArr(int size){
        int[] a = new int[size];
        Random rand = new Random();
        for(int i=0 ; i < a.length ; i++){
            a[i] = rand.nextInt(size);
        }
        return Arrays.copyOf(a, size);
    }
    
    public static void display(int[] a, String s){
        int count = 0;
        System.out.print(s);
        System.out.print("[");
        for(int i=0 ; i<a.length ; i++){
            System.out.print(a[i]);
            if(count < a.length -1) {
                System.out.print(", ");
            }
            count++;
        }
        System.out.print("]");
        System.out.println();
    }
    
    public static void insertionSort(int[] a){
        int key;
        int j;
        if(a.length == 1){
            return ;
        }
        for(int i=1 ; i<a.length ; i++){
            key = a[i];
            j = i-1;
            while(j>=0 && a[j] > key){
                a[j+1] = a[j]; // đẩy các phần tử dịch lên trên 
                j--;
            }
            a[j+1] = key;
        }
    }
    
    public static void main(String[] args) {
        int i = iPosNum();
        int[] a = createArr(i);
        display(a, "Unsorted array; ");
        insertionSort(a);
        display(a, "Sorted array; ");
    }
}
