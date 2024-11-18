package gui;

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

    public Convert() {
    }

    public boolean validateBinary(String s) {
        return s.matches("^[01]+$");
    }

    public boolean validateDecimal(String s) {
        return s.matches("^[0-9]+$");
    }

    public boolean validateHexa(String s) {
        return s.matches("^[0-9a-fA-F]+$");
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

    public String hexaToDecimal(String hexa) {
        hexa = hexa.toUpperCase();
        BigInteger decimal = BigInteger.ZERO;
        BigInteger pow16 = BigInteger.ONE;
        BigInteger temp;
        char c;
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
        char c;
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

    public String convertResult(String value, int baseIn, int baseOut) {
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

}
