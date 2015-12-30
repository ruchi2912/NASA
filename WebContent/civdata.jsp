<!DOCTYPE html>
<html>
  <head>
    <title>Geocoding service</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
#floating-panel {
  position: absolute;
  top: 10px;
  left: 25%;
  z-index: 5;
  background-color: #fff;
  padding: 5px;
  border: 1px solid #999;
  text-align: center;
  font-family: 'Roboto','sans-serif';
  line-height: 30px;
  padding-left: 10px;
}

    </style>
  </head>
 
    <script>
    <%@page import="java.util.ArrayList" %>
  
function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 8,
    center: {lat: -34.397, lng: 150.644}
  });
  var geocoder = new google.maps.Geocoder();

  
    geocodeAddress(geocoder, map);
  
}

function geocodeAddress(geocoder, resultsMap) {
 
   <% ArrayList list = (ArrayList)request.getAttribute("list");
 if(list!=null){
   
   for(int i=0;i<list.size();i++) 
   {
    %>
  alert('loc='+<%=list.get(i)%>);
  geocoder.geocode({'address': <%=list.get(i);%>}, function(results, status) {
    if (status === google.maps.GeocoderStatus.OK) {
      resultsMap.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
        map: resultsMap,
        position: results[0].geometry.location
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
  <%}%>
}

function query()
{
	document.getElementById('actionType').value="qry";
	document.fr.submit();
	
}
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAU0Ym8pa4_hPz55AyrPjg4g5j_1jfB3L8&signed_in=false&callback=initMap"
        async defer></script>
         <body onload="query()">
         
         <form name="fr" method="post" action="MyServlet">
         <input type="hidden" name="actionType" id="actionType">
    <div id="floating-panel">
      <input id="address" type="hidden" value="575016">
     
    </div>
    <div id="map"></div>
        </form>
  </body>
</html>