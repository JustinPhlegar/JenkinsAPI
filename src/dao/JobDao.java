package dao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.OutputStream; 

import com.google.gson.Gson;

import dto.Job;
public class JobDao {
	 TrustManager[] trustAllCerts = new TrustManager[]{
             new X509TrustManager() {

                 public java.security.cert.X509Certificate[] getAcceptedIssuers()
                 {
                     return null;
                 }
                 public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                 {
                     //No need to implement.
                 }
                 public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                 {
                     //No need to implement.
                 }
             }
     };

    
	public Job getJobs( String baseurl) throws Exception
	{ // Install the all-trusting trust manager
	     try 
	     {
	         SSLContext sc = SSLContext.getInstance("SSL");
	         sc.init(null, trustAllCerts, new java.security.SecureRandom());
	         HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	     } 
	     catch (Exception e) 
	     {
	         System.out.println(e);
	     }
		StringBuilder result = new StringBuilder();
	      URL url = new URL(baseurl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	     	      
	      Gson gson = new Gson();
	      
	     return gson.fromJson(result.toString(), Job.class);
	}
	
	public Job getJob(String baseurl) throws Exception
	{
		StringBuilder result = new StringBuilder();
	      URL url = new URL(baseurl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	     	      
	      Gson gson = new Gson();
	      
	     return gson.fromJson(result.toString(), Job.class);
	}

}
