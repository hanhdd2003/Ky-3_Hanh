package convert;

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
        Manager man = new Manager();
        Validate val = new Validate();
        String value;
        int decimal;
        int choice;
        while (true) {
            System.out.println("-----------------");
            choice = man.showMenu();
            switch (choice) {
                case 1:
                    value = val.isBinary();
                    System.out.println(value + " convert to decimal: " + man.binToDel(value));
                    break;
                case 2:
                    value = val.isBinary();
                    System.out.println(value + " convert to hexadecimal: " + man.binToDel(value));
                    break;
                case 3:
                    decimal = val.isDecimal();
                    System.out.println(decimal + " convert to binary: " + man.delToBin(decimal));
                    break;
                case 4:
                    decimal = val.isDecimal();
                    System.out.println(decimal + " convert to hexadecimal: " + man.delToHex(decimal));
                    break;
                case 5:
                    value = val.isHexadecimal();
                    System.out.println(value + " convert to binary: " + man.hexaToBin(value));
                    break;
                case 6:
                    value = val.isHexadecimal();
                    System.out.println(value + " convert to decimal: " + man.hexaToDel(value));
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
