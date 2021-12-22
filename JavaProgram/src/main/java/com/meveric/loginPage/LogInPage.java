package com.meveric.loginPage;


import java.lang.reflect.Method;

import com.maveric.base.BasePage;
import com.maveric.genericMethod.GenericMethod;


public class LogInPage extends BasePage {
	GenericMethod gm;
public LogInPage () {
	
}
	
	

	
	public void userName_In(String username) {
		gm.varify_the_Enable("xpath", "//input[@id='session_key']","UserInput Box");
		gm.sendKeys("xpath", "//input[@id='session_key']", username);
	}
	
	
	public void passWord_In(String password) {
		gm.varify_the_Enable("xpath", "//input[@id='session_password']","Password input box");
		gm.sendKeys("xpath", "//input[@id='session_password']", password);
		
	}
	public void clickOn_signIn_Bt() {
		gm.click("xpath", "//button[@class='sign-in-form__submit-button']");
		}
}
