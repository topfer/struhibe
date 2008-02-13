<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page import="java.util.List" %>

<%@ page import="org.hibernate.*" %>
<%@ page import="org.hibernate.cfg.Configuration" %>

<html:html>
  <head>
    <title>List/Add dictator</title>
    <html:base/>
  </head>
  <body bgcolor="white">

    <h3>List dictators</h3>
    <html:errors/>
    <%
    /*
    * This code will generate a list of objects from the
    * database and place a reference to this list in the
    * request object.
    *
    */

    /*
     * Use the ConnectionFactory to retrieve an open
     * Hibernate Session.
     * 
     */

    org.hibernate.Session my_session = new Configuration().configure("hibernate.mysql.cfg.xml").buildSessionFactory().getCurrentSession();
    List itemList;

     try {
	 /*
	  * Build HQL (Hibernate Query Language) query to retrieve a list
	  * of all the items currently stored by Hibernate.
	  */
	 my_session.beginTransaction();
	 Query query = my_session.createQuery("select item from com.ft.ht.DictatorForm item order by item.id");
	 itemList = query.list();
	 //my_session.getTransaction().commit();
     } catch (HibernateException e) {
	 System.err.println("Hibernate Exception" + e.getMessage());
	 throw new RuntimeException(e);
     }
     /*
      * Regardless of whether the above processing resulted in an Exception
      * or proceeded normally, we want to close the Hibernate session.  When
      * closing the session, we must allow for the possibility of a Hibernate
      * Exception.
      * 
      */
     finally {
	 if (my_session != null) {
	     try {
		 my_session.close();
	     }
	     catch (HibernateException e) {
		 System.err.println("Hibernate Exception" + e.getMessage());
		 throw new RuntimeException(e);
	     }
	 }
     }

   request.setAttribute("items", itemList);
    %>

    <p>List of items in <code>item</code> table of database <code>test</code>.</p>
    <table border="1">
      <!-- This code will iterate over the list of items, creating a table row for each item. -->
      
      <logic:iterate id="element" name="items" scope="request" type="com.ft.ht.DictatorForm">
	<tr>

	  <td><bean:write name="element" property="firstName"/></td>
	  <td><bean:write name="element" property="lastName"/></td>
	</tr>
      </logic:iterate>

    </table>

    <p>Sumbit to add an item:</p>		
    
    <!-- This form will post the submitted data 
	 to the addItem Action Mapping -->
    <html:form action="AddDictator.do" method="post">
      <table border="1">
	<tr><td>First name :</td><td><html:text property="firstName"/></tr>
	<tr><td>Last Name :</td><td><html:text property="lastName"/></td></tr>
      </table>
      <br/>
      <html:submit/>
    </html:form>
  </body>

</html:html>
