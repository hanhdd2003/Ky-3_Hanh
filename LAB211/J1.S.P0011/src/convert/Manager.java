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
public class Manager {

    private Validate val = new Validate();

    public int showMenu() {
        System.out.println("1. Covert from binary to decimal.");
        System.out.println("2. Convert from binary to hexadecimal.");
        System.out.println("3. Convert from decimal to binary. ");
        System.out.println("4. Convert from decimal to hexadecimal. ");
        System.out.println("5. Convert from hexadecimal to binary. ");
        System.out.println("6. Convert from hexadecimal to decimal. ");
        System.out.println("0. Exit.");
        return val.choice();
    }

    public int binToDel(String s){
        return Integer.parseInt(s,2);
    }
    
    public String binToHex(String binary){
        return delToHex(binToDel(binary));
    }
    
    public String delToHex(int x){
        return Integer.toHexString(x).toUpperCase();
    }
    
    public String delToBin(int decimal){
        return Integer.toBinaryString(decimal);
    }

    public int hexaToDel(String hexa){
        return Integer.parseInt(hexa, 16);
    }
    
    public String hexaToBin(String hexa){
        return Integer.toBinaryString(hexaToDel(hexa));
    }
}
