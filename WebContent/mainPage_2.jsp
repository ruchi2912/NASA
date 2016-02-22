<!DOCTYPE HTML>
<!--
	Retrospect by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>NInsurance System Login</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
	<link rel="stylesheet" href="css/main.css" />
	
		<script>
		
		function click1()
		{
			//alert("inside click"+document.getElementById('lg').style.display);
			document.getElementById('bt').style.display = 'none';
			document.getElementById('lg').style.display = 'block';
			
		}
		
		function clicked()
		{
			
			
			document.getElementById('name').value=document.getElementById('login').value;
	document.getElementById('pwd').value=document.getElementById('password').value;	
	document.getElementById('actionType').value="submit";

	document.fr.submit();
		}
		</script>
	</head>
	<body class="landing">
	<script>

<% String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	if(msg.equals("failure"))
	{%>
		alert("Please enter a valid UserName/Password!");
	<%}
	
}

%>
 
 </script>
<form name="fr" method="post" action="MyServlet">
<input type="hidden" id="name" name="name">
<input type="hidden" name="actionType" id="actionType">
<input type="hidden" id="pwd" name="pwd">
	
		<!-- Banner -->
			<section id="banner">
				<i class="icon fa-diamond"></i>
				<h2>Insurance Solution</h2>
				<p>Today.Tomorrow.Together!!</p>
				<ul class="actions">
					<li>
						<div id="bt" style="display:block">
						<input type="button" onclick="click1()" value="Enter"></div>
					<div id="lg" style="display:none">
						<table bgcolor="#0A0A2A" cellpadding=0 cellspacing=0>
						<tr>
						<td> User name : </td><td> <input type="text" name="login" id="login"></input>
						</td></tr><tr><td>
						Password: </td><td> <input type="password" name="password" id="password"></input>
						</td><td> <input type="submit" value="Login" onClick="clicked()"></td> </tr>
						</table>
						</div>
					</li>
				</ul>
			</section>
				<footer id="footer">
				<div class="inner">
						<ul class="copyright">
						<li>&copy; Tata Consultancy Services Ltd.</li>
						<li>Design: ATU(IBM SW)</li>
					</ul>
				</div>
			</footer>
			

		<!-- Scripts -->
			<script src="js/jquery.min.js"></script>
			<script src="js/skel.min.js"></script>
			<script src="js/util.js"></script>
			<script src="js/main.js"></script>
</form>
	</body>
</html>