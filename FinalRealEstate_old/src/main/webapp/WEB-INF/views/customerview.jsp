<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
$(document).ready(function(){
    $(".nav-tabs a").click(function(){
        $(this).tab('show');
    });
});
</script>
  <style>
.jumbotron2 {
    background-color:grey;
    color:white;
    }
</style>
<style>
.jumbotron1 {
    background-color:white ;
    
    }
</style>
<style>
div {
width: 100%;
}
</style>
</head>
<body>
<div class="container">
<div class="jumbotron1">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">RealEstate</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Search for Homes
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li><a href="viewProperty.htm">All homes for Sale</a></li>
          <li><a href="browsePropertybyLoc.htm">Properties by location</a></li>
          <li><a href="browsePropertybyPrice.htm">Properties by Price</a></li> 
        </ul>
      </li>
      <li><a href="getAgents.htm">Agents</a></li>  
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><spring:url value="/logout.htm" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Logout</a> </li>
      
    </ul>
  </div>
</nav>

<div class="container">
 
 
    <ul class="nav nav-tabs">
     <li class="active"><a href="#menu1">Home</a></li>
    <li><a href="#Browse">View Advertisements</a></li>
    <li><a href="sendMessage.htm">Send Messages</a></li>
    <li><a href="#menu3">Sent Messages</a></li>
  </ul>

  <div class="tab-content">
   <br><br><br>
   <div id="menu1" class="tab-pane fade">
    <form action="updateuserform.htm" method="post">
      <input type="submit" value="Update you details"/>
      </form>
   <br><br><br>
   </div>
    <div id="Browse" class="tab-pane fade">
    
      <form action="browseProperty.htm" method="get">
      <input type="submit" value="view all properties"/>
      </form>
       <form action="browsePropertybyLoc.htm" method="get">
      <input type="submit" value="view properties by location"/>
      </form>
      <form action="browsePropertybyPrice.htm" method="get">
      <input type="submit" value="view properties by price"/>
      </form>
   
    </div>
    <div id="menu3" class="tab-pane fade">
     <form:form action="viewMyMessages.htm" method="get" commandName="message">
     <input type="text" name="userName" value='${user.userName}'>
     <input type="image" src="resources/Places-mail-folder-outbox-icon.png" alt="submit" width="100" height="100" value="view outbox"/>
     </form:form>
     <form:form action="viewMyMessagesInbox.htm" method="get" commandName="message">
     <input type="text" name="userName" value='${user.userName}'>
     <input type="image" src="resources/inbox_icon.jpg" alt="submit" width="100" height="100" value="view inbox"/>
     </form:form>
   
    </div>
  </div>
</div>
</div>
</div>

<div class="container">
 <div class="jumbotron2">
  <p> Popular Links </p>
  <a href="getAgents.htm" target="_self">All Agents</a>
  <a href="viewProperty.htm" target="_self">All Homes for Sale</a>
  <br><br>
  </div>
  </div>
</body>
</html>


