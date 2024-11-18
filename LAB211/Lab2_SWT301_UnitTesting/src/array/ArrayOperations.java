package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOperations {

    // Tính tổng các số trong mảng
    public int tinhTong(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Tìm số lớn nhất và nhỏ nhất trong mảng
    public int[] timGiaTriLonNhatNhoNhat(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Mảng rỗng.");
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return new int[]{max, min};
    }

    // Tìm phần tử lớn thứ 2 trong mảng
    public int timPhanTuLonThuHai(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException(
                    "Mảng không đủ phần tử để tìm phần tử lớn thứ 2.");
        }
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    // Đếm số phần tử lẻ và chẵn trong mảng
    public int[] demSoLeChan(int[] arr) {
        int countOdd = 0;
        int countEven = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        return new int[]{countEven, countOdd};
    }

    // Chèn 1 phần tử vào vị trí bất kỳ của mảng
    public int[] chenPhanTu(int[] arr, int value, int index) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("Vị trí chèn không hợp lệ.");
        }
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = arr[j++];
            }
        }
        return newArr;
    }

    // Xóa 1 phần tử ở vị trí bất kỳ trong mảng
    public int[] xoaPhanTu(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Vị trí xóa không hợp lệ.");
        }
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    // Đếm số lần lặp lại của 1 phần tử trong mảng
    public int demSoLanXuatHien(int[] arr, int value) {
        int count = 0;
        for (int num : arr) {
            if (num == value) {
                count++;
            }
        }
        return count;
    }

    // Xóa phần tử trùng lặp trong mảng
    public int[] xoaPhanTuTrungLap(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        int[] newArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArr[i] = list.get(i);
        }
        return newArr;
    }

}
