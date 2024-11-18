/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package algorithm;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class PalindromeCheckerTest {

    @Test
    public void testIsPalindromeValid() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertTrue(palindromeChecker.isPalindrome(121));
    }

    @Test
    public void testIsPalindromeInvalid() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertFalse(palindromeChecker.isPalindrome(123));
    }
    @Test
    public void testIsPalindromeWith0() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        assertTrue(palindromeChecker.isPalindrome(0));
    }
}
