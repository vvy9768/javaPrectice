package com.meveric.loginPage;


import java.lang.reflect.Method;

import com.maveric.base.BasePage;


public class LogInPage extends BasePage {

	
	public void varifyClickOnTodays_DealsOnAmazon(Method mathName) {
  gm.varify_the_Enable("xpath","(//div[@class='nav-fill']/div[@id='nav-xshop-container']//a)[1]",mathName);
	gm.click("xpath", "(//div[@class='nav-fill']/div[@id='nav-xshop-container']//a)[1]");
	}

}
