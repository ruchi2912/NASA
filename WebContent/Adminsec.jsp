<html>

<head>
<script>
function reloadGraph() {

   var now = new Date();

   document.getElementById('news').value = now.getTime();

   // Start new timer (1 min)
   timeoutID = setTimeout('reloadGraph()', 60000);
}

</script>
</head>
<body onload="reloadGraph()">
<h3> Live News Feed :</h3>
<input type="textarea" name="news" id="news">


</body>
</html>