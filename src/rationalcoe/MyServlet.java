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
		
		System.out.println("uName="+uName+"pass="+pwd);
		
		//actionType="gp";
		
		
		
		if((null!=actionType))
		{
			if(actionType.equalsIgnoreCase("submit"))
			{
			
			HashMap returnMap = (HashMap)queryFromDB(uName, pwd);

				request.setAttribute("msg", returnMap.get("status"));
				

				}
				request.getRequestDispatcher("/nextPage.jsp").forward(request, response);
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


 