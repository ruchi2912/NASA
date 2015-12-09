<html>

<head>
<script>

	function hit()
	{
		
		alert('hiited');
		document.getElementById('actionType').value="rss";

	document.fr.submit();
		
	}


</script>
</head>
<body>
<form name="fr" method="post" action="MyServlet">

<input type="hidden" name="actionType" id="actionType">
<h3> <input type="button" name="hit" value="Live News Feed :" onClick="hit()"></input></h3>

<textarea name="news" id="news" rows="10" cols="50"></textarea>


</body>
</html>