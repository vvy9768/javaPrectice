package com.maveric.base;

import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.maveric.genericMethod.GenericMethod;

public class TestBasePage {
	protected GenericMethod gm;
	@BeforeMethod
	public void intilisation() {
		gm= GenericMethod.getObj();
		
		gm.launchBrowser("chrome", "http://www.amazon.com");
	}
	
	
	@AfterMethod
	public void shut_browser(Method method) {
		
		gm.getdriver().close();
	}
}
