<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Property</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>


 
 
 
 <div class="container">
  <img src="resources/place_an_ad.jpg"/>
      
      <form:form action="addedProperty.htm" method="get" commandName="property">
       <div class="form-group">
      <label class="control-label col-sm-2" for="location">Location</label>
      <div class="col-sm-10">
      <form:input path="location" size="30" id="location" class="form-control"/>
      </div>
      </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="username">Username</label>
      <div class="col-sm-10">
      <input type="text" name="agent" id="username" class="form-control"/>
      </div>
      </div>
       <div class="form-group">
      <label class="control-label col-sm-2" for="type">Type of Property</label>
      <div class="col-sm-10">
      <form:input path="propTypes" size="30" id="type" class="form-control"/>
      </div>
      </div>
      
      <div class="form-group">
      <label class="control-label col-sm-2" for="price">Price</label>
      <div class="col-sm-10">
      <form:input path="price" size="30" id="price" class="form-control"/>
      </div>
     </div>
      <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" value="Submit" class="btn btn-default"/>
      </div>
      </div>
      </form:form>
    </div>
   