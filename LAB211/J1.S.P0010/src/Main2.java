
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main2 {

    private static final Logger logger = Logger.getLogger(Main2.class.getName());
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random(); // Đối tượng Random được tái sử dụng

    public static int inputNumOfArr() {
        int a;
        while (true) {
            try {
                logger.info("Enter number of array: ");
                a = Integer.parseInt(sc.nextLine().trim());
                if (a >= 0) {
                    return a;
                } else {
                    logger.warning("Number of array must be non-negative.");
                }
            } catch (NumberFormatException e) {
                logger.log(Level.SEVERE, "Please enter a valid number.", e);
            }
        }
    }

    public static int inputValue() {
        int a;
        while (true) {
            try {
                logger.info("Enter search value: ");
                a = Integer.parseInt(sc.nextLine().trim());
                if (a >= 0) {
                    return a;
                } else {
                    logger.warning("Enter search value again: ");
                }
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "Enter search value again: ", e);
            }
        }
    }

    public static int[] createArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(a.length) + 1;
        }
        return a;
    }

    public static void displayArr(int[] a) {
        logger.info(() -> "The array: " + Arrays.toString(a));
    }

    public static int searchNum(int num, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int sizeOfArr = inputNumOfArr();
        int value = inputValue();

        int[] arr = new int[sizeOfArr];
        createArr(arr);

        displayArr(arr);

        int result = searchNum(value, arr);
        if (result == -1) {
            logger.info(() -> "Not found " + value);
        } else {
            logger.info(() -> "Found " + value + " at index: " + result);
        }
    }
}
