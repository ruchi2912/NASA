<html>


<head>
<script>
function clicked()
{

	document.getElementById('name').value=document.getElementById('login').value;
	document.getElementById('pwd').value=document.getElementById('password').value;	
	document.getElementById('actionType').value="submit";

	document.fr.submit();
	
}

</script>
</head>


		
<body bgcolor="WHITE">
<form name="fr" method="post" action="MyServlet">
<input type="hidden" id="name" name="name">
<input type="hidden" name="actionType" id="actionType">
<input type="hidden" id="pwd" name="pwd">


<center>

<h4><align="right"> by IBM SW ATU Team, TCS </align></h4>
<br><br><br>
<table colour="WHITE">
<tr><td>
User name : </td><td> <input type="text" name="login" id="login"></input>
</td></tr><tr><td>
Password: </td><td> <input type="password" name="password" id="password"></input>
</td></tr>
</table>
<br>
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
 <center>Powered by <img src="/images/Watson-Avatar.jpg" height="30" width="30"></center>
</body>

</html>