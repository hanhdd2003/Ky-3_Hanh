package convertFull;


import java.util.Scanner;


public class Validate {
    private Scanner sc = new Scanner(System.in);
    
    public int choice(){
        String s;
        while (true) {            
            try {
                System.out.print("Enter your choice: ");
                s = sc.nextLine().trim();
                if(!s.isEmpty() && s.matches("[1-4]+")){
                    return Integer.parseInt(s);
                }else{
                    System.out.println("Choice from 1 to 4.");
                }
            } catch (NumberFormatException e) {
            }
        }
    }
    
    public String isDecimal(){
        String s;
        while (true) {            
            try {
                System.out.print("Enter Decimal: ");
                s = sc.nextLine().trim();
                if(!s.isEmpty() && s.matches("[0-9]+")){
                    return s;
                }
            } catch (NumberFormatException e) {
            }
        }
    }
    public String isBinary(){
        String s;
        while (true) {            
            try {
                System.out.print("Enter Binary: ");
                s = sc.nextLine().trim();
                if(s.matches("[01]+") && !s.isEmpty()){
                    return s;
                }
            } catch (Exception e) {
            }
        }
    }
    
    public String isHexadecimal(){
        String s;
        while (true) {            
            try {
                System.out.print("Enter HexaDecimal: ");
                s = sc.nextLine().trim();
                if(s.matches("[0-9A-Fa-f]+") && !s.isEmpty()){
                    return s.toUpperCase();
                }
            } catch (Exception e) {
            }
        }
    }
    
    public Boolean checkYN(){
        String s;
        while(true){
            try {
                System.out.print("Do you want to continue?(Y/N): ");
                s = sc.nextLine().trim();
                if(!s.isEmpty() && s.matches("[ynYn]+")){
                    return s.equalsIgnoreCase("y");
                }
            } catch (Exception e) {
            }
        }
    }
    
    public static void main(String[] args) {
        Validate val = new Validate();
        System.out.println(val.isHexadecimal());
    }
}
