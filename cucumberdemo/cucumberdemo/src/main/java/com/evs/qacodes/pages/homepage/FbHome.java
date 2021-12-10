package com.evs.qacodes.pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.evs.qacodes.pages.base.BasePage;

public class FbHome extends BasePage {

	
	private By Search_Box = By.xpath("//input[@type='search']");
	private By friendsBt = By.xpath("//a[@aria-label='Friends']");
	private By videosBt = By.xpath("//a[@aria-label='Watch']");
	private By MarketplaceBt = By.xpath("//a[@aria-label='Marketplace']");

	public void navigateToVideos() {
		wb.click(videosBt, "click on videos Bt");
	}

	public void navigateToFriends() {
		wb.click(friendsBt, "click on friends button");
	}

	public void navigetToMarketplace() {
		wb.click(MarketplaceBt, "click on Marketplace");
	}

	public void clickOnSearchButton() {
		wb.actClick(Search_Box);
	}

	public void searchFreinds_Place(String SearchName) {
		wb.sendkeys(Search_Box, SearchName);
		wb.sendkeys(Search_Box, Keys.ENTER);
		
	}
}