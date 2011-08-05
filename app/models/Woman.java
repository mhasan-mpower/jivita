package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;


/**
 * The Class Woman.
 */
@Entity
public class Woman extends Model {
    
    /** The woman name. */
    public String name;
    
    /** The woman's husband name. */
    public String husbandName;
    
    /** The sector ID. */
    public Long   sectorId;
    
    /** The house hold ID. */
    public Long   hhId;
    
    /** The mauza name. */
    public String mauzaName;
    
    /** The ti pin cd. */
    public Long   tiPinCd;
    
    /** The ac area. */
    public Long   acArea;
    
    /** The urine positive week. */
    public Long   urinePositiveWeek;
    
    /** The lmp. */
    public Date   lmp;
    
    /** The status. */
    public Short  status;
    
    /**
     * The Constructor.
     * 
     * @param name
     *            the name
     * @param husbandName
     *            the husband name
     * @param sectorId
     *            the sector ID
     * @param hhId
     *            the house hold ID
     */
    public Woman(String name, String husbandName, Long sectorId, Long hhId) {
    
        this.name = name;
        this.husbandName = husbandName;
        this.sectorId = sectorId;
        this.hhId = hhId;
    }
    
}
