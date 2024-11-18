
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CalTest {
    
    public CalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd() {
        Cal cal = new Cal();
        int expected = 8;
        int result = cal.add(3, 5);
        assertEquals(expected, result);
    }

    @Test
    public void subTest(){
        Cal cal = new Cal();
        int expected = 11;
        int result = cal.sub(20, 10);
        assertEquals(expected, result);
        
    }
    
    
}
