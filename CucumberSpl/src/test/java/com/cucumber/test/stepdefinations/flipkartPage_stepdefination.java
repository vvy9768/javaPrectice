package com.cucumber.test.stepdefinations;


import com.flipkart.Pages.SearchPage;
import com.flipkart.Pages.flipkart_logIn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class flipkartPage_stepdefination {
	

	@When("launch the Flipkart website")
	public void launchBrowser_and_go_to_flipkart() throws InterruptedException {
		
	}
	@Then("cancel the login and go on search")
	public void Cancel_the_logIn() throws InterruptedException {
		flipkart_logIn logIn	= new flipkart_logIn();
	     logIn.cancelLogIn();    
	}
	
	@And("search for a shoes")
	public void search_one_shose() throws InterruptedException {
		SearchPage src=new SearchPage();
	      src.search_On_Search_tab();  
	}
	@Then("close the browser")
	public void  shut_up_Browser(){
		
	}
	@Then("No.of Product on the Particular Searchpage")
	public void no_of_product_on_particalar_page() throws InterruptedException {
		SearchPage src=new SearchPage();
		src.No_of_product_on_page();
		src.add_one_productTo_cart();
	}
	
	
	}

	
	
	
	
	

