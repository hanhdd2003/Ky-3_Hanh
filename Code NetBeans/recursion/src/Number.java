/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Number {

    // 0 2 4 8 16 32...

    public static int numb(int n){
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 2;
            default:
                return 2*numb(n-1);
        }
    }
    
    // 1 1/3 9 1/27 ...
    public static double cube(int n) {
        if (n == 0) {
            return 1;
        } else {
            return Math.pow(3,Math.pow(-1, n)) / cube(n - 1);
        }
    }

    // 0 1 2 5 12 29 70...
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            //0 2 4 8 16 32
            System.out.print(numb(i)+" ");
            //System.out.println (cube(i));
        }
    }
}
