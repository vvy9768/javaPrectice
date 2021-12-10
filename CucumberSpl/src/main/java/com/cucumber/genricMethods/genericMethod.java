package com.cucumber.genricMethods;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



public class genericMethod {

	
	
private WebDriver driver;
public WebDriver getDriver() {
	return driver;
}

//================constructor ================//
private genericMethod() {
	
}
// ===================== Singleton ======================//
public static genericMethod gm=null;
public static genericMethod getObj() {
	if(gm==null) {
		gm=new genericMethod();
	}	
	return gm;
}
//===================WebDriver methods ====================//
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "BrowserJars/chromedriver.exe");
		   driver = new ChromeDriver();
		   }
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	private WebElement we;
	public WebElement getElement(String locator,String path) {
		if(locator.equalsIgnoreCase("xpath")) {	
	 we	=driver.findElement(By.xpath(path));
	}else if(locator.equalsIgnoreCase("id")){
		we=driver.findElement(By.id(path));
	}else if(locator.equalsIgnoreCase("name")){
		we=driver.findElement(By.name(path));
	}else if(locator.equalsIgnoreCase("id")){
		we=driver.findElement(By.tagName(path));
	}else if(locator.equalsIgnoreCase("tageName")){
		we=driver.findElement(By.id(path));
	}
		return we;
	}
	public void sendKeys(WebElement we, String input) {
		we.clear();
        we.sendKeys(input);
	}
	public void  we_click(WebElement we) {
		we.click();
	}
	public void  implicitlyWait(int time ) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	private WebDriverWait wait ;
	public WebDriverWait explicitlyWait(WebDriver driver, int time) {
		 wait = new WebDriverWait(driver,time);
		return wait;
	}
	public void exp_Visibility_wait(WebElement we,int  time  ) {
		 wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void takeScreenShot(String name) {
		  TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File from =scrShot.getScreenshotAs(OutputType.FILE);
		 File to = new File("target//"+name);
		 try {
			Files.copy(from, to);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	//=====================Select Class ==================//
	
	private Select slc;
	public void selectByValue(WebElement we, String value) {
		this.we=we;
		slc=new Select(we);
		slc.selectByValue(value);
	}
	public void selectByIndex(WebElement we, int index) {
		this.we=we;
		slc=new Select(we);
		slc.selectByIndex(index);
	}
	public void selectByVisibleText(WebElement we, String valvisibleTextue ) {
		this.we=we;
		slc=new Select(we);
		slc.selectByVisibleText(valvisibleTextue);
	}
	public WebElement getFirstSelectedOption() {
		slc=new Select(we);
		we=slc.getFirstSelectedOption();
		return we;
	}
	public List<WebElement> getAllSelectedOption() {
		slc=new Select(we);
		List<WebElement> listWe=slc.getAllSelectedOptions();
		return listWe;
	}
	
	public List<WebElement>  getOptions() {
		slc=new Select(we);
		List<WebElement> listWe=slc.getOptions();
		return listWe;
	}
	//=====================Actions class ===============================//
	private Actions act;
	public Actions act_click(WebDriver driver, WebElement we) {
		act= new Actions(driver);
		act=act.click(we);
		return act;
	}
	public Actions act_SendKeys(WebDriver driver,WebElement we, String input) {	
		act= new Actions(driver);
		act=act.sendKeys(we, input);
		return act;
	}
	public Actions click_And_Hold(WebDriver driver, WebElement we) {	
		act= new Actions(driver);
		act=act.clickAndHold(we);
		return act;
	}
	public void toPerform(WebDriver driver, WebElement we) {
		act= new Actions(driver);
		act.build().perform();
	}
	public void release(WebDriver driver, WebElement we) {
		act= new Actions(driver);
		act.release(we);
	}
}
