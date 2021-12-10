package com.cucumber.page.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.cucumber.genricMethods.genericMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BasePage {
	
public WebDriver driver;

	
protected genericMethod gm;


@Before
	public void intilization() {
		gm= genericMethod.getObj();
		gm.launchBrowser();
		gm.getDriver().get("https://www.flipkart.com/");
		gm.getDriver().manage().window().maximize();
		gm.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	


	@After
	public void ShutUp() {
		
		//gm.takeScreenShot("scr.flp");
       gm.getDriver().close();
	}
	
}
