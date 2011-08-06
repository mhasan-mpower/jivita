package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;

import java.util.*;
import models.*;


public class Application extends Controller {
    
    public static void index() {
    
        List<String> sectors = Woman.find("SELECT DISTINCT w.sectorId AS id FROM Woman w").fetch();
        Collections.sort(sectors);
        sectors.add(0, "All");
        
        List<FormEntity> events = FormEntity.find("scheduled >= ?", new Date()).fetch();
        render(events, sectors);
    }
    
    public static void update(Long form_id, Short status) {
    
        FormEntity fe = FormEntity.findById(form_id);
        fe.update(status);
    }
}