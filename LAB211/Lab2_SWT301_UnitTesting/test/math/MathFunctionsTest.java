package math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Hanh
 */
public class MathFunctionsTest {

    private MathFunctions mathFunctions;

    @Before
    public void setUp() {
        mathFunctions = new MathFunctions();
    }

    @Test
    public void testTinhChuViHinhChuNhat() {
        assertEquals(10.0, mathFunctions.tinhChuViHinhChuNhat(2.0, 3.0), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTinhChuViHinhChuNhat_Exception() {
        mathFunctions.tinhChuViHinhChuNhat(-2.0, 3.0);
    }

    @Test
    public void testKiemTraNguyenAm() {
        assertTrue(mathFunctions.kiemTraNguyenAm('a'));
        assertTrue(mathFunctions.kiemTraNguyenAm('A'));
        assertTrue(mathFunctions.kiemTraNguyenAm('o'));
        assertTrue(mathFunctions.kiemTraNguyenAm('O'));
        assertTrue(mathFunctions.kiemTraNguyenAm('E'));
        assertTrue(mathFunctions.kiemTraNguyenAm('e'));
        assertTrue(mathFunctions.kiemTraNguyenAm('i'));
        assertTrue(mathFunctions.kiemTraNguyenAm('I'));
        assertTrue(mathFunctions.kiemTraNguyenAm('u'));
        assertTrue(mathFunctions.kiemTraNguyenAm('U'));
        assertFalse(mathFunctions.kiemTraNguyenAm('z'));
        assertFalse(mathFunctions.kiemTraNguyenAm(' '));
    }

    @Test
    public void testGiaiPhuongTrinhBacHai_2Nghiem() {
        assertEquals("Phương trình có hai nghiệm phân biệt: x1 = -1.0, x2 = -2.0",
                mathFunctions.giaiPhuongTrinhBacHai(1.0, 3.0, 2.0));
    }

    @Test
    public void testGiaiPhuongTrinhBacHai_NghiemKep() {
        assertEquals("Phương trình có nghiệm kép x = -1.0",
                mathFunctions.giaiPhuongTrinhBacHai(1.0, 2.0, 1.0));
    }

    @Test
    public void testGiaiPhuongTrinhBacHai_VoNghiem() {
        assertEquals("Phương trình vô nghiệm", mathFunctions.giaiPhuongTrinhBacHai(1.0, 2.0, 3.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiaiPhuongTrinhBacHai_Exception() {
        mathFunctions.giaiPhuongTrinhBacHai(0.0, 1.0, 2.0);
    }

}
