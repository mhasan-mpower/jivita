package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

import models.Woman.Outcome;


/**
 * The Class Form.
 */

@Entity
public class Form extends Model {
    
    /** The Form Name. */
    @Required
    public String  name;
    
    /** The Form Short name. */
    @Required
    public String  shortName;
    
    /** The Validity of the form in days. */
    public Integer validity;
    
    /** If this form is invalid or expired then goto form with id ifInvalid. */
    public Long    ifInvalid;
    
    /** If outcome is still birth then goto form with id ifStillBirth. */
    public Long    ifStillBirth;
    
    /** If outcome is live birth then goto form with id ifStillBirth. */
    public Long    ifLiveBirth;
    
    /** If outcome is dead then goto form with id ifDead. */
    public Long    ifDead;
    
    /** If outcome is alive then goto form with id ifAlive. */
    public Long    ifAlive;
    
    /** Auto create this this form. */
    public Boolean autoCreate      = false;
    
    /** Auto create after autoCreateAfter days . */
    public Integer autoCreateAfter = 7;
    
    /** The auto create event. */
    public Outcome autoCreateEvent;
    
    
    /**
     * The Constructor.
     * 
     * @param shortName
     *            the form short name
     */
    public Form(String shortName) {
    
        this.shortName = shortName;
    }
    
    /**
     * The Constructor.
     * 
     * @param name
     *            the form name
     * @param shortName
     *            the form short name
     */
    public Form(String name, String shortName) {
    
        this(shortName);
        this.name = name;
    }
    
    /**
     * Invoke.
     * 
     * @param outcome
     *            the outcome
     */
    public static void invoke(Outcome outcome) {
    
    }
    
}
