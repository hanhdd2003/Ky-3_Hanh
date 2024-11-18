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
public class PrimeCheckerTest {

    @Test
    public void testIsPrime_negative() {
        PrimeChecker primeChecker = new PrimeChecker();
        assertFalse(primeChecker.isPrime(-1));
    }

    @Test
    public void testIsPrime1() {
        PrimeChecker primeChecker = new PrimeChecker();
        assertFalse(primeChecker.isPrime(1));
    }

    @Test
    public void testIsPrime2() {
        PrimeChecker primeChecker = new PrimeChecker();
        assertTrue(primeChecker.isPrime(2));
    }

    @Test
    public void testIsPrime() {
        PrimeChecker primeChecker = new PrimeChecker();
        assertTrue(primeChecker.isPrime(3));
    }

    @Test
    public void testIsPrime4() {
        PrimeChecker primeChecker = new PrimeChecker();
        assertFalse(primeChecker.isPrime(4));
    }
}
