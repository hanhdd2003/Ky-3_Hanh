/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package algorithm;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Hanh
 */
public class LinearSearchTest {

    private LinearSearch linearSearch;

    @Before
    public void setUp() {
        linearSearch = new LinearSearch();
    }

    @Test
    public void testSearchEmptyArray() {
        int[] arr = {};
        assertEquals(-1, linearSearch.search(arr, 13));
    }

    @Test
    public void testSearchNotFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(-1, linearSearch.search(arr, 8));
    }

    @Test
    public void testSearchLastElement() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(6, linearSearch.search(arr, 13));
    }

}
