<html>
<head>
<title>HTML Frames</title>
<script>
<% String msg = (String)request.getAttribute("data");
 if(msg!=null){
    if(msg.equals("success")){System.out.println("inside");
   
 %>alert("Alerts sent successfully");
 <%}
 else if (msg.equals("failure")){%>
 alert("Alert notification failure!"); 
 <%
 
 
 }}%>
 
 </script>

</head>
<frameset rows="10%,90%" frameborder=NO name="tgt">
<frame name="se" src="bottom.html" scrolling="no" target="mid"/>
   <frameset Cols="40%,30%,30%" frameborder=NO name="mid">
   <frame name="sec" src="https://radisasterapp.mybluemix.net/disaster" scrolling="yes" frameborder="0"/>
   <frame name="third" src="DisplayMap.jsp" scrolling="no" frameborder="0"/>
    
   <frame name="five" src="twitterData.html" scrolling="no" frameborder="0"/>

 
 </frameset>   
</frameset><br><br>
<center>Powered by * <img src="/images/Watson-Avatar.jpg" height="30" width="30"></center>
</html>