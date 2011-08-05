package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;

import models.*;
import java.util.*;


public class Forms extends Controller {
    
    public static void index() {
    
    }
    
    public static void view(Long id) {
    
        Form form = Form.findById(id);
        render(form);
    }
    
    public static void edit(Long id) {
    
    }
    
    public static void list() {
    
        List<Form> forms = Form.findAll();
        render(forms);
    }
    
    public static void create() {
    
        List<Form> forms = Form.findAll();
        forms.add(0, new Form("Not Applicable"));
        render(forms);
    }
    
    public static void submit(@Valid Form form) {
    
        if (validation.hasErrors()) {
            List<Form> forms = Form.findAll();
            forms.add(0, new Form("Not Applicable"));
            render("@create", form, forms);
        }
        form.create();
        Application.index();
    }
}