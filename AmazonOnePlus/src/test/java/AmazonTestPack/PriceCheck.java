package AmazonTestPack;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AmazonUtilPack.Drivers;
import AmazonUtilPack.POMs;
import AmazonUtilPack.UtilsClass;
import junit.framework.Assert;

public class PriceCheck {

	WebDriver driver;
	String url = "https://www.amazon.in/";
	String expPrice = "24,999";
	Drivers driversObj = new Drivers();
	UtilsClass utilObj = new UtilsClass();
	POMs pomObj = new POMs();
	
	@BeforeTest
	public void browserOpens() {
		driver = driversObj.opening(url); //Loading amazon page in chrome browser.
		
	}
	@AfterTest
	public void browserClose() {
		driversObj.closing(); //closing browser.
	}
	@Test
	public void priceCheck() {
		pomObj.clickOnMobile(driver); //clicking on mobile section on the home page of amazon.
		pomObj.checkBoxSelection(driver); //clicking on the checkbox of the oneplus brand in mobile page
		String currentWin = driver.getWindowHandle(); // getting the handle of current window.
		pomObj.clickOnMobileName(driver); // clicking on the OnePlus mobile, which will open in a new window.
		Set<String> allWin = driver.getWindowHandles(); //getting handles of all the windows.
		for(String s:allWin) {
			if(!s.equals(currentWin)) {
				driver.switchTo().window(s); //switching to the oneplus mobile window.
			}
		}
		String actPrice = pomObj.getPrice(driver); //getting price from the website.
		System.out.println("Price:  "+actPrice);
		if (actPrice.contains(expPrice)) { //checking if the price is as expected.
			System.out.println("Price Matched");
		}
		Assert.assertEquals(true, false); //willingly making test case to fail, to take screenshot.
	}
	
	@AfterMethod
	public void tearingDown( ITestResult result) {
		utilObj.tearDown(driver, result); //getting screenshot if method fails.
	}
	
}
