package com.evs.qacodes.webutil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class WebUtil {

	public static final Logger logger = Logger.getLogger(WebUtil.class);

	private WebDriver driver;
	
	private static Properties propObj;

	public WebDriver getdriver() {
		return driver;
	}

	private WebUtil() {

	}

	private static WebUtil wb;

	public static WebUtil getObject() {
		if (wb == null) {
			wb = new WebUtil();
		}
		return wb;
	}

	public WebElement getElement(By element) {
		return driver.findElement(element);
	}

	public List<WebElement> getElements(By element) {
		return driver.findElements(element);
	}

	public void launchBrowser(String browsername, String url) {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
			// options.addArguments("headless");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.addArguments("disable-popup-blocking");
			options.addArguments("incognito");
			driver = new ChromeDriver(options);

			logger.info("Chrome Browser has been launched successfully");
		}
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

	}

	public WebElement findelement(WebElement element, String locator, String path) {
		if (locator.equalsIgnoreCase("xpath")) {
			element.findElement(By.xpath(path));
		} else if (locator.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(path));
		} else if (locator.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(path));
		} else if (locator.equalsIgnoreCase("linktext")) {
			element = driver.findElement(By.linkText(path));
		} else if (locator.equalsIgnoreCase("Partiallinktext")) {
			element = driver.findElement(By.partialLinkText(path));
		} else if (locator.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(path));
		}

		return element;

	}

	public List<WebElement> findelements(List<WebElement> element, String locator, String path) {
		List<WebElement> elements = null;

		if (locator.equalsIgnoreCase("xpath")) {
			element = driver.findElements(By.xpath(path));
		} else if (locator.equalsIgnoreCase("id")) {
			element = driver.findElements(By.id(path));
		} else if (locator.equalsIgnoreCase("class")) {
			element = driver.findElements(By.className(path));
		} else if (locator.equalsIgnoreCase("linktext")) {
			element = driver.findElements(By.linkText(path));
		} else if (locator.equalsIgnoreCase("Partiallinktext")) {
			element = driver.findElements(By.partialLinkText(path));
		} else if (locator.equalsIgnoreCase("name")) {
			element = driver.findElements(By.name(path));
		}

		return elements;

	}

	public void sendkeys(By element, String value) {
		getElement(element).clear();
		getElement(element).sendKeys(value);
		;

	}

	public void sendkeys(By element, Keys keyname) {
		getElement(element).clear();
		getElement(element).sendKeys(keyname);

	}

	public void click(By element, String Elementname) {

		try {
			getElement(element).click();
			logger.info("clicked on" + Elementname + "is succesfully");

		} catch (ElementClickInterceptedException e) {
			logger.error("ElementClickInterceptedException throwing on" + Elementname);
			jsClick(element);

		} catch (StaleElementReferenceException e) {

			getElement(element).click();
			// extentLogger.log(Status.INFO, "click performed successfully on " +
			// element.toString());

		} catch (ElementNotVisibleException e) {
			// extentLogger.log(Status.ERROR, "ElementNotVisibleException exeception
			// throwing on " + Elementname+"click action is trying");
			jsClick(element);

		}
	}

	public void click(WebElement element, String Elementname) {

		try {
			element.click();
			logger.info("clicked on" + Elementname + "is succesfully");

		} catch (ElementClickInterceptedException e) {
			logger.error("ElementClickInterceptedException throwing on" + Elementname);

			jsClick(element);

		} catch (StaleElementReferenceException e) {

			element.click();

		} catch (ElementNotVisibleException e) {

			jsClick(element);

		}
	}

	public String getText(By element) {
		String text = getElement(element).getText();
		return text;
	}

	public String getAttributeValue(By element, String Attribute) {
		getElement(element).getAttribute(Attribute);
		return Attribute;
	}

	public void actClick(By element) {
		Actions act = new Actions(getdriver());
		act.click(getElement(element)).build().perform();

	}

	public void actClickAndHold(By element) {
		Actions act = new Actions(getdriver());
		act.clickAndHold(getElement(element)).build().perform();

	}

	public void actDragAndDrop(By element, By target) {
		Actions act = new Actions(getdriver());
		act.dragAndDrop(getElement(element), getElement(target)).build().perform();

	}

	public void actDoubleClick(By element) {
		Actions act = new Actions(getdriver());
		act.doubleClick(getElement(element)).build().perform();

	}

	public void mouseHover(By element) {
		Actions act = new Actions(getdriver());
		act.moveToElement(getElement(element)).build().perform();

	}

	public void actSendKeys(By element, String value) {
		Actions act = new Actions(getdriver());
		act.sendKeys(getElement(element), value).build().perform();

	}

	public void windowHandles(String titles) {
		Set<String> wndw = driver.getWindowHandles();
		for (String window : wndw) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase(titles)) {
				break;
			}
		}
	}

	public void windowHandleOpenone(String titles) {
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

	public void selectByIndex(By element, int indexnumber, String ElementName) {
		Select se = new Select(getElement(element));
		se.selectByIndex(indexnumber);

	}

	public void selectByValue(By element, String value, String ElementName) {
		Select se = new Select(getElement(element));
		se.selectByValue(value);

	}

	public void selectByVisibleText(By element, String text, String ElementName) {
		Select se = new Select(getElement(element));
		se.selectByVisibleText(text);

	}

	public void deselectAll(By element, String ElementName) {
		Select se = new Select(getElement(element));
		se.deselectAll();

	}

	public void deselectByIndex(By element, int indexnumber, String ElementName) {
		Select se = new Select(getElement(element));
		se.deselectByIndex(indexnumber);

	}

	public void deselectByValue(By element, String value, String ElementName) {
		Select se = new Select(getElement(element));
		se.deselectByValue(value);

	}

	public void deselectByVisibleText(By element, String value, String ElementName) {
		Select se = new Select(getElement(element));
		se.deselectByVisibleText(value);
	}

	public WebDriver frameByNumber(int number) {
		driver.switchTo().frame(number);
		return driver;
	}

	public WebDriver frameByElement(By element) {
		driver.switchTo().frame(getElement(element));
		return driver;
	}

	public WebDriver frameByString(String value) {
		driver.switchTo().frame(value);
		return driver;
	}
	// -----------------------------------ScreenShot-----------------------\\

	public String takeSnapshot(String methodname) {
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

	public void takesnapShotsOfElement(By element) {

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
		Point point = getElement(element).getLocation();

		// Get width and height of the element
		int eleWidth = getElement(element).getSize().getWidth();
		int eleHeight = getElement(element).getSize().getHeight();

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

	public void verifyText(By element, String expectedText, String elementname) {
		String actualText = getElement(element).getText();
		Assert.assertEquals(actualText, expectedText);

	}

	public void verifyAttributeValue(By element, String Atttributename, String expectedvalue, String elementname) {
		String actualValue = getElement(element).getAttribute(Atttributename);
		Assert.assertEquals(actualValue, expectedvalue);

	}

	public void verifyElement_IsVisible(By element, String elementname) {
		boolean actual = getElement(element).isDisplayed();
		Assert.assertEquals(actual, true);

	}

	public void verifyElement_InIsVisible(By element, String elementname) {
		boolean actual = getElement(element).isDisplayed();
		Assert.assertEquals(actual, true);

	}

	public void verifyElement_IsEnable(By element, String elementname) {
		boolean actual = getElement(element).isEnabled();
		Assert.assertEquals(actual, true);

	}

	public void verifyElement_IsSelected(By element, String elementname) {
		boolean actual = getElement(element).isSelected();
		Assert.assertEquals(actual, true);

	}

	// -----------------------Config File------------------------------------\\

	public String getPropVal(String keyname) {
		if (propObj == null) {
			load_config(Filename);
		}

		String propVal = propObj.getProperty(keyname);
		return propVal;
	}

	public void setProp(String key, String value) {
		if (propObj == null) {
			load_config(Filename);
		}
		propObj.setProperty(key, value);
	}

	String Filename;

	public void load_config(String Filename) {
		this.Filename = Filename;
		propObj = new Properties();
		File fle = new File(Filename);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fle);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			propObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ----- Upload files with the help of Robot class----------\\

	public void uploadFiles_RobotClass(String FilePath) {
		StringSelection ss = new StringSelection(getTestData(FilePath));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// --------------------------------- test casee wisw
	// Excel-------------------------------\\
	private Map<String, String> testCaseDataMap;

	public void setTestCaseDataMap(Map<String, String> testCaseData) {

		testCaseDataMap = testCaseData;
	}

	public String getTestData(String dataName) {

		return testCaseDataMap.get(dataName);
	}

	public Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();

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

	public void refreshPage() {
		driver.navigate().refresh();
	}

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

}
