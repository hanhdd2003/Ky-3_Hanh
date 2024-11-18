/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class RecursionTriangle {
    
    public static void printStart(int n){
        if(n <= 0){
            //System.out.print("* ");
        }else{
            System.out.print("* ");
            printStart(n-1);
        }
    }
    
    public static void triangleLn(int s){
        if(s > 0){
            triangleLn(s-1);
            System.out.println();
            printStart(s);
        }
    }
    
    
    public static void main(String[] args) {
        triangleLn(4);
    }
}
