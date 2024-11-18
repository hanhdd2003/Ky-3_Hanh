/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bank;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class BankAccountTest {
    
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("123456789", 1000);
    }


    @Test
    public void testWithdrawSufficientFunds() {
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.0);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.withdraw(1001);
    }
    
}
