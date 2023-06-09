package kgisl.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}  
	
	
	
	
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartItems;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;

	
	
	public Boolean VerifyCartItems(String productName) {
		
		Boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage gotoCheckout() {
		checkout.click();
		
		return new CheckOutPage(driver);
	}

}
