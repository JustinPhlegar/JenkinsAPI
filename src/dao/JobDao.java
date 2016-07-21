package dao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.io.OutputStream;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import dto.BuildByParam;
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

	public BuildByParam getJobByParam(String baseurl, String param) throws Exception
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
	  /*    Type listType = new TypeToken<Collection<BuildByParam>>() {}.getType();
	      Collection<BuildByParam> yourList = new Gson().fromJson(result.toString(), listType);
		 
	      System.out.println(yourList.size());*/
	      boolean found = false;
	      Type listType = new TypeToken<JsonObject>() {}.getType();
	      Gson gson = new Gson();
	      JsonObject json = gson.fromJson(result.toString(),listType );
	      JsonElement buildWithParam = null;
	      for(JsonElement build : json.get("builds").getAsJsonArray()){
	    	  for(JsonElement action : build.getAsJsonObject().get("actions").getAsJsonArray()){
	    		  try{
	    			  for(JsonElement parameter : action.getAsJsonObject().get("parameters").getAsJsonArray()){
		    			  if(parameter.getAsJsonObject().get("value").getAsString().equalsIgnoreCase(param)){
		    				  System.out.println("FOUND");
		    				  found = true;
		    				  break;
		    			  }
		    			  if(found) break;
		    		  }	  
	    		  }catch(NullPointerException npe){
	    			 
	    		  }

		    	  if(found) break;
	    	  }   
    		  if(found) {
    			  buildWithParam = build;
    			  break;
    		  }
	      }
	      String response = buildWithParam.toString().replace("{},", "").replace("{}]", "]").replace(":[{},", ":[").replace("},],", "}],");
	      System.out.println(response);
	     return gson.fromJson(response, BuildByParam.class);
	}
}
