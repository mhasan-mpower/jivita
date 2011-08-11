package unit_test;

import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;


/**
 * The Class BasicTest.
 */
public class BasicTest extends UnitTest {
    
    /**
     * Clean existing test database and insert data form the /test/data.yml
     */
    @Before
    public void begin() {
    
        Fixtures.deleteDatabase();
        Fixtures.loadModels("data.yml");
    }
    
    /**
     * Test Woman module
     */
    @Test
    public void testWomanModule() {
    
        Woman oldWoman = new Woman((long) 1, "Salma", "Salauddin", (long) 120, (long) 101);
        oldWoman.save();
        Woman newWoman = Woman.find("byUID", 1).first();
        
        assertNotNull(newWoman);
        assertEquals(newWoman, oldWoman);
    }
}
