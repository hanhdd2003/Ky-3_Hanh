/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package algorithm;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testSearchFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(4, binarySearch.search(arr, 9));
    }

    @Test
    public void testSearchNotFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(-1, binarySearch.search(arr, 8));
    }

    @Test
    public void testSearchFirstElement() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(0, binarySearch.search(arr, 1));
    }

    @Test
    public void testSearchLastElement() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(arr.length - 1, binarySearch.search(arr, 13));
    }

    @Test
    public void testSearchEmptyArray() {
        int[] arr = {};
        assertEquals(-1, binarySearch.search(arr, 13));

    }
}
