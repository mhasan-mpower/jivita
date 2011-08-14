package utils;

import java.util.*;

import org.joda.time.*;


/**
 * JivitaWeek Wrapper Class. Converts date to jivita-week or jivita-week to date.
 */
public class JivitaWeek {
    
    /** The unique instance of singleton object. */
    private static JivitaWeek uniqInstance;
    
    /**
     * Prevent creating instances of a new JivitaWeek. No code required inside.
     */
    private JivitaWeek() {
        // Private constructor
    }
    
    /**
     * Gets the single instance of JivitaWeek.
     * 
     * @return single instance of JivitaWeek
     */
    public static synchronized JivitaWeek getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new JivitaWeek();
        }
        return uniqInstance;
    }
    
    /**
     * Gets date from jivita week.
     * 
     * @param jivitaWeek
     *            the jivita week
     * @return the date from jivita week
     */
    public Date getDate(final int jivitaWeek) {
        DateTime jivitaEpoch = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        DateTime date = jivitaEpoch.plusWeeks(jivitaWeek);
        return date.toDate();
    }
    
    /**
     * Gets jivita week from date.
     * 
     * @param date
     *            the date
     * @return the jivita week from date
     */
    public int getJivitaWeek(final Date date) {
        DateTime jivitaEpoch = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        DateTime givenDate = new DateTime(date);
        Weeks weeks = Weeks.weeksBetween(jivitaEpoch, givenDate);
        return weeks.getWeeks();
    }
    
    
}
