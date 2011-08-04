package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;

import models.*;
import java.util.*;


public class Forms extends Controller {
    
    public static void index() {
    
    }
    
    public static void list() {
    
        List<Form> forms = Form.findAll();
        render(forms);
    }
    
    public static void create() {
    
        render();
    }
    
    public static void submit(@Valid Form form) {
    
        if (validation.hasErrors()) {
            render("@create", form);
        }
        form.create();
        Application.index();
    }
}