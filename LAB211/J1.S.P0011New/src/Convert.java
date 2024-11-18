
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class Convert {

    private final Validate val = new Validate();
    private String value;

    public Convert() {
    }

    public int menuIn() {
        System.out.println("+===== Convert From Base =======+");
        System.out.printf("| %-20s\t|\n", "1.Convert From Binary.");
        System.out.printf("| %-20s\t|\n", "2.Convert From Decimal.");
        System.out.printf("| %-20s\t|\n", "3.Convert From Hexadecimal.");
        System.out.printf("| %-20s\t\t|\n", "4.Quit.");
        System.out.println("+===============================+");
        return val.choice();
    }

    public int menuOut() {
        System.out.println("+===== Convert To Base =========+");
        System.out.printf("| %-20s\t\t|\n", "1.Convert To Binary.");
        System.out.printf("| %-20s\t\t|\n", "2.Convert To Decimal.");
        System.out.printf("| %-20s\t|\n", "3.Convert To Hexadecimal.");
        System.out.printf("| %-20s\t\t|\n", "4.Quit.");
        System.out.println("+===============================+");
        return val.choice();
    }

    public String binaryToDecimal(String binary) {   //10010
        BigInteger result = BigInteger.ZERO;  // decimal = 0;
        BigInteger base2 = BigInteger.ONE;  // base2 = 1;  2^0
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result = result.add(base2);
            }
            base2 = base2.multiply(BigInteger.valueOf(2)); // base *= 2;  4
        }
        return result.toString();
    }
                                       //  0    1     2     3   4   => i
    public String bToD(String binary){ //  1    0     0     1   0  =  (1 * 2^1) + (1 * 2^4)
        int decimal = 0;               // 2^4  2^3   2^2   2^1  2^0  (base2 = 1)
        int base2 = 1; // = 2^0
        for (int i = binary.length() - 1; i >= 0; i--) {  // i :3
            if (binary.charAt(i) == '1') {
                decimal += base2; // 2
            }
            base2 *= 2; // 2 4
        }
        return String.valueOf(decimal);
    }

    /*
    
    
    */
    public String hexaToDecimal(String hexa) {
        hexa = hexa.toUpperCase();
        BigInteger decimal = BigInteger.ZERO;
        BigInteger pow16 = BigInteger.ONE;
        BigInteger temp;
        char c ;
        for (int i = hexa.length() - 1; i >= 0; i--) {
            c = hexa.charAt(i);
            if (Character.isDigit(c)) {
                temp = BigInteger.valueOf(c - '0');
            } else {
                temp = BigInteger.valueOf(c - 'A' + 10); //B: 11, C:12 ...
            }
            // d = d + temp*pow16
            decimal = decimal.add(temp.multiply(pow16));
            pow16 = pow16.multiply(BigInteger.valueOf(16));
           // pow16 = pow16 * 16; 
           
        }
        return decimal.toString();
    }

    public String decimalToBinary(String decimal) {
        BigInteger decimalValue = new BigInteger(decimal);
        if (decimalValue.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        BigInteger remainder;
        while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
            remainder = decimalValue.mod(BigInteger.valueOf(2));
            sb.insert(0, remainder);
            decimalValue = decimalValue.divide(BigInteger.valueOf(2));
        }
        return sb.toString();
    }

    public String decimalToHexa(String decimalValue) {
        BigInteger decimal = new BigInteger(decimalValue);
        if (decimal.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        BigInteger remainder;
        char c ;
        while (decimal.compareTo(BigInteger.ZERO) > 0) {
            remainder = decimal.mod(BigInteger.valueOf(16));
            if (remainder.compareTo(BigInteger.valueOf(9)) <= 0) {
                sb.insert(0, remainder);
            } else {
                 c = (char) ('A' + remainder.intValue() - 10);
                sb.insert(0, c);
            }
            decimal = decimal.divide(BigInteger.valueOf(16));
        }
        return sb.toString();
    }

    public void inValue(int baseIn) {
        switch (baseIn) {
            case 1:
                value = val.inBinary();
                break;
            case 2:
                value = val.inDecimal();
                break;
            default:
                value = val.inHexadecimal();
                break;
        }
    }

    public String convertResult(int baseIn, int baseOut) {
        String decimal;
        String result;
        switch (baseIn) {
            case 1:
                decimal = this.binaryToDecimal(value);
                break;
            case 2:
                decimal = value;
                break;
            default:
                decimal = this.hexaToDecimal(value);
                break;
        }
        switch (baseOut) {
            case 1:
                result = this.decimalToBinary(decimal);
                break;
            case 2:
                result = decimal;
                break;
            default:
                result = this.decimalToHexa(decimal);
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        BigInteger num = new BigInteger("1234567890987654321234567876543");
        System.out.println(num);
    }

}
