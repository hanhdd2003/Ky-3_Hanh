package convert;


import java.util.Scanner;


public class Validate {
    private Scanner sc = new Scanner(System.in);
    
    public int choice(){
        String s;
        while (true) {            
            try {
                System.out.print("Enter your choice: ");
                s = sc.nextLine().trim();
                if(!s.isEmpty() && s.matches("[0-6]+")){
                    return Integer.parseInt(s);
                }
            } catch (NumberFormatException e) {
            }
        }
    }
    
    public int isDecimal(){
        String s;
        while (true) {            
            try {
                System.out.print("Enter Decimal: ");
                s = sc.nextLine().trim();
                if(!s.isEmpty() && s.matches("-?[0-9]*")){
                    return Integer.parseInt(s);
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
                if(this.isValidBin(s) && !s.isEmpty()){
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
                    return s;
                }
            } catch (Exception e) {
            }
        }
    }
    
    public Boolean isValidBin(String s){
        for(char c : s.toCharArray()){
            if( c != '0' && c != '1'){
                return false;
            }
        }
        return true;
    }
    
    
    
    
    public static void main(String[] args) {
        Validate val = new Validate();
        System.out.println(val.choice());
    }
}
