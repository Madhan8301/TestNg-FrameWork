package kgisl.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kgisl.AbstractComponents.AbstractComponent;

public class FinalConformationPage extends AbstractComponent{
	
	WebDriver driver;
	
	public FinalConformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}  
	
	@FindBy(css=".hero-primary")
	WebElement message;
	
	
	By ele = By.cssSelector(".hero-primary");

	public String ConformationMessage() {
		WaitToVisible(ele);
		String ConformationMessage = message.getText();
		return ConformationMessage;
	}
	
	

}
