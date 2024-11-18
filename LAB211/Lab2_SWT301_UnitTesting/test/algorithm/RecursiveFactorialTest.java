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
public class RecursiveFactorialTest {

    private RecursiveFactorial recursiveFactorial;

    @Before
    public void setUp() {
        recursiveFactorial = new RecursiveFactorial();
    }

    @Test
    public void testFactorial0() {
        assertEquals(1, recursiveFactorial.factorial(0));
    }

    @Test
    public void testFactorial1() {
        assertEquals(1, recursiveFactorial.factorial(1));
    }

    @Test
    public void testFactorial3() {
        assertEquals(6, recursiveFactorial.factorial(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegativeInput() {
        recursiveFactorial.factorial(-5);
    }
}
