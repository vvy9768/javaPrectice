package com.maveric.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.maveric.genericMethod.GenericMethod;

public class TestBasePage {
	protected GenericMethod gm;
	@BeforeMethod
	public void intilisation() {
		gm= GenericMethod.getObj();
		gm.launchBrowser("chrome", "https://www.linkedin.com/");
		gm.getdriver().manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		}
	
	
	@AfterMethod
	public void shut_browser(Method method) {
		
	//	gm.getdriver().close();
	}
	
}
