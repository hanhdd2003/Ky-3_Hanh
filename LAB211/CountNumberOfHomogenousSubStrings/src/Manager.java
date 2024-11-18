
import java.util.HashMap;
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
public class Manager {

    private static final Scanner sc = new Scanner(System.in);

    public static HashMap<String, Integer> countWord(String s) {
        HashMap<String, Integer> count = new HashMap<>();

        boolean flag = false;

        int x = 0;

        do {
            flag = false;
            x++;
            for (int i = 0; i < s.length() - x + 1; i++) {
                String ss = s.substring(i, i + x);
                if (isHomogenous(ss)) {
                    flag = true;
                    if (!count.containsKey(ss)) {
                        count.put(ss, count.getOrDefault(ss, 0) + 1);
                    } else {
                        count.put(ss, count.get(ss) + 1);
                    }
                }

            }

        } while (flag);

        return count;
    }

    public static boolean isHomogenous(String s) {
        if (s.length() <= 1) {
            return true;
        }
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (c != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void display(HashMap<String, Integer> s) {
        for (String string : s.keySet()) {
            if (s.get(string) == 1) {
                System.out.println("\"" + string + "\" appears " + s.get(string) + " time.");
            } else {
                System.out.println("\"" + string + "\" appears " + s.get(string) + " times.");
            }
        }
        int result = 0;
        for(String string : s.keySet()){
            result += s.get(string);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String s = "abbcccaa";
        display(countWord(s));
    }
}
