package extensions;

import java.util.*;

import play.templates.JavaExtensions;
import utils.*;


/**
 * The Class CustomExtensions. To be used in the views.
 */
public class CustomExtensions extends JavaExtensions {
    
    /**
     * Convert to jivita week from date.
     * 
     * @param date
     *            the date
     * @return the jivita week week
     */
    public static int asJWeek(Date date) {
    
        JWeek jw = JWeek.getInstance();
        return jw.getJWeek(date);
    }
    
    /**
     * Convert to date from jivita week.
     * 
     * @param jweek
     *            the jivita week
     * @return the date from jivita week
     */
    public static Date asDateFromJWeek(int jweek) {
    
        JWeek jw = JWeek.getInstance();
        return jw.getDate(jweek);
    }
}
