<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Google Map Template with Geocoded Address</title>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>	<!-- Google Maps API -->
	
	 <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBdT2JKGr1llxl9gSTksACvN1P9jVHHzsk&callback=Init">
    </script>
	
	
	
	 <script>
	 var map;
     function Init()
 	{
 		// Create a Google coordinate object for where to initially center the map
 		var latlng = new google.maps.LatLng( 38.8951, -77.0367 );	// Washington, DC
 		
 		// Map options for how to display the Google map
 		var mapOptions = { zoom: 12, center: latlng  };
 		
 		// Show the Google map in the div with the attribute id 'map-canvas'.
 		 map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
 		 document.getElementById('${o.location}').addEventListener('click', function() {
 	          UpdateMap();})
 	}
     
      
      
      function UpdateMap( )
  	{
    	 
  		var geocoder = new google.maps.Geocoder();    // instantiate a geocoder object
  		
  		// Get the user's inputted address
  		var address = document.getElementById( "address" ).value;
  	
  		// Make asynchronous call to Google geocoding API
  		geocoder.geocode( { 'address': address }, function(results, status) {
  			var addr_type = results[0].types[0];	// type of address inputted that was geocoded
  			if ( status == google.maps.GeocoderStatus.OK ) 
  				ShowLocation( results[0].geometry.location, address, addr_type );
  			else     
  				alert("Geocode was not successful for the following reason: " + status);        
  		});
  	}
      function ShowLocation( latlng, address, addr_type )
  	{
  		// Center the map at the specified location
  		map.setCenter( latlng );
  		
  		// Set the zoom level according to the address level of detail the user specified
  		var zoom = 12;
  		switch ( addr_type )
  		{
  		case "administrative_area_level_1"	: zoom = 6; break;		// user specified a state
  		case "locality"						: zoom = 10; break;		// user specified a city/town
  		case "street_address"				: zoom = 15; break;		// user specified a street address
  		}
  		map.setZoom( zoom );
  		
  		// Place a Google Marker at the same location as the map center 
  		// When you hover over the marker, it will display the title
  		var marker = new google.maps.Marker( { 
  			position: latlng,     
  			map: map,      
  			title: address
  		});
  		
  		// Create an InfoWindow for the marker
  		var contentString = "" + address + "";	// HTML text to display in the InfoWindow
  		var infowindow = new google.maps.InfoWindow( { content: contentString } );
  		
  		// Set event to display the InfoWindow anchored to the marker when the marker is clicked.
  		google.maps.event.addListener( marker, 'click', function() { infowindow.open( map, marker ); });
  	}
  	
  	// Call the method 'Init()' to display the google map when the web page is displayed ( load event )
  	google.maps.event.addDomListener( window, 'load', Init() );

      </script>
	
	
	
	</head>
	<body>
	
<TABLE WIDTH=100% BORDERCOLOR="#aabbcc">



<tr>
<th>Property Location</th>
<th>Property Type</th>
<th>Price</th>
<th>Agent Name</th>
<th>Location</th>
</tr>



        <c:forEach var="o" items="${properties}">
            <tr>
            	
                <td><input id="address" value="${o.location}"/> </td>
                
                <td>${o.propTypes}
                </td>
                <td>${o.price}</td>
                <td>${o.agent}</td>
                <td>
               
                
                 <input id="${o.location}" type="button" onclick="UpdateMap()" value="Geocode">
                 
   
                  <script>
	 var map;
     function Init()
 	{
    	 
 		// Create a Google coordinate object for where to initially center the map
 		var latlng = new google.maps.LatLng( 38.8951, -77.0367 );	// Washington, DC
 		
 		// Map options for how to display the Google map
 		var mapOptions = { zoom: 12, center: latlng  };
 		
 		// Show the Google map in the div with the attribute id 'map-canvas'.
 		 map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
 		 document.getElementById('${o.location}').addEventListener('click', function() {
 	          UpdateMap();})
 	}
     
      
      
      function UpdateMap( address )
  	{
    	 
  		var geocoder = new google.maps.Geocoder();    // instantiate a geocoder object
  		
  		// Get the user's inputted address
  		var address = document.getElementById( "address" ).value;
  	
  		// Make asynchronous call to Google geocoding API
  		geocoder.geocode( { 'address': address }, function(results, status) {
  			var addr_type = results[0].types[0];	// type of address inputted that was geocoded
  			if ( status == google.maps.GeocoderStatus.OK ) 
  				ShowLocation( results[0].geometry.location, address, addr_type );
  			else     
  				alert("Geocode was not successful for the following reason: " + status);        
  		});
  	}
      function ShowLocation( latlng, address, addr_type )
  	{
  		// Center the map at the specified location
  		map.setCenter( latlng );
  		
  		// Set the zoom level according to the address level of detail the user specified
  		var zoom = 12;
  		switch ( addr_type )
  		{
  		case "administrative_area_level_1"	: zoom = 6; break;		// user specified a state
  		case "locality"						: zoom = 10; break;		// user specified a city/town
  		case "street_address"				: zoom = 15; break;		// user specified a street address
  		}
  		map.setZoom( zoom );
  		
  		// Place a Google Marker at the same location as the map center 
  		// When you hover over the marker, it will display the title
  		var marker = new google.maps.Marker( { 
  			position: latlng,     
  			map: map,      
  			title: address
  		});
  		
  		// Create an InfoWindow for the marker
  		var contentString = "" + address + "";	// HTML text to display in the InfoWindow
  		var infowindow = new google.maps.InfoWindow( { content: contentString } );
  		
  		// Set event to display the InfoWindow anchored to the marker when the marker is clicked.
  		google.maps.event.addListener( marker, 'click', function() { infowindow.open( map, marker ); });
  	}
  	
  	// Call the method 'Init()' to display the google map when the web page is displayed ( load event )
  	google.maps.event.addDomListener( window, 'load', Init() );
  	
  	

      </script>
    
    
              
            </tr>
        </c:forEach>
</TABLE>
<br><br>
<div id="map-canvas" style="width:500px;height:380px;"></div>
 

</body>
</html>