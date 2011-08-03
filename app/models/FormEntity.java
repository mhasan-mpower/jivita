package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="form_entity")
public class FormEntity extends Model implements Event {
	public Date start;
	public Long validity;
}
