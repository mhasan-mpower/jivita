package extensions;

import java.util.*;

import play.templates.JavaExtensions;
import utils.*;


/**
 * The Class CustomExtensions. To be used in the views.
 */
public class CustomExtensions extends JavaExtensions {
    
    /**
     * Gets jivita week from date.
     * 
     * @param date
     *            the date
     * @return the jivita week week
     */
    public static int getJWeek(Date date) {
        JWeek jw = JWeek.getInstance();
        return jw.getJWeek(date);
    }
    
    /**
     * Gets date from jivita week.
     * 
     * @param jweek
     *            the jivita week
     * @return the date from jivita week
     */
    public static Date getDate(int jweek) {
        JWeek jw = JWeek.getInstance();
        return jw.getDate(jweek);
    }
}
