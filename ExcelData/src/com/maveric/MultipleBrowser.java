package com.maveric;

import java.util.Collection;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MultipleBrowser extends abst{
  @Test
	public static void main(String [] args) {
		
	//new	MultipleBrowser();
		
		
//		// TODO Auto-generated method stub
//     System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
//          WebDriver  driver= new  FirefoxDriver();
//          driver.get("https://www.google.com/");
//          System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
//          
//            new ChromeDriver();
	 TreeSet<Integer>   set = null;
	   int[] a= {3,4,7,9,3,3,6,3,9};
	   for(int b:a) {
	       set  =new TreeSet<Integer>();
	       set.add(b);
	   }
	   System.out.println(set);
	}

}
