package kgisl.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kgisl.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}  
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement actualCountry;
	
	@FindBy(css=".actions a")
	WebElement placeOrder;
	
	By listofCountries = By.cssSelector(".ta-results");
	By button = By.cssSelector(".actions a");

	public void gotoConfirmOrder() throws InterruptedException {
		
		Actions act = new Actions(driver);
		
		act.sendKeys(selectCountry, "ind").build().perform();
		WaitToVisible(listofCountries);
		actualCountry.click();
		
				
	}
	
	public FinalConformationPage placeOrder() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 500)");
		
		Thread.sleep(500);
		
		placeOrder.click();
		
		return new FinalConformationPage(driver);
	}

	
	
	
	

	
	
	

}
