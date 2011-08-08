package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

import models.Woman.*;


@Entity
public class FormEntity extends Model {
    
    @Required
    public Date    start;
    
    @Required
    public Date    scheduled;
    
    public Short   status = 0;
    
    public Boolean done   = false;
    
    @Required
    @ManyToOne(cascade = CascadeType.ALL)
    public Form    form;
    
    @Required
    @ManyToOne(cascade = CascadeType.ALL)
    public Woman   woman;
    
    
    public FormEntity(Date scheduled, Form form, Woman woman) {
    
        this.start = this.scheduled = scheduled;
        this.form = form;
        this.woman = woman;
    }
    
    public FormEntity(Date start, Date scheduled, Form form, Woman woman) {
    
        this(scheduled, form, woman);
        this.start = start;
        
    }
    
    public void update(Logic.StatusCode status, Outcome outcome) {
    
        List<Logic> logics = Logic.find("SELECT l FROM Logic l WHERE l.form=? AND l.status=? AND l.outcome", this.form, status, outcome).fetch();
        
        for (Logic logic : logics) {
            Date baseDate = this.woman.getEventDate(logic.base);
            Calendar validUntil = Calendar.getInstance();
            validUntil.setTime(baseDate);
            validUntil.add(Calendar.DATE, this.form.validity);
            
            if (validUntil.after(new Date())) {
                Calendar nextWeek = Calendar.getInstance();
                nextWeek.add(Calendar.DATE, 7);
                new FormEntity(nextWeek.getTime(), this.form, this.woman).save();
            }
            else {
                Date eventDate = this.woman.getEventDate(logic.event);
                Calendar nextDate = Calendar.getInstance();
                nextDate.setTime(eventDate);
                nextDate.add(Calendar.DATE, logic.duration);
                
                new FormEntity(nextDate.getTime(), logic.destination, this.woman).save();
            }
        }
        
        this.done = true;
        this.save();
    }
}
