package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;
import models.Woman.*;


@Entity
public class Logic extends Model {
    
    public static enum SatusCode {
        ANY, YES, NO
    };
    
    
    @Required
    @ManyToOne(cascade = CascadeType.ALL)
    public Form      form;
    
    public SatusCode status   = SatusCode.ANY;
    
    public Event     base     = Event.NONE;
    
    public Outcome   outcome  = Outcome.NONE;
    
    @Required
    @ManyToOne(cascade = CascadeType.REMOVE)
    public Form      destination;
    
    public long      duration = 0;
    
    public Event     event    = Event.NONE;
    
    
    public Logic(Form form, SatusCode status, Event base, Outcome outcome, Form destination, long duration, Event event) {
    
        this.form = form;
        this.status = status;
        this.base = base;
        this.outcome = outcome;
        this.destination = destination;
        this.duration = duration;
        this.event = event;
    }
    
}
