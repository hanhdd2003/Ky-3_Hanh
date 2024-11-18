package array;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class ArrayOperationsTest {

    @Test
    public void testTinhTong_MangRong() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng không phần tử
        int[] arr1 = {};
        assertEquals(0, arrayOperations.tinhTong(arr1));
    }

    @Test
    public void testTinhTong_Mang1PhanTu() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng có một phần tử
        int[] arr2 = {5};
        assertEquals(5, arrayOperations.tinhTong(arr2));
    }

    @Test
    public void testTinhTong_NhieuPhanTu() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng có nhiều phần tử
        int[] arr3 = {1, 2, 3, 4, 5};
        assertEquals(15, arrayOperations.tinhTong(arr3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTimGiaTriLonNhatNhoNhat_MangRong() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng không phần tử
        int[] arr1 = {};
        arrayOperations.timGiaTriLonNhatNhoNhat(arr1);
    }

    @Test
    public void testTimGiaTriLonNhatNhoNhat_1PhanTu() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng có một phần tử
        int[] arr2 = {5};
        int[] expected2 = {5, 5};
        assertArrayEquals(expected2, arrayOperations.timGiaTriLonNhatNhoNhat(arr2));
    }

    @Test
    public void testTimGiaTriLonNhatNhoNhat_NhieuPhanTu() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng có nhiều phần tử
        int[] arr3 = {3, -1, 4, 2, 5};
        int[] expected3 = {5, -1};
        assertArrayEquals(expected3, arrayOperations.timGiaTriLonNhatNhoNhat(arr3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTimPhanTuLonThuHai_KhongDuPhanTu() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng không đủ phần tử để tìm phần tử lớn thứ 2
        int[] arr1 = {1};
        arrayOperations.timPhanTuLonThuHai(arr1);
    }

    @Test
    public void testTimPhanTuLonThuHai_DuPhanTu() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng đủ phần tử
        int[] arr2 = {3, 1, 4, 2, 5};
        assertEquals(4, arrayOperations.timPhanTuLonThuHai(arr2));
    }

    @Test
    public void testDemSoLeChan_MangRong() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng không có phần tử
        int[] arr1 = {};
        int[] expected1 = {0, 0};
        assertArrayEquals(expected1, arrayOperations.demSoLeChan(arr1));
    }

    @Test
    public void testDemSoLeChan_MangDuPhanTu() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test mảng có các phần tử lẻ và chẵn
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] expected2 = {2, 3};
        assertArrayEquals(expected2, arrayOperations.demSoLeChan(arr2));
    }

    @Test
    public void testChenPhanTu_VaoCuoiMang() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test chèn vào vị trí cuối cùng
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] expected3 = {1, 2, 3, 4, 5, 0};
        assertArrayEquals(expected3, arrayOperations.chenPhanTu(arr3, 0, arr3.length));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChenPhanTu_ViTriKhongHopLe() {
        ArrayOperations arrayOperations = new ArrayOperations();
        //Test chèn vào vị trí không hợp lệ
        int[] arr4 = {1, 2, 3, 4, 5};
        arrayOperations.chenPhanTu(arr4, 0, -1);

    }

    @Test
    public void testXoaPhanTu_CuoiCung() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test xóa phần tử ở vị trí cuối cùng
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] expected3 = {1, 2, 3, 4};
        assertArrayEquals(expected3, arrayOperations.xoaPhanTu(arr3, arr3.length - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testXoaPhanTu_KhongHopLe() {
        ArrayOperations arrayOperations = new ArrayOperations();
        //Test chèn vào vị trí không hợp lệ
        int[] arr4 = {1, 2, 3, 4, 5};
        arrayOperations.xoaPhanTu(arr4, -1);

    }

    @Test
    public void testDemSoLanXuatHienCoTrongMang() {
        ArrayOperations arrayOperations = new ArrayOperations();

        // Test số lần xuất hiện của phần tử trong mảng
        int[] arr = {1, 2, 3, 2, 5};
        assertEquals(2, arrayOperations.demSoLanXuatHien(arr, 2));
    }

    @Test
    public void testDemSoLanXuatHienKhongCoTrongMang() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test số lần xuất hiện của phần tử không có trong mảng
        int[] arr2 = {1, 2, 3, 4, 5};
        assertEquals(0, arrayOperations.demSoLanXuatHien(arr2, 6));
    }

    @Test
    public void testXoaPhanTuTrungLapCoPhanTuTrungLap() {
        ArrayOperations arrayOperations = new ArrayOperations();
        // Test xóa phần tử trùng lặp trong mảng
        int[] arr = {1, 2, 3, 2, 5};
        int[] expected = {1, 2, 3, 5};
        assertArrayEquals(expected, arrayOperations.xoaPhanTuTrungLap(arr));
    }

}
