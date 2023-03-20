package kgisl.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kgisl.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}  
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	//.ng-tns-c4-14.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	//By error = By.cssSelector("[class*='flyInOut']");
	

	public void goToUrl() {
		driver.get("https://www.rahulshettyacademy.com/client/");
	}
	
	public String GetErrorMessage() {
		WaitToWebElementVisible(errorMessage);
		String errMsg = errorMessage.getText();
		System.out.println(errMsg);
		return errMsg;
	}
	
	public ProductPage loginApplication(String Email , String pass) {
		userEmail.sendKeys(Email);
		password.sendKeys(pass);
		submit.click();
		return new ProductPage(driver);
	}

}
