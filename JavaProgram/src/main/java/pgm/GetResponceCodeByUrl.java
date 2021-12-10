package pgm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class GetResponceCodeByUrl {
  @Test
	public static void getRespCode() throws IOException{
	  try {
		URL url=new URL("http:// www.javatpoint.com/java-tutorial");    
		HttpURLConnection huc=(HttpURLConnection)url.openConnection(); 
		System.out.println(huc.getResponseCode());
	  }
	  catch(Exception e) {
		  System.out.println("Invalid Exception "+e);
	  }
	}
  public static  void httpRequest() {
		try{    
			URL url=new URL("http://www.javatpoint.com/java-tutorial");    
			HttpURLConnection huc=(HttpURLConnection)url.openConnection();  
			for(int i=1;i<=8;i++){  
			System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));
			
			}System.out.println(huc.getResponseCode());  
			huc.disconnect();   
			}catch(Exception e){System.out.println(e);}    	   
	}
}
