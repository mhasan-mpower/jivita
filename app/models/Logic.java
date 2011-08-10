package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;
import models.Woman.*;


/**
 * The Class Logic.
 */
@Entity
public class Logic extends Model {
    
    /** The form. */
    @Required
    @ManyToOne(cascade = CascadeType.ALL)
    public Form    form;
    
    /** The status. */
    public Status  status   = Status.ANY;
    
    /** The base Date. */
    public Event   base     = Event.NONE;
    
    /** The outcome. */
    public Outcome outcome  = Outcome.NONE;
    
    /** The destination Form. */
    @Required
    @ManyToOne(cascade = CascadeType.REMOVE)
    public Form    destination;
    
    /** The duration in days. */
    public int     duration = 0;
    
    /** The event. */
    public Event   event    = Event.NONE;
    
    
    /**
     * Instantiates a new logic.
     * 
     * @param form
     *            the form
     * @param status
     *            the status
     * @param base
     *            the base
     * @param outcome
     *            the outcome
     * @param destination
     *            the destination
     * @param duration
     *            the duration
     * @param event
     *            the event
     */
    public Logic(Form form, Status status, Event base, Outcome outcome, Form destination, int duration, Event event) {
    
        this.form = form;
        this.status = status;
        this.base = base;
        this.outcome = outcome;
        this.destination = destination;
        this.duration = duration;
        this.event = event;
    }
    
}