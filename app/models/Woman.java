package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Woman extends Model {
	public String name;
	public String husbandName;
	public Long sectorId;
	// House Hold ID
	public Long hhId;
	public String mauzaName;
	public Long tiPinCd;
	public Long acArea;
	public Long urinePositiveWeek;
	public Date lmp;
	public Short status;
	
	public Woman(String name, String husbandName, Long sectorId, Long hhId) {
		this.name = name;
		this.husbandName = husbandName;
		this.sectorId = sectorId;
		this.hhId = hhId;
	}
	
}
