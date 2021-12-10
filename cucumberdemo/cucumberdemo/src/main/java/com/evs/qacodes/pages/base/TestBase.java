package com.evs.qacodes.pages.base;

import java.util.logging.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.evs.qacodes.webutil.WebUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {

	 WebUtil wb =  WebUtil.getObject();

	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest extentLogger;
	private static ExtentReports extent;

	public void setExtentLogger(String TestCaseName) {
		extentLogger = extent.createTest(TestCaseName);
	}

	public ExtentTest getExtentLogger() {
		return extentLogger;
	}


	@Before
	public void user_is_on_Login_Page() {
		
	
			// specify location of the report
			htmlReporter = new ExtentHtmlReporter("driver/"  +"roshan"+ ".html");
			htmlReporter.getStartTime();

			htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report

			htmlReporter.config().setReportName("Functional Testing"); // Name of the report
			htmlReporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			// Passing General information
			extent.setSystemInfo("Host name", "localhost");
			extent.setSystemInfo("Environemnt", "QA");
			extent.setSystemInfo("user", "Roshan");
		

		
		
		
		wb.load_config("src/test/resources/config.properties");
		logger.info("BeforeMethod Has been started");
		wb.launchBrowser(wb.getPropVal("browser"), wb.getPropVal("urls"));
		logger.info("BeforeMethod Has been ended");
	}

	@After()
	public void afterMethod() {

		wb.getdriver().close();
		extent.flush();

	}

}
