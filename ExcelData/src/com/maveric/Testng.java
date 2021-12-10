package com.maveric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng {
   WebDriver driver;
     @DataProvider (name = "data-provider")
     public Object[] dpMethod(){
	 return new Object[] {"chrome","firefox"};
     }
     @DataProvider (name = "urls")
     public Object[] url(){
	 return new Object[] {"http://www.google.com","https://www.maveric-systems.com"};
     }
     
     @Test(dataProvider = "data-provider")
	public void Intialisation(String browsName) {
		if(browsName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver" ,"Drivers\\chromedriver.exe");
			driver	=new ChromeDriver();
		} else if(browsName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver" ,"Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
	  	
	}
     public  static void urlLaunches() {
     }
     
}
