package test;

import newconvert.Validation;

public class Convert {

    Validation val = new Validation();

    public String binaryToDecimal(String binary) {
        int result = 0;
        int index = 0;
        char[] c = binary.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            result += Integer.parseInt(c[i] + "", 2) * Math.pow(2, index);
            index++;
        }
        return String.format("%-5s", result);
    }

    public String hexaToDecimal(String hexa) {
        int result = 0;
        int index = 0;
        char[] c = hexa.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            result += Integer.parseInt(c[i] + "", 16) * (int) Math.pow(16, index);
            index++;
        }
        return String.format("%-5s", result);
    }

    public String decimalToBinary(String decimal) {
        StringBuilder buff = new StringBuilder();
        int decimalValue = Integer.parseInt(decimal);
        while (decimalValue > 0) {
            buff.insert(0, decimalValue % 2);
            decimalValue = decimalValue / 2;
        }
        return buff.toString();
    }

    public String decimalToHexaDecimal(String decimal) {
        StringBuilder buff = new StringBuilder();
        char c;
        int remainder;
        int decimalValue = Integer.parseInt(decimal);
        while (decimalValue > 0) {
            remainder = decimalValue % 16;
            if (remainder >= 0 && remainder <= 9) {
                buff.insert(0, remainder);
            }else{
                c = (char) ('A' + (remainder -10) );
                buff.insert(0, c);
            }
            decimalValue = decimalValue / 16;
        }
        return buff.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Convert con = new Convert();
        System.out.println(con.decimalToHexaDecimal("3653"));
    }
}
