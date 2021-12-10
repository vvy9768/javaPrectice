package pgm;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.testng.annotations.Test;

public class IpByUrl {
   @Test
	public static void getIpByUrl()
	        throws UnknownHostException
	    {
	        // The URL for which IP address needs to be fetched
	        String s = "https://www.google.com/";
	 
	        try {
	            // Fetch IP address by getByName()
	            InetAddress ip = InetAddress.getByName(new URL(s)
	                                                       .getHost());
	 
	            // Print the IP address
	            System.out.println("Public IP Address of: " + ip);
	        }
	        catch (MalformedURLException e) {
	            // It means the URL is invalid
	            System.out.println("Invalid URL");
	        }
	    
	    }
	
}
