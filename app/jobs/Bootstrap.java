package jobs;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;


/**
 * The Class Bootstrap.
 */
@OnApplicationStart
public class Bootstrap extends Job {
    
    /* (non-Javadoc)
     * @see play.jobs.Job#doJob()
     */
    public void doJob() {
    
        // Check if the database is empty
        if (Form.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
    
}