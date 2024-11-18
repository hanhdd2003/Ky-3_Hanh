
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static String enterContent() {
        String s;
        while (true) {
            try {
                System.out.println("Enter your content: ");
                s = sc.nextLine().trim();
                if (!s.isEmpty()) {
                    return s;
                }
            } catch (Exception e) {
                System.out.println("Please enter String");
            }
        }
    }

    public static HashMap<String, Integer> countWord(String s) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] arr = s.toLowerCase().split("[^a-zA-Z0-9]+");
        for (String a : arr) { //"[\\s+]"
            if (!a.isEmpty()) {
                wordCount.put(a, wordCount.getOrDefault(a, 0) + 1);
            }
        }
        return wordCount;
    }

    public static HashMap<Character, Integer> countChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            //loại bỏ khoảng trắng
            if (Character.isWhitespace(c) || !Character.isLetterOrDigit(c) ) {
                continue;
            }
            c = Character.toLowerCase(c);
            // nếu k rỗng thì thêm vào hashmap
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    public static void dislayWord(HashMap<String, Integer> wordCount) {
        int size = wordCount.size();
        int count = 0;
        int value;
        System.out.print("{");
//        for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
//            System.out.print(entry.getKey()+"="+entry.getValue());
//            if(count < size -1){
//                System.out.print(", ");
//            }
//            count++;
//        } 
        for (String key : wordCount.keySet()) {
            value = wordCount.get(key);
            System.out.print(key + "=" + value);
            if (count < size - 1) {
                System.out.print(", ");
            }
            count++;
        }
        System.out.print("}");
        System.out.println();
    }

    public static void dislayChar(HashMap<Character, Integer> charCount) {
        int size = charCount.size();
        int count = 0;
        System.out.print("{");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue());
            if (count < size - 1) {
                System.out.print(", ");
            }
            count++;
        }
        System.out.print("}");
        System.out.println();
    }

    public static void main(String[] args) {
        // enter string
        String s = enterContent();
        // count word
        //count char
        // display
        dislayWord(countWord(s));
        dislayChar(countChar(s));

    }
}
