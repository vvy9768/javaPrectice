package com.evs.qacodes.pages.login;
import org.openqa.selenium.By;
import com.evs.qacodes.pages.base.BasePage;

public class FbLogin extends BasePage {


	
	
	
	private By Username_Box=By.cssSelector("input[id='email']");

	private By Password_Box=By.cssSelector("input[id='pass']");
	
	public By login_BT=By.xpath("//button[@name='login']//parent::div");
	
	

	public void verifyfacebookloginWithValidCredintial() {

		wb.sendkeys(Username_Box,"7390871506");
		wb.sendkeys(Password_Box, "chakgosai@123");
		wb.click(login_BT, "login_BT");
		
	
	}

	
	
	public void verifyfacebookloginWithInValidCredintial() {

		wb.sendkeys(Username_Box,"7355106135");
		wb.sendkeys(Password_Box, "roshanyadav12");
		wb.click(login_BT, "login_BT");
		
	
	}
	

	
}