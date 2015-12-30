 <!DOCTYPE html>
<html>
 <head>
 <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
 <meta charset="utf-8">
 <title>Geocoding service</title>
 <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
 <script>
var geocoder;
var map;
function codeAddress() {
 var address = document.getElementById('address').value;
 geocoder.geocode( { 'address': address}, function(results, status) {
 if (status == google.maps.GeocoderStatus.OK) {
 map.setCenter(results[0].geometry.location);
 placeMarker(results[0].geometry.location,map);
 document.getElementById("latitude").value = results[0].geometry.location.lat();
 document.getElementById("longitude").value = results[0].geometry.location.lng();
 
 } else {
 alert('Geocode was not successful for the following reason: ' + status);
 }
 });
}
var marker;
function placeMarker(location,map) {
 if ( marker ) {
 marker.setPosition(location);
 } else {
 marker = new google.maps.Marker({
 position: location,
 map: map
 });
 }
 }
function initialize() {
 geocoder = new google.maps.Geocoder();
 var latlng = new google.maps.LatLng(-34.397, 150.644);
 var mapOptions = {
 zoom: 8,
 center: latlng
 }
 map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
 google.maps.event.addListener(map, 'click', function (e) {
 document.getElementById("latitude").value = e.latLng.lat();
 document.getElementById("longitude").value = e.latLng.lng();
 placeMarker(e.latLng,map);
 });
}

google.maps.event.addDomListener(window, 'load', initialize);

 </script>
 </head>
 <body>
 <div id="panel">
 <input id="address" type="textbox" value="Sydney, NSW">
 <input type="button" value="Geocode" onclick="codeAddress()">
 </div>
 <div id="map-canvas" style="width: 300px; height: 300px"></div>
 <input type="text" name="latitude" id="latitude"/>
 <input type="text" name="longitude" id="longitude"/>
 </body>
</html>