/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

public class RecursiveFactorial {

    public int factorial(int n) {
        if (n < 0) {
            throw new 
        IllegalArgumentException("n must be a non-negative integer");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        RecursiveFactorial r = new RecursiveFactorial();
        System.out.println(r.factorial(5));
    }
}
