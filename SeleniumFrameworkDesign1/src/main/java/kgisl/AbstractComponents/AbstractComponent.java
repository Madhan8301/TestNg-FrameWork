package kgisl.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kgisl.pageobjects.CartPage;
import kgisl.pageobjects.OrderPage;
//import kgisl.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[contains(@class,'shopping-cart')]")
	WebElement cart;
	
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	
	
	public void WaitToVisible(By productBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productBy));
		
	}
	
	public void WaitToWebElementVisible(WebElement productBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(productBy));
		
	}
	
	public CartPage goToCart() {
		
		CartPage cartPage = new CartPage(driver);
		cart.click();
		return cartPage;
	}
	
	public OrderPage goToOrdersPage() {
		OrderPage orderPage = new OrderPage(driver);
		//orderPage.VerifyOrderItems();
		orders.click();
		return orderPage;
	}
	
	public void WaitToDisappear(By ele) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
		
		Thread.sleep(1000);
	}

}
