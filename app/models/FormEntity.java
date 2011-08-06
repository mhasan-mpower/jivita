package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;


@Entity
@Table(name = "form_entity")
public class FormEntity extends Model {
    
    @Required
    public Date  start;
    
    @Required
    public Date  scheduled;
    
    public Short status = 0;
    
    @Required
    @ManyToOne(cascade = { CascadeType.ALL })
    public Form  form;
    
    @Required
    @ManyToOne(cascade = { CascadeType.ALL })
    public Woman woman;
    
    public FormEntity(Date scheduled, Form form, Woman woman) {
    
        this.scheduled = scheduled;
        this.form = form;
        this.woman = woman;
    }
    
    @PrePersist
    void beforeInsert() {
    
        if (this.start == null) {
            this.start = new Date();
        }
    }
    
    public void updateStatus(Short status) {
    
        Calendar now = Calendar.getInstance();
        now.setTime(this.start);
        
        // status 1 mean done
        if (status == 1) {
            
        }
        // status else mean not done
        else {
            // now.add(Calendar.DATE, 7);
            
            // check the form validity for next week rescheduling
            /*
             * if (this.start.before()) {
             * 
             * }
             */
        }
    }
}
