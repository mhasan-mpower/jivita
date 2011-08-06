package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;

import java.util.*;
import models.*;


public class Application extends Controller {
    
    public static void index() {
    
        List<FormEntity> events = FormEntity.find("scheduled >= ?", new Date())
                .fetch();
        render(events);
    }
    
    public static void update(Long form_id, Short status) {
    
        FormEntity fe = FormEntity.findById(form_id);
        fe.updateStatus(status);
    }
}