package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;


@Entity
public class Form extends Model {
    
    @Required
    public String name;
    @Required
    public String shortName;
    
    public int    validity;
    
    public long   ifValid;
    public long   ifStillBirth;
    public long   ifDeath;
    public long   ifAlive;
    
    // Constructor
    public Form(String name, String shortName) {
    
        this.name = name;
        this.shortName = shortName;
    }
    
}
