<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html:html xhtml="true">
  <head><title>Add new dictator to database</title></head>
  <body>
    <html:form action="/AddDictator" method="post">
      <table border="1">
        <tr>
	   <td>First name :</td>
	   <td><html:text property="firstName"/></td>
	 </tr>
        <tr>
	   <td>Last name :</td>
	   <td><html:text property="lastName"/></td>
	 </tr>
        <tr>
	   <td>Birth date :</td>
	   <td><html:text property="birthDate"/></td>
	 </tr>
        <tr>
	   <td>id :</td>
	   <td><html:text property="id"/></td>
	 </tr>
	 <tr>
	   <td/><td><html:submit value="Submit"/></td>
	 </tr>
      </table>
    </html:form>
  </body>
</html:html>
