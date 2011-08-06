package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;


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
    
    /**
     * The Constructor.
     * 
     * @param name
     *            the form name
     * @param shortName
     *            the form short name
     */
    public Form(String name, String shortName) {
    
        this.name = name;
        this.shortName = shortName;
    }
    
    /**
     * The Constructor.
     * 
     * @param shortName
     *            the form short name
     */
    public Form(String shortName) {
    
        this.shortName = shortName;
    }
    
}
