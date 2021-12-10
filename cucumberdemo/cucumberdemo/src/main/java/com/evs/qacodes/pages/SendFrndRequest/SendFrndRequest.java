package com.evs.qacodes.pages.SendFrndRequest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.evs.qacodes.pages.base.BasePage;

public class SendFrndRequest extends BasePage {



	protected By people_Bt = By.xpath("//span[text()='People']");
	protected By Addfriend_BT = By.xpath("//div[@aria-label='Add Friend' or @aria-label='Add friend']");

	public void clickOnPeopleBt() {
		wb.actClick(people_Bt);
	}

	public void sendfriendRequest() {
		wb.HoldOn(4000);
		wb.jsScrollDown(450);
		List<WebElement> list = wb.getElements(Addfriend_BT);
		for (int i = 0; i < list.size(); i++) {
			WebElement addfrnd = list.get(i);
			wb.HoldOn(3000);
			wb.click(addfrnd, "click on add  friends button");
		}
	}
}
