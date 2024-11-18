package newconvert;

public class Convert {

    private final Validation val = new Validation();

    public void menuMain() {
        System.out.println("1. Convert From Binary. ");
        System.out.println("2. Convert From Decimal. ");
        System.out.println("3. Convert From Hexadecimal. ");
        System.out.println("4. Exit. ");
    }

    public void menuConvert() {
        System.out.println("1. Convert To Binary. ");
        System.out.println("2. Convert To Decimal. ");
        System.out.println("3. Convert To Hexadecimal. ");
        System.out.println("4. Exit. ");
    }

    public int binToDel(String s) {
        return Integer.parseInt(s, 2);
    }

    public String binToHex(String binary) {
        return delToHex(binToDel(binary));
    }

    public String delToHex(int x) {
        return Integer.toHexString(x).toUpperCase();
    }

    public String delToBin(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public int hexaToDel(String hexa) {
        return Integer.parseInt(hexa, 16);
    }

    public String hexaToBin(String hexa) {
        return Integer.toBinaryString(hexaToDel(hexa));
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        Validation val = new Validation();
        int choiceFrom;
        int choiceTo;
        String s;
        int a;
        while (true) {
            convert.menuMain();
            choiceFrom = val.choice();
            convert.menuConvert();
            choiceTo = val.choice();
            if (choiceFrom == 1 && choiceTo == 2) {
                s = val.isBinary();
                System.out.println(convert.binToDel(s));
            }else if (choiceFrom == 1 && choiceTo == 3){
                s = val.isBinary();
                System.out.println(convert.binToHex(s));
            }else if (choiceFrom == 2 && choiceTo == 1){
                a = val.isDecimal();
                System.out.println(convert.delToBin(a));
            }else if (choiceFrom == 2 && choiceTo == 3){
                a = val.isDecimal();
                System.out.println(convert.delToHex(a));
            }else if (choiceFrom == 3 && choiceTo == 1){
                s = val.isHexadecimal();
                System.out.println(convert.hexaToBin(s));
            }else if (choiceFrom == 3 && choiceTo == 2){
                s = val.isBinary();
                System.out.println(convert.hexaToDel(s));
            }else if (choiceFrom == 1 && choiceTo == 1){
                s = val.isBinary();
                System.out.println(s);
            }else if (choiceFrom == 3 && choiceTo == 3){
                s = val.isHexadecimal();
                System.out.println(s);
            }else if (choiceFrom == 2 && choiceTo == 2){
                a = val.isDecimal();
                System.out.println(a);
            }else if(choiceFrom == 4 || choiceTo == 4){
                System.exit(0);
            }
        }

    }
}
