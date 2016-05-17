
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
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
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
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
      
    </ul>
  </div>
</nav></br>

<div class="container">
  
  <h1>Welcome ${user.userName} ! </h1>
  
</div>
  
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="resources/buyer.jpg" alt="1">
    </div>

    <div class="item">
      <img src="resources/sell-your-home.jpg" alt="2">
    </div>

    <div class="item">
      <img src="resources/1.jpg" alt="3">
    </div>

   
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
</div>
<br><br>
<div class="container">
  
  <h2 align="center">Search over 107,418 real estate listings in Massachusetts, New Hampshire, Maine & Rhode Island</h2>
  
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








<!-- <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Created Successfully</title>
    </head>
    <body>
        New User Created Successfully: ${user.name}<br>
    </body>
</html>-->