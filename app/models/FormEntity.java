package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "form_entity")
public class FormEntity extends Model implements Event {
    
    @Required
    public Date  start;
    
    public Short status = 0;
    
    @ManyToOne(cascade = { CascadeType.ALL })
    public Form  form;
    
    @Required
    @ManyToOne(cascade = { CascadeType.ALL })
    public Woman women;
    
    public FormEntity(Date start, Form form, Woman woman) {
    
        this.start = start;
        this.form = form;
        this.women = woman;
    }
    
    public void execute() {
    
    }
}
