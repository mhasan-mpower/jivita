package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Form extends Model {
	public String name;
	public String shortName;
	public Long validity;
}
