package com.ft.ht;
// Generated Feb 12, 2008 4:21:46 PM by Hibernate Tools 3.2.0.CR1


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

//import org.apache.struts.action.ActionError;
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
     private String firstName;
     private String lastName;
     private Date birthDate;
     /**
      * Date when this person was added to the DB
     */
     private Date added;
     /**
      * Represents the duration an individual was at power
     */
     private Date inPower;
     private short offsprings;

    public DictatorForm() {
    }

	
    public DictatorForm(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public DictatorForm(String firstName, String lastName, Date birthDate, Date added, Date inPower, short offsprings) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.birthDate = birthDate;
       this.added = added;
       this.inPower = inPower;
       this.offsprings = offsprings;
    }
   
    public int getId() {
        return this.id;
    }
    
    protected void setId(int id) {
        this.id = id;
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
    /**       
     *      * Date when this person was added to the DB
     */
    public Date getAdded() {
        return this.added;
    }
    
    public void setAdded(Date added) {
        this.added = added;
    }
    /**       
     *      * Represents the duration an individual was at power
     */
    public Date getInPower() {
        return this.inPower;
    }
    
    public void setInPower(Date inPower) {
        this.inPower = inPower;
    }
    public short getOffsprings() {
        return this.offsprings;
    }
    
    public void setOffsprings(short offsprings) {
        this.offsprings = offsprings;
    }

}


