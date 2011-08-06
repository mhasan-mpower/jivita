package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;

import java.util.*;
import models.*;


public class Application extends Controller {
    
    public static void index() {
    
        List<Event> events = FormEntity.find("start > ?", new Date()).fetch();
        render(events);
    }
    
    public static void updateStatus() {
    
    }
    
}