<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
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
    <thead>
   
      <tr>
        <th> <p>Browse all Properties</p>
        <form:form action="viewProperty.htm" method="get" commandName="property">
      <div class="form-group">
      <input type="submit" value="Submit" >
      </div>
      </form:form></th>
      
      </tr>
    </thead>
   
  </table>
</div>
    </div>
    </div>