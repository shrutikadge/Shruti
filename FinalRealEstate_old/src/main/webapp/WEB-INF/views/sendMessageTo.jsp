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

</head>
<body>
<div class="container">
<div class="jumbotron1"> 
 <br><br><br>
 <img src="resources/msg.jpg"/>

 
 <div class="container">
      
      <form:form action="addMessage.htm" method="get" commandName="message">
    
     <div class="form-group">
      <label class="control-label col-sm-2" for="name">Name</label>
      <div class="col-sm-10">
      <input type="text" name="sender" id="name" class="form-control"/>
      </div>
      </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="receiver">Receiver</label>
      <div class="col-sm-10">
      <input type="text" name="receiver" id="receiver" class="form-control"/>
      </div>
      </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="message">Message</label>
      <div class="col-sm-10">
      <form:input path="message" size="100" id="message" class="form-control"/>
      </div>
     </div>
      <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" value="Submit" class="btn btn-default"/>
      </div>
      </div>
      </form:form>
      
    </div>
    </div>
    </div>