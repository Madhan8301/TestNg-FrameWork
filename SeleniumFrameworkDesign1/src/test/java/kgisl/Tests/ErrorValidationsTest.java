package kgisl.Tests;


import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import kgisl.TestComponents.BaseTest;
import kgisl.pageobjects.CartPage;
import kgisl.pageobjects.ProductPage;


public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"})
	public void LoginErrorTest() throws IOException, InterruptedException
	{
		landingPage.loginApplication("madhan@gmail.com", "Madhan@675");
		String Msg = landingPage.GetErrorMessage();
		Assert.assertEquals("Incorrect email password.", Msg);
  	}
	
	
	@Test
	public void ProductErrorTest() throws InterruptedException {
		
		ProductPage productPage=landingPage.loginApplication("madhan8301@gmail.com", "Madhan@6765");
		productPage.getProducts();
		CartPage cartPage = productPage.SelectProductByName("ADIDAS ORIGINAL");
		//cartPage.goToCart();
		Boolean match =cartPage.VerifyCartItems("ADIDAS ORIGINAL9");
		Assert.assertFalse(match);
	}

	

}
