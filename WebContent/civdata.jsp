<html>
<head>



<script>
<% String msg = (String)request.getAttribute("data");
<%
	HashMap returnMap = (HashMap) request.getAttribute("returnMap");
	ArrayList prjDetailsAL = (ArrayList)returnMap.get("prjDetailsAL");
	
 %>


%>
function loadme()
{
document.getElementById('actionType').value="civ";		
document.fr.submit();
}

</script>
</head>
<% if(msg!=null)
{%>
<body>
<% }
else{%>
<body onload="loadme()">
	
	<%
}%>

<form name="fr" method="post" action="MyServlet">

<input type="hidden" name="actionType" id="actionType">

<center><h3>Query Project Details</h3></center>
<br><br>
Enter Project ID <Input type="text" name="prjId" id="prjId" value="">
<center>
<input type="button" name="Submit" Value="Click Me" onClick="hit()">
<table  border="1" bordercolor="black" >
<tr>
<td bgcolor="#CCFFCC" align="center"><b>Id</b></td>
<td bgcolor="#CCFFCC" align="center"><b>Name</b></td>
<td bgcolor="#CCFFCC" align="center"><b>DOB</b></td>
<td bgcolor="#CCFFCC" align="center"><b>Contact Number</b></td>
<td bgcolor="#CCFFCC" align="center"><b>Address</b></td>
<td bgcolor="#CCFFCC" align="center"><b>City</b></td>
<td bgcolor="#CCFFCC" align="center"><b>State</b></td>
<td bgcolor="#CCFFCC" align="center"><b>PIN</b></td>
</tr>
<%
for(int i=0;i<prjDetailsAL.size();i++)
{
 ProjectDetailsDTO prjDetailsDTO =(ProjectDetailsDTO)prjDetailsAL.get(i);
 %>
<tr>
<td><%=prjDetailsDTO.getId()%></td>
<td><%=prjDetailsDTO.getName()%></td>
<td><%=prjDetailsDTO.getDOB()%></td>
<td><%=prjDetailsDTO.getContact()%></td>
<td><%=prjDetailsDTO.getAddress()%></td>
<td><%=prjDetailsDTO.getCity()%></td>
<td><%=prjDetailsDTO.getState()%></td>
<td><%=prjDetailsDTO.getPIN()%></td>
</tr>
<%} %>

</table>



</body>
</html>