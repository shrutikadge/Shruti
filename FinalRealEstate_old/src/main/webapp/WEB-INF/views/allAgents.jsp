<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Properties</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body>
<div class="container">
<div class="jumbotron1"> 
 
 <div class="container">
  <h2>All Agents</h2>
             
  <table class="table table-condensed">
 
 
 <tbody>
 <tr>

<th>User name</th>
<th>First Name</th>
<th>Last Name</th>
<th>Phone</th>
</tr>



        <c:forEach var="o" items="${agents}">
            <tr>
            	
                

                <td><c:out value="${o.userName}"/>
                </td>
                <td><c:out value="${o.name}"/></td>
                <td><c:out value="${o.lastName}"/></td>
                <td><c:out value="${o.phoneNumber}"/></td>
               
            </tr>
        </c:forEach>


 </tbody>
  </table>
</div>
    </div>
    </div>
</body>
</html>