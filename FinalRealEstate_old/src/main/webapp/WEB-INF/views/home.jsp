<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
    
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
      <li><a href="adduser.htm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Login <span class="glyphicon glyphicon-log-in"></span></a>
          <div class="dropdown-menu">
            <form:form action="loginuser.htm" method="post" commandName="user">
              <div class="form-group">
      <label class="control-label col-sm-2" for="username">Username</label>
      <div class="col-sm-10">
              
                <form:input path="userName" size="30" id="username" class="form-control"/> 
                <form:errors path="userName" cssClass="error" element="div"/>
              </div>
              </div>
            <div class="form-group">
      <label class="control-label col-sm-2" for="password">Password</label>
      <div class="col-sm-10">
               
                <form:password path="password" size="30" id="password" class="form-control"/>
                <form:errors path="password" cssClass="error" element="div" />
              </div>
              </div>
            <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
             <input type="submit" value="Login" class="btn btn-default" />
             </div>
             </div>
            </form:form>
            <div class="container-fluid">
              <br>
              
            </div> 	
          </div>
        </li>
    </ul>
  </div>
</nav>

  
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
      <img src="resources/banner-1.jpg" alt="1">
    </div>

    <div class="item">
      <img src="resources/sell-your-home.jpg" alt="2">
    </div>

    <div class="item">
      <img src="resources/home.jpg" alt="3">
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
  
  <h2 align="center">Search over thousands of real estate listings in the world</h2>
  
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
