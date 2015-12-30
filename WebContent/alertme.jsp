<html>
<head>
<script>
function alert()
{
	
	document.getElementById('actionType').value='Alert';
	document.fr.submit();
	
}
</script>
</head>


<body>

<form name="fr" method="post" action="MyServlet">
Enter the Alert Message : <input type="text" id="val" name="val">
Enter the Pin Code (area affected) : <input type="text" id="pin" name="pin">
<input type="submit" name="Alert Civilian" value="Alert Civilian" onclick="alert()">

<input type="hidden" name="actionType" id="actionType">
</body>
</html>