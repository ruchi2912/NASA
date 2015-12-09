<html>

<head>
<script>
function reloadGraph() {

   var now = new Date();

   document.getElementById('news').value = now.getTime();

   // Start new timer (1 min)
   timeoutID = setTimeout('reloadGraph()', 60000);
}
!function(d,s,id)
{var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");

</script>
</head>
<body onload="reloadGraph()">
<h3> Live News Feed :</h3>
<input type="textarea" name="news" id="news">


<button title="Click to show/hide content" type="button" onclick="if(document.getElementById('spoilerTwitter') .style.display=='none') {document.getElementById('spoilerTwitter') .style.display=''}else{document.getElementById('spoilerTwitter') .style.display='none'}"><h2>Twitter</h2><br>Click to show/hide</button>
				<div id="spoilerTwitter" style="display:none">
					<a class="twitter-timeline" href="https://twitter.com/hashtag/devac" data-widget-id="674552898869563392">#devac Tweets</a>







</body>
</html>