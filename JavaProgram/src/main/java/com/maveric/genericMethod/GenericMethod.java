package com.maveric.genericMethod;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class GenericMethod {
  private WebDriver driver;
 ////======================constructor====================//
	private GenericMethod() {	
	}
	
	//===========getObj===========================//
	private static GenericMethod gm;
	public static GenericMethod getObj() {
		if(gm==null) {
		gm= new GenericMethod();
		}
		return gm;
	}
	//=================getDriver ==================//SSS
	  public WebDriver getdriver() {
			return driver;
	    
		}
	
	public void launchBrowser(String browserName,String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "jar\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
	    }else if(browserName.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", "jar\\grckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(url);
	}
}
	WebElement we;
	public WebElement getElement(String pathName,String path) {
		if(pathName.equalsIgnoreCase("xpath")) {
		   we=driver.findElement(By.xpath(path));
		}else if(pathName.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(path));
			
		}else if(pathName.equalsIgnoreCase("id")) {
			we=driver.findElement(By.id(path));
			
		}else if(pathName.equalsIgnoreCase("text")) {
			we=driver.findElement(By.linkText(path));
			
		}else if(pathName.equalsIgnoreCase("name")) {
			we=driver.findElement(By.name(path));
			
		}else if(pathName.equalsIgnoreCase("tgName")) {
			we=driver.findElement(By.tagName(path));
			
		}else if(pathName.equalsIgnoreCase("className")) {
			we=driver.findElement(By.className(path));
		}
		return we;
	}
	
	public void varify_the_Visibility(WebElement element) {
       boolean Actualstatus = element.isDisplayed();
         Assert.assertEquals(Actualstatus, true);
        //===============softAssert========================//
         new SoftAssert().assertEquals(Actualstatus, false);
         
	}
	public void varify_the_Enable(String pathName, String path,String mth ) {
		
	       boolean Actualstatus = getElement(pathName, path).isEnabled();
	    
	         Assert.assertEquals(Actualstatus, true);
	         if(Actualstatus)
	       System.out.println(mth+" is Enabled ");
	         else 
	        	System.out.println(mth+" is disabled"); 
	         
		}
	
	
	public void varify_the_Selected(String pathName, String path , String mth) {
	       boolean Actualstatus = getElement(pathName, path).isSelected();
	         Assert.assertEquals(Actualstatus, true);
	         if(Actualstatus)
	  	       System.out.println(mth+" is Selected ");
	  	         else 
	  	        	System.out.println(mth+" is Unselected"); 
	  	         
		}
	
	public void sendKeys(String pathName,String path,String sendText ) {
		we=getElement(pathName, path);
		we.clear();
		we.sendKeys(sendText);
	}
	public void click(String pathName,String path) {
		getElement(pathName, path).click();;
	}
	public void getWindowHandlesByTitle(String Title) {
		Set<String>handle=driver.getWindowHandles();
		for(String element: handle) {
			driver.switchTo().window(element);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase(Title)) {
				break;
			}
		}	
	}

	public void windowHandleOnlyOne(String titles) {
		Set<String> wndw = driver.getWindowHandles();
		for (String window : wndw) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if (!title.equalsIgnoreCase(titles)) {
				driver.close();
			}
		}
	}
	public void alertAccept() {
		driver.switchTo().alert().accept();

	}

	public void alertDeny() {
		driver.switchTo().alert().dismiss();

	}
	public void selectByIndex(String pathName,String path, int indexnumber) {
		Select se = new Select(getElement(pathName, path));
		se.selectByIndex(indexnumber);

	}

	public void selectByValue(String pathName,String path, String value ) {
		Select se = new Select(getElement(pathName, path));
		se.selectByValue(value);

	}

	public void selectByVisibleText(String pathName,String path, String text) {
		Select se = new Select(getElement(pathName, path));
		se.selectByVisibleText(text);
        
	}
	public void selectAllOptions(String pathName,String path, String text) {
		Select se = new Select(getElement(pathName, path));
		List<WebElement> listWe=se.getAllSelectedOptions();
        for(WebElement list:listWe) {
        	System.out.println(list.getText());
        }
	}
	public void selectFirstSelctedOption(String pathName,String path, String text) {
		Select se = new Select(getElement(pathName, path));
		we=se.getFirstSelectedOption();
        System.out.println(we.getText());
	}
	
	public String SimpleDateTimeFormate() {
		SimpleDateFormat timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss");
		Date date = new Date();
		String dat = timestamp.format(date);
		String da = dat.replace("/", "-");
		String d = da.replace(":", "_");
		return d;
	}
	public void HoldOn(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String takeSnapshot(Method methodname) {
		SimpleDateFormat timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss");
		Date date = new Date();
		String dat = timestamp.format(date);
		String da = dat.replace("/", "-");
		String d = da.replace(":", "_");

		TakesScreenshot tcc = (TakesScreenshot) driver;
		File srcFile = tcc.getScreenshotAs(OutputType.FILE);
		File destFile = new File("Report/" + methodname + d + ".png");
		String path = destFile.getAbsolutePath();

		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	public void takesnapShotsOfElement(String locator, String xpath) {

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the location of element on the page
		Point point = getElement(locator,xpath).getLocation();

		// Get width and height of the element
		int eleWidth = getElement(locator,xpath).getSize().getWidth();
		int eleHeight = getElement(locator,xpath).getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		try {
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Copy the element screenshot to disk
		File screenshotLocation = new File("SnapShots/" + SimpleDateTimeFormate() + ".png");
		try {
			Files.copy(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void verifyText(String pathName,String path, String expectedText ) {
		String actualText = getElement(pathName,path).getText();
		Assert.assertEquals(actualText, expectedText);

	}

	public void verifyAttributeValue(String pathName,String path, String Atttributename, String expectedvalue) {
		String actualValue = getElement(pathName,path).getAttribute(Atttributename);
		Assert.assertEquals(actualValue, expectedvalue);

	}
//=================load Config===========================================//	
	
Properties propObj;	
FileInputStream fis;		
String FileName;	
	public void loadConfig(String filename) {
		this.FileName = filename;
		File fle=new File(filename);
		try {
			 fis= new FileInputStream(fle);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		propObj=new Properties();
		try {
			propObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getPropVal(String keyname) {
		if (propObj == null) {
			loadConfig(FileName);
		}

		String propVal = propObj.getProperty(keyname);
		return propVal;
	}

	public void setProp(String key, String value) {
		if (propObj == null) {
			loadConfig(FileName);
		}
		propObj.setProperty(key, value);
	}
	
	//=================javaScript=============================//
	
	public void jsClick(By element) {
		JavascriptExecutor js = (JavascriptExecutor) getdriver();
		js.executeScript("arguments[0].click()", element);

	}

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getdriver();
		js.executeScript("arguments[0].click()", element);

	}

	public void jsScrollDown(int cordinte) {
		JavascriptExecutor jse = (JavascriptExecutor) getdriver();
		jse.executeScript("window.scrollTo(0,\"" + cordinte + "\")");

	}

	public void jsScrollUp(int cordinte) {
		JavascriptExecutor jse = (JavascriptExecutor) getdriver();
		jse.executeScript("window.scrollTo(\"" + cordinte + "\",0");
	}

	public void takeSnapshots(boolean status,Method mathodName) {
		if(status==false)
			takeSnapshot(mathodName);	
	}
	
}
