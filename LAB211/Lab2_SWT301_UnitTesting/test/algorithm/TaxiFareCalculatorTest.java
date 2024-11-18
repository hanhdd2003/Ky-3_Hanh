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
public class TaxiFareCalculatorTest {

    @Test
    public void testTinhTienTaxi_KmNhoHon_Hoac_Bang30() {
        double expected29 = 9000 + 29 * 11000; // Giả sử số km là 29
        double actual29 = TaxiFareCalculator.tinhTienTaxi(29);
        assertEquals(expected29, actual29, 0.001); // Độ chính xác 0.001 VND
        double expected = 9000 + 30 * 11000; // Giả sử số km là 30
        double actual = TaxiFareCalculator.tinhTienTaxi(30);
        assertEquals(expected, actual, 0.001); // Độ chính xác 0.001 VND
    }

    @Test
    public void testTinhTienTaxi_KmLonHon30() {
        double expected = 9000 + 30 * 11000 + 1 * 9500; // Giả sử số km là 31
        double actual = TaxiFareCalculator.tinhTienTaxi(31);
        assertEquals(expected, actual, 0.001); // Độ chính xác 0.001 VND
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTinhTienTaxi_KmAm() {
        TaxiFareCalculator.tinhTienTaxi(-5);
    }

}
