package AmazonUtilPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {

	WebDriver driver;
	
	public WebDriver opening(String url) {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void closing() {
		driver.quit();
	}
	
}
