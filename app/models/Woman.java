package models;

import play.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

import utils.*;


/**
 * The Class Woman.
 */
@Entity
public class Woman extends Model implements Logicable {
    
    /**
     * The Enum Outcome.
     */
    public static enum Outcome {
        
        /** The None. */
        NONE,
        /** The Alive. */
        ALIVE,
        /** The Dead. */
        DEAD,
        /** The Still Birth. */
        STILL_BIRTH,
        /** The Live Birth. */
        LIVE_BIRTH;
        
        /**
         * Gets the name.
         * 
         * @return the name
         */
        public String getName() {
        
            return StringUtil.titleCase(name());
        }
        
    };
    
    /**
     * The Enum Trigger.
     */
    public static enum Trigger {
        
        /** The NONE. */
        NONE,
        /** The REGISTRATION. */
        REGISTRATION,
        /** The DELIVERY. */
        DELIVERY,
        /** The OUTCOME. */
        OUTCOME;
        
        /**
         * Gets the name.
         * 
         * @return the name
         */
        public String getName() {
        
            return StringUtil.titleCase(name());
        }
        
    };
    
    /**
     * The Enum Event.
     */
    public static enum Event {
        
        /** The None. */
        NONE,
        /** The Registration. */
        REGISTRATION,
        /** The Delivery. */
        DELIVERY,
        /** The Outcome. */
        OUTCOME,
        /** The Last Menstrual Period. */
        LAST_MENSTRUAL_PERIOD;
        
        /**
         * Gets the name.
         * 
         * @return the name
         */
        public String getName() {
        
            return StringUtil.titleCase(name());
        }
        
    };
    
    /**
     * The Enum StatusCode.
     */
    public static enum Status {
        
        /** The Any. */
        ANY,
        /** The Complete. */
        COMPLETE,
        /** The Incomplete. */
        INCOMPLETE;
        
        /**
         * Gets the name.
         * 
         * @return the name
         */
        public String getName() {
        
            return StringUtil.titleCase(name());
        }
        
    };
    
    /** The woman name. */
    @Required
    public String name;
    
    /** The woman's unique ID. */
    @Required
    public Long   UID;
    
    /** The woman's husband name. */
    @Required
    public String husbandName;
    
    /** The sector ID. */
    @Required
    public Long   sectorId;
    
    /** The house hold ID. */
    @Required
    public Long   hhId;
    
    /** The mauza name. */
    public String mauzaName;
    
    /** The ti pin cd. */
    public Long   tiPinCd;
    
    /** The ac area. */
    public Long   acArea;
    
    /** The urine positive week. */
    public Long   urinePositiveWeek;
    
    /** The last menstrual period. */
    public Date   lmp;
    
    /** The registration Date. */
    public Date   registered;
    
    /** The delivery Date. */
    public Date   deliveryDate;
    
    /** The status. */
    public Short  status;
    
    /**
     * The Constructor.
     * 
     * @param UID
     *            the woman's unique ID
     * @param name
     *            the name
     * @param husbandName
     *            the husband name
     * @param sectorId
     *            the sector ID
     * @param hhId
     *            the house hold ID
     */
    public Woman(Long UID, String name, String husbandName, Long sectorId, Long hhId) {
    
        this.UID = UID;
        this.name = name;
        this.husbandName = husbandName;
        this.sectorId = sectorId;
        this.hhId = hhId;
        
    }
    
    /* (non-Javadoc)
     * @see play.db.jpa.JPABase#_save()
     */
    @Override
    public void _save() {
    
        this.registered = new Date();
        super._save();
        Form.invoke(Trigger.REGISTRATION, this);
    }
    
    /* (non-Javadoc)
     * @see models.Logicable#getEventDate(models.Woman.Event)
     */
    @Override
    public Date getEventDate(Event event) {
    
        switch (event) {
            case REGISTRATION:
                return this.registered;
            case DELIVERY:
                return this.deliveryDate;
            case LAST_MENSTRUAL_PERIOD:
                return this.lmp;
        }
        
        return new Date();
    }
}
