package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import models.Logic.SatusCode;
import models.Woman.*;


/**
 * The Class Form.
 */

@Entity
public class Form extends Model {
    
    /** The Form Name. */
    @Required
    public String      name;
    
    /** The Form Short name. */
    @Required
    public String      shortName;
    
    /** The Validity of the form in days. */
    @Min(0)
    public int         validity        = 0;
    
    /** Auto create this this form. */
    public Boolean     autoCreate      = false;
    
    /** Auto create after autoCreateAfter days . */
    public int         autoCreateAfter = 7;
    
    /** The auto create event. */
    public Outcome     autoCreateEvent;
    
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    public List<Logic> logics;
    
    
    /**
     * The Constructor.
     * 
     * @param shortName
     *            the form short name
     */
    public Form(String shortName) {
    
        this.logics = new ArrayList<Logic>();
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
    
    public Form addLogic(SatusCode status, Event base, Outcome outcome, Form destination, long duration, Event event) {
    
        Logic newLogic = new Logic(this, status, base, outcome, destination, duration, event).save();
        this.logics.add(newLogic);
        this.save();
        return this;
    }
    
    public static void invoke(Trigger trigger) {
    
    }
    
}
