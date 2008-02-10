<%--  
 | Forward to the "View" Struts Global ActionForward. The only reason
 | this page exists is to allow our web.xml file to declare a welcome-file
 | which allows the unqualified URL of http://<servername>/webforum/
 | to start the application.
 +--%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page session="false" %>
<logic:redirect forward="adddictator"/>
