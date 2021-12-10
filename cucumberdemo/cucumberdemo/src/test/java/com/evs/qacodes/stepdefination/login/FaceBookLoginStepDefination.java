package com.evs.qacodes.stepdefination.login;




import com.evs.qacodes.pages.login.FbLogin;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FaceBookLoginStepDefination  {

	
		
	
	@When("user enters right username  and right password  and click on login button")
	public void user_enters_right_username_and_right_password_and_click_on_login_button() {
		FbLogin fblog=	new FbLogin();
		fblog.verifyfacebookloginWithValidCredintial();;
	
	}
	@Then("Home button Should be Displyed on Home Page")
	public void home_button_Should_be_Displyed_on_Home_Page() {
		FbLogin fblog=	new FbLogin();
		fblog.wb.verifyElement_IsVisible(fblog.HomeBT, "facebookHome Button");

	}

	@When("user enters wrong username  and wrong password  and click on login button")
	public void user_enters_wrong_username_and_wrong_password_and_click_on_login_button() {
		FbLogin fblog=	new FbLogin();
		fblog.verifyfacebookloginWithInValidCredintial();;
	
	} 
	@Then("Home button Should'nt be Displyed on Home Page")
	public void home_button_Should_nt_be_Displyed_on_Home_Page() {
		FbLogin fblog=	new FbLogin();
		fblog.wb.verifyElement_InIsVisible(fblog.HomeBT, "facebookHome Button");
	}
	
	
	
}
