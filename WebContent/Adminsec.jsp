<html>

<head>
<script>

	function hit1()
	{
		

		document.getElementById('actionType').value="rss";

	document.fr.submit();
		
	}


</script>
</head>
<body>
<script>
<% String msg = (String)request.getAttribute("data");
if(msg!=null)
{
	
}
else{
	msg="";
}
%>
 
 </script>
<form name="fr" method="post" action="MyServlet">

<input type="hidden" name="actionType" id="actionType">
<input type="button" name="RSS FEED" value="Live News Feed" onClick="hit1()"></input>


<textarea name="news" id="news" rows="10" cols="50" ><%=msg%></textarea>


</form>


</body>
</html>