package pgm;


import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.testng.annotations.Test;

public class JavaPrectice {
	int i;
	int j;
	JFrame f; 
	
  void JavaPrectice(){  
	  f=new JFrame(); 
	    JOptionPane.showMessageDialog(f,"hello this is maven project ");  
	}  
  
	public void loop() {
		for (i = 1; i <=10; i++) {
			for ( j = 1; j <=i; j++) {
				System.out.print(i*j+" ");
				//new JavaPrectice();
			}System.out.println();
			
		}
	}
	
	
	
	
	
	
	public static  void primeNumber(int num) {
	int	temp=0;
		if(num==0||num==1) {
			System.out.println(num+"  is a Prime Number");
		}else {
			for (int i = 2; i < 10; i++)
			{
				if(num%i==0) {
					temp=temp+1;
				}	
			}
			if(temp<=1) 
			{
				System.out.println(num+" is a prime number");
				
			}else
			{
				System.out.println(num+" is not a prime number");
				
			}
		}
	}
	
	
	 @Test
	  public static void main () throws UnknownHostException {
		
	primeNumber(23);
			
			
	  }
}
