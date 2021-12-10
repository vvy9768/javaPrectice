package com.flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.genricMethods.genericMethod;



public class flipkart_logIn  {

	WebDriver driver=genericMethod.getObj().getDriver();


	
public void  loginToFlipkart() throws InterruptedException {
	
	   driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("9768317488");
	    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3NgS1a']")).click();
		Thread.sleep(8000);	
			}

	public void cancelLogIn() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
       
	}
	
}
