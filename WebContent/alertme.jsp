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
<br><br>
<p aling="center">
<table>
<tr><td>Enter the Alert Message : </td><td> <input type="text" id="val" name="val"></td></tr>
<tr><td>Enter the Pin Code (area affected) : </td><td><input type="text" id="pin" name="pin"></td></tr>
<tr><td><input type="submit" name="Alert Civilian" value="Alert Civilian" onclick="alert()"></td></tr>
</table>
</p>
<input type="hidden" name="actionType" id="actionType">
</body>
</html>