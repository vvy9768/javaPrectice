package classes; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Gluecode {
 WebDriver driver;
 String exTitle="null";
	@Given("url on google go to home page")
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "jar/chromedriver.exe");
		        driver = new ChromeDriver();
		     driver.get("htt://www.google.com");
	}
	@When("come to home page")
	public void homePage() {
		String actTitle=driver.getTitle();
		if(actTitle.equalsIgnoreCase(exTitle)) {
			System.out.println("Home page open sucessfully");
		}else {
			System.out.println("Home page Not  open sucessfully");
		}
		
	}
	@Then("get title of home page")
	public void grtTitle() {
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@When ("close te browser")
	public void closeBrowser() {
		driver.close();
	}
}
