<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
          <li><a href="#">All homes for Sale</a></li>
          <li><a href="#">All homes for Rent</a></li>
          <li><a href="#">All available homes</a></li> 
        </ul>
      </li>
      <li><a href="#">Agents & Offices</a></li> 
      <li><a href="#">Local Information</a></li> 
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><spring:url value="/logout.htm" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Logout</a> </li>
      
    </ul>
  </div>
</nav>

<div class="container">
  <h2>Dynamic Tabs</h2>
  <p>The <strong>show</strong> method shows the tab.</p>
  <ul class="nav nav-tabs">
    <li class="active"><a href="#home">Home</a></li>
    <li><a href="#menu1">Messages</a></li>
    <li><a href="#menu2">Add an advertisement</a></li>
    <li><a href="#menu3">Advertisements posted</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="tab-pane fade">
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="menu3" class="tab-pane fade">
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
</div>
</div>
</div>

<div class="container">
 <div class="jumbotron2">
  <p> Popular Links </p>
  <a href="/views/AllAgents.jsp" target="_self">All Agents</a>
  <a href="/views/AllHomesForSale.jsp" target="_self">All Homes for Sale</a>
  <a href="/views/AllHomes.jsp" target="_self">Property Records</a>
  <br><br>
  </div>
  </div>
</body>
</html>


