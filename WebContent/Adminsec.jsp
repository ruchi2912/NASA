<html>

<head>
<script>
function reloadGraph() {

   var now = new Date();

   document.getElementById('news').value = now.getTime();

   // Start new timer (1 min)
   timeoutID = setTimeout('reloadGraph()', 60000);
}

function CallURL(){
	alert('calling ajax');
       $.ajax({

    url: 'https://access.alchemyapi.com/calls/data/GetNews?apikey=6c0d138eb473421646446e21d2d53e63834ac825&start=1449014400&end=1449705599&outputMode=json&count=25&q.enriched.url.title=O[earthquakes^cyclones^floods]&return=enriched.url.url,enriched.url.title',


    type: "GET",
    dataType: "jsonp",
    async:false,
     success: function (msg) {
         JsonpCallback(msg);
    },
    error: function () {
        ErrorFunction();
    }

});

}


function JsonpCallback(json)
{
	alert('in callback--'+json.result);
 document.getElementById('news').innerHtml=json.result;

}
	


</script>
</head>
<body onload="CallURL()">
<h3> Live News Feed :</h3>
<textarea name="news" id="news" rows="10" cols="50"></textarea>


</body>
</html>