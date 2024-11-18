/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package validate;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class ValidateTest {

    @Test
    public void testCheckPhone_Valid() {
        Validate validate = new Validate();
        assertTrue(validate.checkPhone("0123456789"));
    }

    @Test
    public void testCheckPhone_No0NumberFirst() {
        Validate validate = new Validate();
        assertFalse(validate.checkPhone("1234567890")); // Số điện thoại thiếu số 0 đầu tiên
    }

    @Test
    public void testCheckPhone_NoEnough10Number() {
        Validate validate = new Validate();
        assertFalse(validate.checkPhone("012345678")); // Số điện thoại thiếu số
    }

    @Test
    public void testCheckPhone_MoreThan10Number() {
        Validate validate = new Validate();
        assertFalse(validate.checkPhone("01234567890")); // Số điện thoại dài hơn 10 chữ số                
    }

    @Test
    public void testCheckPhone_NoSamePhonenumber() {
        Validate validate = new Validate();
        assertFalse(validate.checkPhone("abcdefghij")); // Không phải là số điện thoại
    }

    @Test
    public void testCheckUsernameValid() {
        Validate validate = new Validate();
        assertTrue(validate.checkUsername("user_name"));
        assertTrue(validate.checkUsername("user.name"));
        assertTrue(validate.checkUsername("user123"));
    }

    @Test
    public void testCheckUsernameInvalid() {
        Validate validate = new Validate();
        assertFalse(validate.checkUsername("user_.name")); // Hai ký tự gạch dưới và chấm liên tiếp nhau
        assertFalse(validate.checkUsername(".username")); // Dấu chấm ở đầu
        assertFalse(validate.checkUsername("username.")); // Dấu chấm ở cuối
        assertFalse(validate.checkUsername("")); // Tên người dùng trống
    }

    @Test
    public void testCheckEmailValid() {
        Validate validate = new Validate();
        assertTrue(validate.checkEmail("example@example.com"));
        assertTrue(validate.checkEmail("user_name@example.co.uk"));
        assertTrue(validate.checkEmail("user123@example.com.vn"));

    }

    @Test
    public void testCheckEmailInValid() {
        Validate validate = new Validate();
        assertFalse(validate.checkEmail("example@")); // Không có tên miền
        assertFalse(validate.checkEmail("@example.com")); // Không có tên người dùng
        assertFalse(validate.checkEmail("example.com")); // Thiếu ký tự '@'
        assertFalse(validate.checkEmail("example@.com")); // Thiếu tên miền
        assertFalse(validate.checkEmail("example@com")); // Thiếu dấu chấm sau tên miền
    }

    @Test
    public void testCheckPasswordValid() {
        Validate validate = new Validate();
        assertTrue(validate.checkPassword("Hanh@2003"));
        assertTrue(validate.checkPassword("12345678"));
        assertTrue(validate.checkPassword("123456789"));
    }

    @Test
    public void testCheckPasswordInvalid() {
        Validate validate = new Validate();
        assertFalse(validate.checkPassword("hanh2003")); // Thiếu ký tự viết hoa
        assertFalse(validate.checkPassword("HANH2003")); // Thiếu ký tự viết thường
        assertFalse(validate.checkPassword("Hanh2003")); // Thiếu ký tự đặc biệt
        assertFalse(validate.checkPassword("H@nH2o")); // Độ dài mật khẩu ít hơn 8 ký tự
        assertFalse(validate.checkPassword("1234567"));
    }

    @Test
    public void testIsLeapYear() {
        Validate validate = new Validate();
        assertTrue(validate.isLeapYear(2000));
        assertTrue(validate.isLeapYear(2004));
        assertFalse(validate.isLeapYear(1900));
    }

}
