package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;


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
    
    public void update(Short status) {
    
        Calendar now = Calendar.getInstance();
        Calendar old = Calendar.getInstance();
        old.setTime(this.start);
        
        this.save();
        
    }
}
