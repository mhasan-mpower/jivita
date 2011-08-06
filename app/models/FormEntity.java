package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;


enum Outcome {
    ALIVE, DEAD, STILL_BIRTH, LIVE_BIRTH
}


@Entity
@Table(name = "form_entity")
public class FormEntity extends Model {
    
    @Required
    public Date    start;
    
    @Required
    public Date    scheduled;
    
    public Short   status = 0;
    
    public Boolean done   = false;
    
    @Required
    @ManyToOne(cascade = { CascadeType.ALL })
    public Form    form;
    
    @Required
    @ManyToOne(cascade = { CascadeType.ALL })
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
    
    public void update(Short status) {
    
        Calendar now = Calendar.getInstance();
        Calendar old = Calendar.getInstance();
        old.setTime(this.start);
        
        // status 1 mean done
        if (status == 1) {
            
        }
        // status else mean not done
        else {
            
            now.add(Calendar.DATE, 7);
            old.add(Calendar.DATE, this.form.validity);
            
            // check the form validity for next week rescheduling
            if (this.form.validity != 0 && old.after(now)) {
                new FormEntity(this.start, now.getTime(), this.form, this.woman).save();
            }
            else {
                Form nextForm = Form.findById(this.form.ifInvalid);
                new FormEntity(now.getTime(), nextForm, this.woman).save();
            }
        }
        
        this.status = status;
        this.save();
        
    }
}
