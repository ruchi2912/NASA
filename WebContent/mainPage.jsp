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
		
		<style type="text/css">
			header, section, footer, aside, nav, article, figure, figcaption {
				display: block;}
			body {
				color: #666666;
				background-color: #f9f8f6;
				background-image: url("images/bg.jpg");
				background-position: center;
				font-family: Georgia, Times, serif;
				line-height: 1.4em;
				margin: 0px;}
			.wrapper {
				width: 940px;
				margin: 20px auto 20px auto;
				border: 2px solid #000000;
				background-color: #ffffff;}
			header {
				height: 160px;
				background-image: url("images/i7.jpg");}
			h1 {
				text-indent: -9999px;
				width: 940px;
				height: 130px;
				margin: 0px;}
			nav, footer {
				clear: both;
				color: #ffffff;
				background-color: #aeaca8;
				height: 30px;}
			nav ul {
				margin: 0px;
				padding: 5px 0px 5px 30px;}
			nav li {
				display: inline;
				margin-right: 40px;}
			nav li a {
				color: #ffffff;}
			nav li a:hover, nav li a.current {
				color: #000000;}
			section.courses {
				float: left;
				width: 659px;
				border-right: 1px solid #eeeeee;}
			article {
				clear: both;
				overflow: auto;
				width: 100%;}
			hgroup {
				margin-top: 40px;}
			figure {
				float: left;
				width: 290px;
				height: 220px;
				padding: 5px;
				margin: 20px;
				border: 1px solid #eeeeee;}
			figcaption {
				font-size: 90%;
				text-align: left;}
			aside {
				width: 230px;
				float: left;
				padding: 0px 0px 0px 20px;}
			aside section a {
				display: block;
				padding: 10px;
				border-bottom: 1px solid #eeeeee;}
			aside section a:hover {
				color: #985d6a;
				background-color: #efefef;}
			a {
				color: #de6581;
				text-decoration: none;}
			h1, h2, h3 {
				font-weight: normal;}
			h2 {
				margin: 10px 0px 5px 0px;
				padding: 0px;}
			h3 {
				margin: 0px 0px 10px 0px;
				color: #de6581;}
			aside h2 {
				padding: 30px 0px 10px 0px;
				color: #de6581;}
			footer {
				font-size: 80%;
				padding: 7px 0px 0px 20px;}
		</style>
		
	
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