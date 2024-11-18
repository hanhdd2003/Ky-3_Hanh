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
        Container man = new Container();
        man.generate();
        int choice;
        while (true) {            
            choice = man.menu();
            switch(choice){
                case 1:
                    man.addWorker();
                    break;
                case 2:
                    man.updateSalary(true);
                    break;
                case 3:
                    man.updateSalary(false);
                    break;
                case 4:
                    man.displaySalary();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
