package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {
	
	
	 
	public static String captureScreenshot(WebDriver driver, String screenshotName)
	{
		try {
			TakesScreenshot screens = (TakesScreenshot) driver;
			File source = screens.getScreenshotAs(OutputType.FILE);
	
			String destFilePath = "C:\\Users\\pattargv\\eclipse-workspace\\ReportDemo\\Screenshots\\"+screenshotName+".png";	
			
			File destination = new File(destFilePath);
			FileUtils.copyFile(source, destination);
			
			return destFilePath;
			
		} catch (Exception e) {
			
			 return e.getMessage();
		} 
	
	
	}
	
}
