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
public class BubbleSortTest {

    private BubbleSort sortingAlgorithm;

    @Before
    public void setUp() {
        sortingAlgorithm = new BubbleSort();
    }

    @Test
    public void testBubbleSort() {
        int[] arr1 = {5, 3, 7, 2, 8};
        sortingAlgorithm.bubbleSort(arr1);
        assertArrayEquals(new int[]{2, 3, 5, 7, 8}, arr1);
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] arr = {};
        sortingAlgorithm.bubbleSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testBubbleSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        sortingAlgorithm.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

}
