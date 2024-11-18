/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertFull;

/**
 *
 * @author Hanh
 */
public class ConvertMenu {

    private Validate val = new Validate();
    private int choice;

    public int menuFrom() {
        System.out.println();
        System.out.println("======Convert Program======");
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexadecimal.");
        System.out.println("4. Exit.");
        choice = val.choice();
        System.out.println();
        return choice;
    }

    public int menuTo() {
        System.out.println();
        System.out.println("1. Convert To Binary.");
        System.out.println("2. Convert To Decimal.");
        System.out.println("3. Convert To Hexadecimal.");
        System.out.println("4. Exit.");
        choice = val.choice();
        System.out.println();
        return choice;
    }

    public String binaryToDecimal(String binary) {
        //return Integer.parseInt(binary, 2)+"";
        int result = 0;
        int index = 0;
        char[] c = binary.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            result += Integer.parseInt(c[i] + "") * Math.pow(2, index);
            index++;
        }
        return result + "";
    }

    public String hexaToDecimal(String hexa) {
        //return Integer.parseInt(hexa, 16)+"";
        int result = 0;
        int index = 0;
        char[] c = hexa.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            result += Integer.parseInt(c[i] + "", 16) * Math.pow(16, index);
            index++;
        }
        return result + "";
    }

    public String decimalToBinary(String decimal) {
        //return Integer.toBinaryString(Integer.parseInt(decimal));
        StringBuilder build = new StringBuilder();
        int value = Integer.parseInt(decimal);
        while (value > 0) {
            build.insert(0, value % 2);
            value /= 2;
        }
        return build.toString();

    }

    public String decimalToHexa(String decimal) {
        //return Integer.toHexString(Integer.parseInt(decimal)).toUpperCase();
        StringBuilder build = new StringBuilder();
        int remainder;
        char c;
        int value = Integer.parseInt(decimal);
        while (value > 0) {
            remainder = value % 16;
            if (0 <= remainder && remainder <= 9) {
                build.insert(0, remainder);
            } else {
                c = (char) ('A' + (remainder - 10));
                build.insert(0, c);
            }
            value /= 16;
        }
        return build.toString();
    }

    public String converter(String value, int convertFrom, int convertTo) {
        //convert to decimal
        String decimalValue;
        switch (convertFrom) {
            case 1:
                decimalValue = this.binaryToDecimal(value);
                break;
            case 2:
                decimalValue = value;
                break;
            default:
                decimalValue = this.hexaToDecimal(value);
                break;
        }
        // convert to base
        switch (convertTo) {
            case 1:
                return this.decimalToBinary(decimalValue);
            case 2:
                return decimalValue;
            default:
                return this.decimalToHexa(decimalValue);
        }

    }

    public static void main(String[] args) {
        ConvertMenu convert = new ConvertMenu();
        Validate val = new Validate();
        String value = "";
        int choiceFrom;
        int choiceTo;
        while (true) {
            choiceFrom = convert.menuFrom();
            if (choiceFrom == 4) {
                System.exit(0);
            }
            choiceTo = convert.menuTo();
            if (choiceTo == 4) {
                System.exit(0);
            }
            switch (choiceFrom) {
                case 1:
                    value = val.isBinary();
                    break;
                case 2:
                    value = val.isDecimal();
                    break;
                case 3:
                    value = val.isHexadecimal();
                    break;
            }
            System.out.println();
            System.out.println(convert.converter(value, choiceFrom, choiceTo));
            System.out.println();
            if(!val.checkYN()){
                break;
            } 
        }

    }
}
