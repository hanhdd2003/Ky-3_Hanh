package loginservice;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void setUp() {
        loginService = new LoginService();
    }

    @Test
    public void testAuthenticateValidCredentials() {
        assertTrue(loginService.authenticate("user1", "password1"));
    }

    @Test
    public void testAuthenticateInvalidUsername() {
        assertFalse(loginService.authenticate("unknownUser", "password"));
    }

    @Test
    public void testAuthenticateInvalidPassword() {
        assertFalse(loginService.authenticate("user1", "wrongPassword"));
    }
}
