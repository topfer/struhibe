<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page 
    import = "stPackage.SQLUtil"
    import = "java.sql.SQLException"
    import = "java.sql.ResultSet"
%>

<html:html xhtml="true">
  <head><title>List dictators</title></head>
  <body>
    <table border="1">
    <%
    ResultSet allDicts = SQLUtil.executeQuery(request.getSession().getServletContext().getRealPath("/misc") + "/listdict.sql", null); 
    while( allDicts.next() ) {
	   try {

	   String firstName = allDicts.getString("firstName");
	   String lastName = allDicts.getString("lastName");
	   String id = allDicts.getString("id");
	   String birthDate = allDicts.getString("birthDate");

	   out.println("<tr><td>" + firstName + "</td>");
	   out.println("<td>" + lastName + "</td>");
	   out.println("<td>" + id + "</td>");
	   out.println("<td>" + birthDate + "</td></tr>");
	   } catch (Exception e) {
	   out.println("<tr><td colspan=\"4\" align=\"center\">Exception</td></tr>");
	   }
    }
    %>
    </table>
  </body>
</html:html>
