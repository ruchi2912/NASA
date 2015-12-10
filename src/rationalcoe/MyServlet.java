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
		
		System.out.println("uName1="+uName+"pass="+pwd);
		
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
				request.getRequestDispatcher("/index2.html").forward(request, response);
				}
			   else
			   {
			   						System.out.println("Personnn");
			   	request.getRequestDispatcher("/index3.html").forward(request, response);
			   	
			   }

							}
			
				request.setAttribute("msg","failure");
				request.getRequestDispatcher("/index.html").forward(request, response);
				
			}
		else if (actionType.equalsIgnoreCase("rss"))
		{
	String st=(String)callURL("https://access.alchemyapi.com/calls/data/GetNews?apikey=4cbf3366314a3194b4b173adc1bcf450267753fa&start=1449014400&end=1449705599&outputMode=json&count=5&q.enriched.url.title=O[earthquakes^cyclones^floods]&return=enriched.url.url,enriched.url.title");
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
	
	String data=title;
		request.setAttribute("data",data);
				request.getRequestDispatcher("/Adminsec.jsp").forward(request, response);
		
		
		
		}
		else if (actionType.equalsIgnoreCase("logout"))
		{
			
			request.getRequestDispatcher("/index.html").forward(request, response);
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


 