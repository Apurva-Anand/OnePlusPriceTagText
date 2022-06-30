package AmazonUtilPack;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class UtilsClass {

	WebDriver driver;

	public void tearDown(WebDriver driver, ITestResult results) {
		Date d1 = new Date();
		String date = d1.toString();
		date = date.replaceAll(":", "_");
		String name = "SS_";
		if(ITestResult.FAILURE == results.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screen = ts.getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(screen, new File("C://Users//Apurv//Desktop//"+name+date+".jpg"));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
