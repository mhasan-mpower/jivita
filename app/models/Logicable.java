package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;
import models.Woman.Event;


interface Logicable {
    
    public Date getEventDate(Event event);
}