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
        Calculation calc = new Calculation();
        int choice;
        while (true) {            
            choice = calc.menu();
            switch(choice){
                case 1:
                    calc.normalCalculator();
                    break;
                case 2: 
                    calc.bmiCalculator();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
