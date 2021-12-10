package com.evs.qacodes.pages.base;



import org.openqa.selenium.By;

import com.evs.qacodes.webutil.WebUtil;




public class BasePage {
	
	public WebUtil wb=WebUtil.getObject();
	
	public By LogOut_Bt=By.xpath("//span[text()='Log Out']");
	public By HomeBT=By.xpath("//a[@aria-label='Home']");
	public By AccountDrpdown=By.xpath("//div[@aria-label='Account']");
	public By clickOnProfile=By.xpath("//div[@aria-label='Account']//span");
	public By AddCommentInPost=By.xpath("//div[@aria-label='Write a comment']//p");

	
	
	public void VisitOnMyProfilePage() {
		wb.click(AccountDrpdown, "navigate profile bt");
		wb.HoldOn(3000);
		wb.click(clickOnProfile, "click on profile name ");
		
	}
	public void LogOut() {
		
		wb.click(AccountDrpdown, "naviagteToAccountDrpdown");
		wb.HoldOn(4000);
		wb.click(LogOut_Bt, "Click On Log Out Button");
	}
	
	public void navigateToHome() {
		wb.click(HomeBT, "click on home Bt");
	}
	
	
	
	
	
}
	