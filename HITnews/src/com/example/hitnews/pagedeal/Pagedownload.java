package com.example.hitnews.pagedeal;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL; 
import org.apache.commons.*;
import org.apache.http.HttpStatus;

 public class Pagedownload 
 { 
	 public static String getHtmlData(String urlpath,String enCodeType) 
	 {
	       	try{
	            URL url = new URL(urlpath);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setConnectTimeout(6 * 1000);
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("contentType", enCodeType); 

	            if (conn.getResponseCode() == 200)
	            {
	                InputStream inputStream = conn.getInputStream();
	                String html = readStream(inputStream,enCodeType);
	                return html;
	            }
	       	}catch (IOException e) {
	            e.printStackTrace();
	            
	            
	       	}
	       	return null;
	   } 

	 public static String readStream(InputStream inputStream,String enCodeType)
	 {

	     StringBuffer buffer = new StringBuffer();
	    try{
	            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, enCodeType));
	            buffer = new StringBuffer();  
	            String line = "";
	            while ((line = in.readLine()) != null)
	            {  
	                buffer.append(line);  
	            }
	            in.close();
	            inputStream.close();
	        

	            return buffer.toString();
	    	}catch (IOException e) 
	    	{
	    		e.printStackTrace();
	    
     
	    	}
	    return null;
	 	}
} 
