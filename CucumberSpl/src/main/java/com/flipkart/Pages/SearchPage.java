package com.flipkart.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.genricMethods.genericMethod;

public class SearchPage {
	WebDriver driver=genericMethod.getObj().getDriver();
	
	private  By we_Search=By.xpath("//input[@placeholder='Search for products, brands and more']");
	
	private  By we_click_on_tab=By.xpath("//button[@class='L0Z3Pu']");

	private  By we_prodcs=By.xpath("//div[@class='_13oc-S']/div");
	
	private By we_listOfProduct =By.xpath("//div[@class='_13oc-S']/div");
	
    private By we_addToCart=By.xpath("//button[text()='ADD TO CART']");
    
    private By shose_Size = By.xpath("//a[text()='9']");
	public void search_On_Search_tab() throws InterruptedException {
	           WebElement we=driver.findElement(we_Search);
		       we.click();
	           we.sendKeys("shoses");
	
	driver.findElement(we_click_on_tab).click();
	
	}
	
	
	
	
	
	public void No_of_product_on_page() {
		List<WebElement> listOfProduct=driver.findElements(we_prodcs);
		int sze=listOfProduct.size();
		System.out.println(" SIZE =    "+sze);
		
	}
	
	public void add_one_productTo_cart() throws InterruptedException {
		List<WebElement> listOfProduct=driver.findElements(we_listOfProduct);
		WebElement we=listOfProduct.get(1);
		we.click();
		  Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,400)");
		driver.findElement(shose_Size).click();
		try {	
			WebElement tab_click=driver.findElement(we_addToCart);
			tab_click.click();
		}
		catch (NoSuchElementException e) {
			
			WebElement tab_click=driver.findElement(we_addToCart);
		
			js.executeScript("scroll(0,400)");
	        Thread.sleep(5000);
			tab_click.click();
			
			
		}
	}
	
}
