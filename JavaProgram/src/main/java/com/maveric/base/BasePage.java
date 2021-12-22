package com.maveric.base;

import com.maveric.genericMethod.GenericMethod;

public class BasePage {
	protected GenericMethod gm;
	public  BasePage() {
		gm=GenericMethod.getObj();
	}
	   
	public void clickOn_signOut_Bt() {
		gm.click("xpath", "//a[contains(text(),'SignOut')]");
		}
}
