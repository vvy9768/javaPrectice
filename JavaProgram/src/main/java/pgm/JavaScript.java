package pgm;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JavaScript {
   @Test
	public void init() {
	   
	   
		System.setProperty("webdriver.chrome.driver", "jar//chromedriver.exe");
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();  
		   capabilities.setCapability("marionette",true); 
		WebDriver driver= new ChromeDriver(capabilities);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//driver.manage().window().maximize();
		driver.navigate().to("https://www.javatpoint.com/selenium-webdriver-handling-alerts");
		driver.manage().deleteAllCookies();
		//driver.navigate().to("https://www.browserstack.com/users");
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 WebDriverWait wait= new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(null));
		

		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
