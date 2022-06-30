package AmazonUtilPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMs {

	WebDriver driver;
	
//	By searchBox = By.id("twotabsearchtextbox");
	By mobileSection = By.xpath("//*[@id='nav-xshop']/a[text()='Mobiles']");
//	By OnePlus = By.xpath("//*[@id='s-refinements']//*[text()='OnePlus']");
	By checkboxID = By.xpath("//*[@id='s-refinements']//*[text()='OnePlus']//preceding-sibling::*");
	By mobileName = By.xpath("//*[text()='OnePlus Nord CE 2 5G (Gray Mirror, 8GB RAM, 128GB Storage)']");
	By mobilePrice = By.xpath("//*[@id='corePrice_desktop']//following::span[@class='a-price a-text-price a-size-medium apexPriceToPay']/span[@class='a-offscreen']//following-sibling::*");
	
	public void clickOnMobile( WebDriver driver) {
		driver.findElement(mobileSection).click();
	}
	public void checkBoxSelection(WebDriver driver) {
		driver.findElement(checkboxID).click();
	}
	public void clickOnMobileName(WebDriver driver) {
		driver.findElement(mobileName).click();
	}
	public String getPrice(WebDriver driver) {
		String actPrice = driver.findElement(mobilePrice).getText();
		return actPrice;
	}
	
}
