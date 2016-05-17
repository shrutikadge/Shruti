<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form:form action="updateuser.htm" commandName="user" method="post">

<table>
<tr>
<tr>
    <td>First Name:</td>
    <td><form:input path="name" size="30" /> 
 </tr>
 
 <tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> 
 </tr>

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
    <td>SSN:</td>
    <td><form:input path="SSN" size="30" /> 
 </tr>
 
 <tr>
    <td>Age:</td>
    <td><form:input path="age" size="30" /> 
 </tr>
 
 <tr>
    <td>Phone Number:</td>
    <td><form:input path="phoneNumber" size="30" />
 </tr>
 
 <tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>

</form:form>


</body>
</html>