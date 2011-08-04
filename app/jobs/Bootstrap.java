package jobs;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;



@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
    
        // Check if the database is empty
        if (Woman.count() == 0) {
            Fixtures.loadYaml("initial-data.yml");
        }
    }
    
}