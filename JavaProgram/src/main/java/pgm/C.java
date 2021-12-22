package pgm;

import java.awt.Rectangle;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class C{
	
	
	//@Test
	public void driver() {
		System.setProperty("webdriver.chrome.driver", "jar\\chromedriver.exe");
		  ChromeDriver driver =new ChromeDriver();
		  driver.get("https://www.inn-flow.com");
		  driver.manage().window().maximize();
	WebElement	 weProduct  =driver.findElement(By.xpath("(//ul[@class='primary-nav navbar-nav ml-auto']//btn)[1]"));
		   Actions act= new Actions(driver);
	      act.moveToElement(weProduct);
	     act.click();
	      act.build().perform();
	      WebElement weEle = null;
	    
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      try{
	    List<WebElement> listEle =driver.findElements(By.xpath("//ul[@class='dropdown-menu show']//li"));
	    for (int i = 0; i < listEle.size(); i++) {
	    	 weEle=listEle.get(i);
	      String text = weEle.getText();
	      System.out.println(text);
	      weEle.click();
	    
	       
	    }  
	       }
	       catch(StaleElementReferenceException e){
	 List<WebElement> listElet =driver.findElements(By.xpath("//ul[@class='dropdown-menu show']//li"));
	    
	       }
	  
	    }  
	

	@Test
	public void num() {
		  System.setProperty("webdriver.chrome.driver", "jar\\chromedriver.exe");
			      WebDriver driver = new ChromeDriver();
			      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			      driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
			      // identify element
			    WebElement weEle = driver.findElement(By.xpath("//span[text()='UPSC Notes']"));
			      Point weLoc   =weEle.getLocation();
			           org.openqa.selenium.Rectangle  weRec = weEle.getRect();
				     System.out.println(weRec.getHeight());
				     System.out.println(weRec.getWidth());
			   }
	Properties propObj;
	public void load_Config(String fileName) {
		propObj= new Properties();
		
	}
	
	
}
