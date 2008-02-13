package com.ft.st;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ft.ht.DictatorForm;

//hibernate...
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Processes user's request to add an <code>Item</code> to the database.
 *  
 * @author Thomas Fazekas
 *
 */
public class AddDictatorAction extends Action {

  /**
   * execute() processes a user's request to add an <code>Item</code> to the database, 
   * given the data in the AddItemForm.  Forwards the user back to the input page.
   * 
   */
  public ActionForward execute(ActionMapping mapping,
			       ActionForm form,
			       HttpServletRequest request,
			       HttpServletResponse response) {
    /* 
     * Cast generic form to the Dictator bean.
     */
    //DictatorForm oneDictator = (DictatorForm) form;

    /* 
     * If the user has typed a name into the form,
     * 
     * Create an item with the name and description contained
     * in the form.
     * 
     * Using the ItemService, add the item to the persistence
     * layer.
     * 
     * Clear the form so that the two fields will be empty
     * upon the next load.
     */
    /*
    if (addItemForm.getName() != null)
      {
	Item item = new Item();
	item.setDescription(addItemForm.getDescription());
	item.setName(addItemForm.getName());
	ItemService.getInstance().addItem(item);
	addItemForm.clear();
      }
    */
    /* 
     * Always return to the "success" forward, currently
     * configured in struts-config.xml to return the user
     * to the AddItem.jsp.
     */

    //hibernate...

    DictatorForm oneDictator = (DictatorForm) form;

    Session session = new Configuration().configure("hibernate.mysql.cfg.xml").buildSessionFactory().getCurrentSession();
    session.beginTransaction();

    session.save(oneDictator);

    session.getTransaction().commit();

    return mapping.findForward("success");
  }
}
