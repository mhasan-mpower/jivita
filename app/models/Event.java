package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;


public interface Event {
    
    public void execute();
}
