<html>


<head>
<script>
function clicked()
{
	alert('hi');
	document.getElementById('name').value=document.getElementById('login').value;
	document.getElementById('pwd').value=document.getElementById('password').value;	
	document.getElementById('actionType').value="submit";
	alert('val='+document.getElementById('actionType').value);
	document.fr.submit();
	
}

</script>
</head>
<body bgcolor="#cococo">
<form name="fr" method="post" action="MyServlet">
<input type="hidden" id="name" name="name">
<input type="hidden" name="actionType" id="actionType">
<input type="hidden" id="pwd" name="pwd">

<image src="/images/drs.jpg" hight="850" width="1350">

<h3>Natural Disaster Management System</h3>
<h4><align="right"> by DEVAC </align></h4>

<table colour="#cococo">
<tr><td>
User name : </td><td> <input type="text" name="login" id="login"></input>
</td></tr><tr><td>
Password: </td><td> <input type="password" name="password" id="password"></input>
</td></tr>
</table>
<input type="submit" value="Login" onClick="clicked()">

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