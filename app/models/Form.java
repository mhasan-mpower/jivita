package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

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
    public int         validity   = 0;
    
    /** Auto create this this form. */
    public Boolean     autoCreate = false;
    
    /** Auto create after autoCreateAfter days . */
    public int         autoCreateAfter;
    
    /** The auto create FormEntity. */
    public Trigger     autoCreateTrigger;
    
    /** The logics. */
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
    
    /**
     * Adds the logic to this Form.
     * 
     * @param status
     *            the status
     * @param base
     *            the base Date
     * @param outcome
     *            the outcome
     * @param destination
     *            the destination
     * @param duration
     *            the duration in days
     * @param event
     *            the event
     * @return the form
     */
    public Form addLogic(Status status, Event base, Outcome outcome, Form destination, int duration, Event event) {
    
        Logic newLogic = new Logic(this, status, base, outcome, destination, duration, event).save();
        this.logics.add(newLogic);
        this.save();
        return this;
    }
    
    /**
     * Invoke.
     * 
     * @param trigger
     *            the trigger
     * @param woman
     *            the woman
     */
    public static void invoke(Trigger trigger, Woman woman) {
    
        if (trigger == Trigger.REGISTRATION) {
            List<Form> forms = Form.find("SELECT f FROM Form f WHERE f.autoCreate=? AND f.autoCreateTrigger=?", true, trigger).fetch();
            
            Calendar nextWeek = Calendar.getInstance();
            nextWeek.setTime(woman.registered);
            nextWeek.add(Calendar.DATE, 7);
            
            for (Form form : forms) {
                new FormEntity(nextWeek.getTime(), form, woman).save();
            }
        }
    }
}
