package rationalcoe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.*;


/**
 * Servlet implementation class for Servlet: MyServlet
 * forked the actual project IN DEC  2015
 *
 */
 public class MyServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 * edited by Rational coe
	 */
	public MyServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside the servelt");
		String actionType=request.getParameter("actionType");
		System.out.println("actionType123="+actionType);
		
		String uName = request.getParameter("name");
		String pwd = request.getParameter("pwd");	
		
		String pin = request.getParameter("pin");
		String mesg = request.getParameter("val");
		
		System.out.println("uName1="+pin+"pass="+mesg);
		
		//actionType="gp";
		
		
		
		if((null!=actionType))
		{
			if(actionType.equalsIgnoreCase("submit"))
			{
			
			HashMap returnMap = (HashMap)queryFromDB(uName, pwd);

				request.setAttribute("msg", returnMap.get("status"));
				

			String userName = (String)returnMap.get("uName");
			request.setAttribute("userName",returnMap.get("uName"));
			if(null!=userName)
			{
				if(userName.equals("admin"))
				{
					System.out.println("adminnn");
				request.getRequestDispatcher("/index2.jsp").forward(request, response);
				}
			   else
			   {
			   	//modified for only admin
			   						request.setAttribute("msg","failure");
				request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
			   	
			   }

							}
			else{
			request.setAttribute("msg","failure");
				request.getRequestDispatcher("/index.html").forward(request, response);
			}

				
			}
		else if (actionType.equalsIgnoreCase("rss"))
		{
	String st="Village floods for second time in five days";
	//Below code for connecting Alchemy API News
	//https://access.alchemyapi.com/calls/data/GetNews?apikey=&start=1449014400&end=1449705599&outputMode=json&count=2&q.enriched.url.title=O[earthquakes^cyclones^floods]&return=enriched.url.url,enriched.url.title");
	//355266491b345cda940733f6558d1db3373c9780
System.out.println("st inititated");
		    		String title="";
		try{
		JSONObject obj = new JSONObject(st);
		System.out.println("after callURL printing array" + obj.getJSONObject("results"));

		JSONArray arr = obj.getJSONObject("results").getJSONArray("docs");
		System.out.println("Hi..."+arr);
		for (int i = 0; i < arr.length(); i++)
		{
 title = arr.getJSONObject(i).getJSONObject("source").getJSONObject("enriched").getJSONObject("url").getString("title");
 	System.out.println("title---"+i+"---"+title);
		}

		
	}catch(Exception e)
	{
		System.out.println("error");
	}
	
	String data=st;
		request.setAttribute("data",data);
				request.getRequestDispatcher("/Adminsec.jsp").forward(request, response);
		
		
		
		}
		else if (actionType.equalsIgnoreCase("logout"))
		{
			
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
		else if (actionType.equalsIgnoreCase("maps"))	
			{
				
				
			}
		
		else if(actionType.equalsIgnoreCase("Alert"))
		{
			
		System.out.println("In ALERT ");
		//prjDetailsEntity.createTable();
		if((pin!=null) &&(mesg!=null) )
		  {
		     DRSEntity prjDetailsEntity = new DRSEntity();
			int val = prjDetailsEntity.alert(pin,mesg);
			if(val==1)
		    request.setAttribute("data","success");
		    else
		    request.setAttribute("data","failure");
		}
        else{
        	
        	request.setAttribute("data","failure");
        }
			
		
    response.sendRedirect(response.encodeRedirectURL("https://radisasterapp.mybluemix.net/disaster"));
			//	request.getRequestDispatcher("").forward(request, response);
		}
		else if (actionType.equalsIgnoreCase("qry"))
		{
			
			 DRSEntity prjDetailsEntity = new DRSEntity();
			 ArrayList list = (ArrayList)prjDetailsEntity.qry();
			 request.setAttribute("list",list);
			request.getRequestDispatcher("/civicdata.jsp").forward(request, response);
		}
		else if (actionType.equalsIgnoreCase("display"))
		{
			
			 DRSEntity prjDetailsEntity = new DRSEntity();
			 ArrayList list = (ArrayList)prjDetailsEntity.display();
		     if(list!=null)
		     {
		     	for(int i=0;i<1;i++)
		     	{
		     		
		     		String devId=(String)list.get(i);
		     		displaymp(devId);
		     		
		     				     	}
		     	
		     	
		     	
		     }
			 
			 
			 
			 
			 request.setAttribute("list",list);
			 request.setAttribute("data","success");
			request.getRequestDispatcher("/DisplayMain.jsp").forward(request, response);
		}
			}
			else 
			{
				request.setAttribute("msg","failure");
				request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
			}
		

		
		
	
	}
	
	public HashMap queryFromDB(String uName, String pwd)
	{
		DRSEntity prjDetailsEntity = new DRSEntity();
		System.out.println("In queryFromDB");
		//prjDetailsEntity.createTable();
		HashMap returnMap = prjDetailsEntity.queryDetailsFromTable(uName,pwd);
		return returnMap;
		
	}
	
	
	public static String callURL(String myURL) {
		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		//URLConnection urlConn = null;
		String urlString = "";
		try {
			URL url = new URL(myURL);
URLConnection urlConnection = url.openConnection();
         HttpURLConnection connection = null;
         if(urlConnection instanceof HttpURLConnection)
         {
            connection = (HttpURLConnection) urlConnection;
         }
         else
         {
            System.out.println("Please enter an HTTP URL.");
            return "invalid url";
         }
         BufferedReader in = new BufferedReader(
         new InputStreamReader(connection.getInputStream()));
         
         String current;
         while((current = in.readLine()) != null)
         {
            urlString += current;
         }
         System.out.println("url=="+urlString);
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return urlString;
	}
	
	public void displaymp(String deviceId)
	{
		
		deviceId=deviceId+"?top=1";
		String url="https://internetofthings.ibmcloud.com/api/v0001/historian/vp51e4/iotphone/"+deviceId;
		System.out.println("URL:"+url);
		String name = "a-vp51e4-iei2tiq7zb";
		String password = "3eJXlGC)hRBR67SFWI";

		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(name, password);

		final Client client = ClientBuilder.newClient();
		client.register(feature);    

		//Client client=ClientBuilder.newClient();
		WebTarget target=client.target(url);
		
		String returnedValue=target.request(MediaType.APPLICATION_JSON).get(String.class);
				
				//"[{\"evt_type\":\"sensorData\",\"timestamp\":{\"$date\":1450969041570},\"evt\":{\"id\":\"sarvendrak1\",\"ts\":1450969040392,\"lat\":12.9860293,\"lng\":77.7440598,\"ax\":0.08,\"ay\":-0.06,\"az\":0.01,\"oa\":14.88,\"ob\":23.22,\"og\":-2.45}}]";
		System.out.println("returned value:"+returnedValue);
		JSONParser parser = new JSONParser();
		try {
			JSONArray retArr=(JSONArray) parser.parse(returnedValue);
			System.out.println("jsonarr:"+retArr);
			JSONObject obj=(JSONObject) retArr.get(0);
			JSONObject obj1=(JSONObject) obj.get("evt");
			System.out.println("lat:"+obj1.get("lat"));
			System.out.println("lng:"+obj1.get("lng"));
			request.setAttribute("lat", obj1.get("lat"));
			request.setAttribute("lng", obj1.get("lng"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public void callBlueMix() 
	{
   /* try{
		  URL url = new URL("http://bmcoe-nodered-hack.mybluemix.net/tts/sayit?text_to_say=Hello");
      //  String query = INSERT_HERE_YOUR_URL_PARAMETERS;

        //make connection
        URLConnection urlc = url.openConnection();

        //use post mode
        urlc.setDoOutput(true);
        urlc.setAllowUserInteraction(true);
            //It Content Type is so importan to support JSON call
            urlc.setRequestProperty("Content-Type", "application/xml");
         



        //send query
        PrintStream ps = new PrintStream(urlc.getOutputStream());
        //ps.print(query);
        ps.close();

        //get result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        String l = null;
        while ((l=br.readLine())!=null) {
            System.out.println(l);
        }
       
       HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet("http://bmcoe-nodered-hack.mybluemix.net/tts/sayit?text_to_say=Hello");
HttpResponse response = client.execute(request);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
      //  br.close();
	}
	catch(Exception e)
	{
		System.out.println("Error occured");
	}

		*/
		
	}
}


 