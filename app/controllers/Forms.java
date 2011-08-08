package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;

import models.*;

import java.util.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import models.Logic.SatusCode;
import models.Woman.Event;
import models.Woman.Outcome;


public class Forms extends Controller {
    
    public static void index() {
    
    }
    
    public static void view(Long id) {
    
        Form form = Form.findById(id);
        List<Form> forms = Form.findAll();
        render(form, forms);
    }
    
    public static void edit(Long id) {
    
        List<Form> forms = Form.findAll();
        forms.add(0, new Form("Not Applicable"));
        Form form = Form.findById(id);
        render(form, forms);
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
        form.save();
        list();
    }
    
    public static void addLogic(Long formId, Logic.SatusCode status, Event base, Outcome outcome, Long destination_id, long duration, Event event) {
    
        Form form = Form.findById(formId);
        
        if (validation.hasErrors()) {
            List<Form> forms = Form.findAll();
            render("@view", form, forms);
        }
        
        Form destination = Form.findById(destination_id);
        form.addLogic(status, base, outcome, destination, duration, event);
        view(formId);
    }
}