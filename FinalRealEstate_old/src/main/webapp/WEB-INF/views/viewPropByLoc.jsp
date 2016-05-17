 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
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
  <h2>Browse Properties</h2>
             
  <table class="table table-condensed">
 
 
 <tbody>
      <tr>
        <td><p>Browse properties by location and type</p>
        <form:form action="viewPropertyByLoc.htm" method="get" commandName="property">
      <div class="form-group">
      
      Location: 
      <form:input path="location" size="30"/><form:errors path="location" cssClass="error" element="div"/>
      </div>
      <div class="form-group">
      
      Type of Property: 
      <form:input path="propTypes" size="30"/><form:errors path="propTypes" cssClass="error" element="div"/>
      </div>
      
      
      <div class="form-group">
      <input type="submit" value="Submit" >
      </div>
      </form:form>
        </td>
        </tr>
      
    </tbody>
  </table>
</div>
    </div>
    </div>