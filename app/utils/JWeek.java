/*
 * 
 */
package utils;

import java.util.*;

import org.joda.time.*;


/**
 * Jivita Week Wrapper Class. Converts date to jivita-week or jivita-week to date.
 */
public class JWeek {
    
    /** The unique instance of singleton object. */
    private static JWeek uniqInstance;
    
    
    /** The start date of jivita week. */
    private DateTime     jivitaEpoch;
    
    /**
     * Prevent creating instances of a new JWeek.
     */
    private JWeek() {
        // Private constructor
        jivitaEpoch = new DateTime(2000, 1, 1, 0, 0, 0, 0);
    }
    
    /**
     * Gets the single instance of JWeek.
     * 
     * @return single instance of JWeek
     */
    public static synchronized JWeek getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new JWeek();
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
    public int getJWeek(final Date date) {
        DateTime givenDate = new DateTime(date);
        Weeks weeks = Weeks.weeksBetween(jivitaEpoch, givenDate);
        return weeks.getWeeks();
    }
    
    
}
