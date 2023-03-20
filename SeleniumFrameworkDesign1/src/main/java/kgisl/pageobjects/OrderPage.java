package kgisl.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}  
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordernames;
	
	public Boolean VerifyOrderItems(String productName) {
		
//		Boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(productName));
//		return match;
		
		Boolean match = ordernames.stream().anyMatch(orders->orders.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	

}
