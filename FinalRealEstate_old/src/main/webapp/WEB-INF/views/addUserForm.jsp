<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add User Form</title>
</head>
<body>

<h2>Register a New User</h2>

<form:form action="adduser.htm" commandName="user" method="post">

<table>
<tr>
    <td>User Name:</td>
    <td><form:input path="userName" size="30" /> <font color="red"><form:errors path="userName"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input path="emailId" size="30" /> <font color="red"><form:errors path="emailId"/></font></td>
 </tr>
  <tr>
    <td>Type of customer:</td>
    <td><form:radiobutton path="personTypes" value="Agent"/>Are you interested in selling? <font color="red"><form:errors path="personTypes"/></font></td>
    <td><form:radiobutton path="personTypes" value="Customer"/>Are you interested in buying the property? <font color="red"><form:errors path="personTypes"/></font></td>
    
 </tr>
<tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>

</form:form>

</body>
</html>