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
        BubbleArray m = new BubbleArray();
        int choice;
        int[] arr = null;
        while (true) {
            choice = m.menu();
            switch (choice) {
                case 1:
                    System.out.println("------- Input Element -------");
                    arr = m.createArray();
                    break;
                case 2:
                    System.out.println("----- Ascending ------");
                    if (arr != null) {
                        arr = m.ascending(arr);
                        m.display(arr, "->");
                    }else{
                        System.out.println("Please enter input element");
                    }
                    break;
                case 3:
                    System.out.println("----- Descending ------");
                    if (arr != null) {
                        arr = m.descending(arr);
                        m.display(arr, "<-");
                    }else{
                        System.out.println("Please enter input element");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
