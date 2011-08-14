import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;
import utils.*;


/**
 * The Class BasicTest.
 */
public class BasicTest extends UnitTest {
    
    /**
     * Clean existing test database and insert data form the /test/data.yml
     */
    /*    @Before
        public void begin() {
            
            Fixtures.deleteDatabase();
            Fixtures.loadModels("data.yml");
        }*/
    
    
    @Test
    public void testJivitaWeek() {
        JivitaWeek jw = JivitaWeek.getInstance();
        
        Date date1 = new Date();
        int jw1 = jw.getJivitaWeekFromDate(date1);
        
        Date date2 = jw.getDateFromJivitaWeek(jw1);
        int jw2 = jw.getJivitaWeekFromDate(date2);
        
        System.out.print("Date = ");
        System.out.print(date1);
        System.out.println("");
        System.out.print("Jivita week = ");
        System.out.print(jw1);
        
        assertEquals(jw1, jw2);
    }
    
    /**
     * Test Woman module
     */
    @Test
    public void testWomanModule() {
        
        // Woman(Long UID, String name, String husbandName, Long sectorId, Long hhId)
        Woman oldWoman1 = new Woman((long) 1, "Salma", "Salauddin", (long) 120, (long) 101).save();
        Woman oldWoman2 = new Woman((long) 2, "Asiya", "Razzab", (long) 110, (long) 203).save();
        
        Woman newWoman1 = Woman.find("byUID", 1).first();
        
        FormEntity fe = FormEntity.find("SELECT f FROM FormEntity f, Woman w WHERE f.woman=w AND w.sectorId=?", (long) 120).first();
        
        assertNotNull(newWoman1);
        assertEquals(newWoman1, oldWoman1);
        assertNotSame(newWoman1, oldWoman2);
        
        assertEquals(newWoman1, fe.woman);
    }
}
