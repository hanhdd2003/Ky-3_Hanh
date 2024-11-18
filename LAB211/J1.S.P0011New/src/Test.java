/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hanh
 */
public class Test {

    public static void main(String[] args) {
        String name = "charric";
        char a = name.charAt(1);
        char b = name.charAt(2);
        StringBuilder s = new StringBuilder();
        s.append(b);
        s.append(a);
        
        System.out.println(s.toString());
    }

    public boolean check(String s) {
        int count = 0;
        char[] array = s.toCharArray();
        for (int i=0; i<array.length ; i++) {
            if (Character.isDigit(array[i])) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
