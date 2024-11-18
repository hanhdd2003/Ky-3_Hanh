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

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        for (int i = 0; i < 5; i++) {
            System.out.print(fibonacci(i)+ " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
