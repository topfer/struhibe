package com.ft.ht;
// Generated Feb 15, 2008 3:17:42 AM by Hibernate Tools 3.2.0.CR1


import java.util.Date;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *       Class that represents a single parson who deserves to be shot
 *       @author Thomas Fazekas
 *     
 */
public class DictatorForm extends ActionForm {


     private int id;
     /**
      * Atomatically generated date when this person was added to the DB
     */
     private Date added;
     private String firstName;
     private String lastName;
     private Date birthDate;
     private short offsprings;

    public DictatorForm() {
    }

	
    public DictatorForm(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public DictatorForm(Date added, String firstName, String lastName, Date birthDate, short offsprings) {
       this.added = added;
       this.firstName = firstName;
       this.lastName = lastName;
       this.birthDate = birthDate;
       this.offsprings = offsprings;
    }
   
    public int getId() {
        return this.id;
    }
    
    protected void setId(int id) {
        this.id = id;
    }
    /**       
     *      * Atomatically generated date when this person was added to the DB
     */
    public Date getAdded() {
        return this.added;
    }
    
    public void setAdded(Date added) {
        this.added = added;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public short getOffsprings() {
        return this.offsprings;
    }
    
    public void setOffsprings(short offsprings) {
        this.offsprings = offsprings;
    }




}


