<html>


<head>
<script>
function clicked()
{
	alert('hi');
	document.getElemenentById('name').value=document.getElementById('login').value;
	document.getElemenentById('pwd').value=document.getElementById('password').value;	
	document.getElemenentById('actionType').value="submit";
	document.fr.submit();
	
}

</script>
</head>
<body>
<form name="fr" method="post" action="MyServlet">
<input type="hidden" id="name">
<input type="hidden" id="actionType">
<input type="hidden" id="pwd">
<center>
<table colour="#cococo">
<tr><td>
User name : </td><td> <input type="text" name="login" id="login"></input>
</td></tr><tr><td>
Password: </td><td> <input type="password" name="password" id="password"></input>
</td></tr>

<tr><td> <input type="submit" value="Login" onClick="clicked()"></td></tr>
</table>

</center>

</form>
<script>
<% String msg = (String)request.getAttribute("msg");
 if(msg!=null){
    if(msg.equals("success")){System.out.println("inside");
   
 %>alert("Login Successful");
 <%}
 else if (msg.equals("failure")){%>
 alert("Login Failure"); 
 <%
 
 
 }}%>
 
 </script>
</body>

</html>