package Report;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import library.Utility;

public class VerifyTitlePage {
	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	
	
	@SuppressWarnings("null")
	@Test
	public void VerifyPageTitle() {
		
		
		// initialize the HtmlReporter
		//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Automation\\Reports\\FirstReport.html");
		
		// initialize ExtentReports and attach the HtmlReporter
		// ExtentReports logger = ExtentReports.get(VerifyTitlePage.class);
		//htmlReporter.getClass();
		//htmlReporter.start();
		
		//htmlReporter.flush();
		
		report = new ExtentReports("C:\\Users\\pattargv\\eclipse-workspace\\ReportDemo\\src\\Report\\VerifyPageTitle.html");
				
		logger =  report.startTest("VerifyPageTitle");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");

		driver = new FirefoxDriver();
		
		logger.log(LogStatus.INFO, "Browser Started");
		
		driver.manage().window().maximize();
		//htmlReporter.log
		
		
		driver.get("http://learn-automation.com");
		
		logger.log(LogStatus.INFO, "Application up and running");
		
		String title = driver.getTitle();
		
		Assert.assertTrue(title.contains("Selenium"));
		
		//Utility.captureScreenshot(driver,"SeleniumTitle");
		
		logger.log(LogStatus.PASS, "Title Verified");
		
		ITestResult result = null;
		
	//}
	
	//@AfterMethod
	//public void tearDown(ITestResult result)
	//{
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		if(ITestResult.FAILURE == result.getStatus())
		{
			String screenshotPath = Utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshotPath);
			logger.log(LogStatus.FAIL, "Title Verification Failed", image);
		}
		report.endTest(logger);
		report.flush();
		
		driver.get("C:\\Users\\pattargv\\eclipse-workspace\\ReportDemo\\src\\Report\\VerifyPageTitle.html");
	}
	
	

}
