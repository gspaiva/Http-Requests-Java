import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.crypto.Data;

import com.google.gson.Gson;

public class HttpClient {
	
	public static URL url;
	public static HttpURLConnection connection;
	
	public static String doGetMethod(String u){
		
		String data = null;
		try {
			url = new URL(u);
			connection = (HttpURLConnection)url.openConnection();
			connection.connect();
			
			InputStream stream = connection.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			
			StringBuffer buffer = new StringBuffer();
			String line = " ";
			
			while((line = reader.readLine()) != null){
				buffer.append(line);
			}
			
			reader.close();
			connection.disconnect();
			data = buffer.toString();
			
		} 
		catch (MalformedURLException e) {
			return "Something is wrong with URL";
		}
		catch(IOException e){
			return " Something was wrong with data stream";
			
		}
		return data;
		
	}
	public static String doPostMethod(String u,String content){
		String data = " ";
		try {
			url = new URL(u);
			connection = (HttpURLConnection)url.openConnection();
			
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setChunkedStreamingMode(0);
			connection.setDoInput(true);
			connection.setRequestProperty( "Content-Type",  "application/json"); 
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			
			out.write(content);
			
			out.flush();
			out.close();
			
			InputStream stream = connection.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			
			StringBuffer buffer = new StringBuffer();
			String line = " ";
		
			while((line = reader.readLine()) != null){
				buffer.append(line);
				
			}
			data = buffer.toString();
			reader.close();
			connection.disconnect();
			
			
		} catch (MalformedURLException e) {
			System.out.print("something was wrong with url");
		}
		catch( IOException e)
		{
			System.out.print("something was wrong with IO");
			
		}
		
		return data;
	}
	
	
	
	
	
	
	
}
