
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class Practical_Exercises {

//------------------------1---------------------
    public static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
//------------------------2---------------------

    public static int findMin(int[] a, int n) {
        // Base case: Nếu chỉ còn một phần tử, trả về giá trị đó
        if (n == 1) {
            return a[0];
        }

        // Gọi đệ quy để tìm giá trị nhỏ nhất trong mảng con từ vị trí 1 đến n-1
        int subMin = findMin(a, n - 1);

        // So sánh giá trị nhỏ nhất trong mảng con với phần tử ở vị trí n-1
        // Trả về giá trị nhỏ nhất
        return Math.min(subMin, a[n - 1]);
    }

//------------------------3---------------------
    public static int findSum(int[] a, int n) {
        if (n == 0) {
            return 0;
        }
        return a[n - 1] + findSum(a, n - 1);
    }

//------------------------4---------------------
    public static boolean isPalindrome(int[] a, int n) {
        if (n <= 1) {
            return true;
        }
        if (a[0] != a[n - 1]) {
            return false;
        }
        return isPalindrome(Arrays.copyOfRange(a, 1, n - 1), n - 2);
    }

//------------------------5---------------------
    public static int binarySearch(int[] a, int n, int target) {
        if (n == 0) {
            return -1;
        }
        int mid = n / 2;
        if (a[mid] == target) {
            return mid;
        }
        if (a[mid] > target) {
            return binarySearch(Arrays.copyOfRange(a, 0, mid), mid, target);
        } else {
            return binarySearch(Arrays.copyOfRange(a, mid + 1, n), n - mid - 1, target) + mid + 1;
        }
    }

//------------------------6---------------------
    public static int GCD(int m, int n) {

        if (n == 0) {
            return m;
        }

        return GCD(n, m % n);

    }

//------------------------7---------------------
    public static int power(int base, int exp) {

        if (exp == 0) {
            return 1;
        }

        return base * power(base, exp - 1);

    }

//------------------------8---------------------
    public static int fact(int n) {

        if (n <= 1) {
            return 1;
        }

        return n * fact(n - 1);

    }

//------------------------9---------------------
    public static int f(int n) {

        if (n <= 2) {
            return 1;
        }

        return f(n - 1) + f(n - 2);

    }

//------------------------10---------------------
    public static double addReciprocals(int n) {

        if (n == 1) {
            return 1.0;
        }

        return (1.0 / n) + addReciprocals(n - 1);

    }

//------------------------11---------------------
    public static int stirling(int n, int k) {

        if (n == 0 && k == 0) {
            return 1;
        }

        if (n > 0 && k == 0) {
            return 0;
        }

        if (k > 0) {
            return stirling(n - 1, k - 1) - n * stirling(n - 1, k);
        }

        return 0;

    }

    public static void main(String[] args) {
        int[] a = {2, 4, 5, 6, 7, 8};
        System.out.println(findSum(a, a.length));
    }
}
