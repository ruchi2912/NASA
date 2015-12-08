package rationalcoe;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Set;
import javax.naming.InitialContext;
import java.util.ArrayList;
import com.ibm.db2.jcc.DB2SimpleDataSource;
import com.ibm.nosql.json.api.*; 
  import com.ibm.nosql.json.util.*;
//import com.ibm.samples.trade.util.Log;
public class DRSEntity {

		/*
		 * Edited by Rational COE ,odified
		 */
		static java.sql.Connection conn;
			 ArrayList nameList = new ArrayList();
		     ArrayList addressList = new ArrayList();
		     HashMap returnMap = new HashMap();
	  private static String databaseHost = "";
    private static int port = 0;
    private static String databaseName = "";
        private static String databaseName_test = "";
    private static String user = "";
    private static String password = "";
    private static String url = "";
		     
	
	private static boolean processVCAP() {
        // VCAP_SERVICES is a system environment variable
        // Parse it to obtain the for DB2 connection info
        String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
        System.out.println("VCAP_SERVICES content: " + VCAP_SERVICES);

        if (VCAP_SERVICES != null) {
            // parse the VCAP JSON structure
            BasicDBObject obj = (BasicDBObject) JSON.parse(VCAP_SERVICES);
            String thekey = null;
            Set<String> keys = obj.keySet();
            System.out.println("Searching through VCAP keys");
            // Look for the VCAP key that holds the SQLDB information
            for (String eachkey : keys) {
                System.out.println("Key is: " + eachkey);
                // Just in case the service name gets changed 
                // to lower case in the future, use toUpperCase
                if (eachkey.toUpperCase().contains("SQLDB")) {
                    thekey = eachkey;
                }
            }
            if (thekey == null) {
                System.out.println("Cannot find any SQLDB service in VCAP; exit");
                return false;
            }
            BasicDBList list = (BasicDBList) obj.get(thekey);
            obj = (BasicDBObject) list.get("0");
            System.out.println("Service found: " + obj.get("name"));
            // parse all the credentials from the vcap env variable
            obj = (BasicDBObject) obj.get("credentials");
            databaseHost = (String) obj.get("host");
            databaseName = (String) obj.get("db");
            port = Integer.parseInt(obj.get("port").toString());
            user = (String) obj.get("username");
            password = (String) obj.get("password");
            url = (String) obj.get("jdbcurl");
        } else {
            System.out.println("VCAP_SERVICES is null");
            return false;
        }

        return true;
    }
    
    
    
	public java.sql.Connection createCon()
		     {
		     	System.out.println("inside createCon  123");
		     	
		     	java.sql.Connection con=null;   
		try{
			System.out.println("invoking processVCAP..Response is "+processVCAP());
			
		   DB2SimpleDataSource dataSource = new DB2SimpleDataSource();
		   System.out.println("-------------");

		   System.out.println("databaseHost=="+databaseHost);
		   System.out.println("port=="+port);
		   System.out.println("databaseName="+databaseName);
		   System.out.println("user=="+user);
		   System.out.println("password==="+password);
		   System.out.println("-------------" +url);
		   
dataSource.setServerName(databaseHost);
dataSource.setPortNumber(port);
dataSource.setDatabaseName(databaseName);
dataSource.setUser(user);
dataSource.setPassword (password);
dataSource.setDriverType(4);
con=dataSource.getConnection();
con.setAutoCommit(true);
}
catch(Exception e)
{
	e.printStackTrace();
}
			       return con;

		     }
		     
		     public void createTable()
		     {
		     	System.out.println("Inside createTable");
		     	try{
		     	conn=createCon();
		     	System.out.println("After creating connection"+conn);
		     	
				      Statement stmt = conn.createStatement();
				      Statement stmt2 = conn.createStatement();
				      System.out.println("Hi");
				 Boolean flag=stmt.execute("CREATE TABLE PROJECTDETAILS(EMP_ID INTEGER, PROJECT_NAME VARCHAR(30) NOT NULL,ACCOUNT_NAME VARCHAR(30),ISU_NAME VARCHAR(30),SUB_ISU_NAME VARCHAR(30),CLIENT_NAME VARCHAR(30),PROJECT_START_DATE VARCHAR(30),PROJECT_END_DATE VARCHAR(30),TEAM_STRENGTH INTEGER,PL_NAME VARCHAR(30),PL_CONTACT_NUM VARCHAR(30),LOCATION VARCHAR(30),SUB_LOCATION VARCHAR(30),STATUS VARCHAR(30),RATIONAL_TOOLS_USED VARCHAR(200),REFERENCIABLE VARCHAR(5))");
				    
				      
				      Boolean flag2=stmt2.execute("CREATE TABLE EMPIDTABLE(EMP_ID INTEGER NOT NULL)"); 
				      
				      
				  /*    Boolean flag = stmt.execute("select EMP_ID From EMPIDTABLE"); 
				      
				      ResultSet rs = stmt.executeQuery("select EMP_ID from EMPIDTABLE");
				      int num = 0;
				     
				      while (rs.next()) {
				      
				      Boolean flag=stmt.execute("DROP TABLE PROJECTDETAILS");
				      System.out.println("flag=="+flag);	
				      }*/
				    } catch (Exception e) {
					      e.printStackTrace();
					    }
		    	 
		     }
		
			
			public HashMap queryDetailsFromTable(String uName, String pwd)
			{
				
			    ArrayList prjDetailsAL = new ArrayList();
			    try {
			    	conn=createCon();
			      Statement stmt = conn.createStatement();
				Statement stmt2 = conn.createStatement();ResultSet rs=null;
				
					 rs= stmt2.executeQuery("select * from logindetails where USERNAME="'+uName+'" and PASSWORD="'+pwd+"'");
				
			      
				int num = 0;
			      if (rs.next()) {
			    	 num=num+1;
			      }
			      rs.close();
			    } catch (Exception e) {
				      e.printStackTrace();
				    }
			    System.out.println("puting in HashMap");
			    if(num==1){
			    returnMap.put("status","success");
		    }
		    else{
		    	 returnMap.put("status","failure");
		    }

			
			 return returnMap;   
			}
			
			
			
			public int deleteProjectDetails(String delId)
		     {
		    	    try {
					conn=createCon();
					if(delId!=null)
					{
					int prjId = Integer.parseInt(delId);
				      Statement stmt = conn.createStatement();
				 Boolean flag=stmt.execute("DELETE FROM PROJECTDETAILS where EMP_ID="+prjId);
				

				     // Boolean flag=stmt.execute("DROP TABLE PROJECTDETAILS");
				   //   System.out.println("flag=="+flag);	
				  
			      }

				    } catch (Exception e) {
					      e.printStackTrace();
					      return 0;
					    }
					    return 1;
		    	 
		     }
			}




