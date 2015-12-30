<html>
<head>
<script>
function query()
{

	
	document.getElementById('actionType').value="qry";
	document.fr.submit();
	

	
	
}
    </script>
          <body onload="query()">
         <form name="fr" method="post" action="MyServlet">
         <input type="hidden" name="actionType" id="actionType">
        </form>
  </body>
</html>