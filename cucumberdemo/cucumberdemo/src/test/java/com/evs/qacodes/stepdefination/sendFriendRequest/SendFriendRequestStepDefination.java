package com.evs.qacodes.stepdefination.sendFriendRequest;

import com.evs.qacodes.pages.SendFrndRequest.SendFrndRequest;
import com.evs.qacodes.pages.homepage.FbHome;
import com.evs.qacodes.pages.login.FbLogin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendFriendRequestStepDefination {

	
	
	
	@Given("On Home Page have search Box Click on it")
	public void on_Home_Page_have_search_Box_Click_on_it() {
		new FbLogin().verifyfacebookloginWithValidCredintial();
		new FbHome().clickOnSearchButton();
	}
	
	
	@When("Search People or Place {string} and Click on Search button then Click on result")
	public void search_People_or_Place_and_Click_on_Search_button_then_Click_on_result(String SearchName) {
		new FbHome().searchFreinds_Place(SearchName);
	}

	@Then("Click on people Bt")
	public void click_on_people_Bt() {
		new SendFrndRequest().clickOnPeopleBt();;
	}

	@And("Click on send friend request button")
	public void click_on_send_friend_request_button() {
		new SendFrndRequest().sendfriendRequest();
	}
	
	
	
}
