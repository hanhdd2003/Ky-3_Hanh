/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;

/**
 *
 * @author admin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validation v = new Validation();
        Manager m = new Manager();
        while(true){
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int choice = v.checkChoice("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    //m.creatStudent();
                    m.generateStudent();
                    break;
                case 2:
                    m.findAndSort();
                    break;
                case 3:
                    m.updateOrDelete();
                    break;
                case 4:
                    m.report();
                    break;
                case 5:
                    return;
            }
        }
    }
    
}
