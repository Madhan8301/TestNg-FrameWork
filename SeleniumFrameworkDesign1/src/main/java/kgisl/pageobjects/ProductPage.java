package kgisl.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kgisl.AbstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}  
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
//	@FindBy(id="userPassword")
//	WebElement password;
//	

	
	
	By productBy = By.cssSelector(".mb-3");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	By toast = By.cssSelector("#toast-container");
	
	By animating = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProducts() {
		WaitToVisible(productBy);
		return products;
	}
	
	public CartPage SelectProductByName(String productName) throws InterruptedException {
		
		WebElement prod = getProducts().stream().filter(product->
				product.findElement(By.cssSelector("b"))
				.getText().equals(productName))
				.findFirst().orElse(null);
		
		prod.findElement(addTocart).click();
		WaitToVisible(toast);
		WaitToDisappear(animating);
		CartPage cartPage = goToCart();
		return cartPage;
		
		
		
		//return new CartPage(driver);
			
	}
	
	

}
