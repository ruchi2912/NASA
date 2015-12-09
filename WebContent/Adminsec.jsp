<html>

<head>
<script>
function reloadGraph() {

   var now = new Date();

   document.getElementById('news').value = now.getTime();

   // Start new timer (1 min)
   timeoutID = setTimeout('reloadGraph()', 60000);
}

function CallURL(){
	alert('calling');
var request = XMLHttpRequest();
request.open("GET", "http://example.org/file.html", false);
request.send(null);
alert('response-'+request.responseText);
}


function JsonpCallback(json)
{
	alert('in callback--'+json.result);
 document.getElementById('news').innerHtml=json.result;

}
	


</script>
</head>
<body onload="CallURL()">
<h3> Live News Feed :</h3>
<textarea name="news" id="news" rows="10" cols="50"></textarea>


</body>
</html>