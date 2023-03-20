package kgisl.Tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import kgisl.TestComponents.BaseTest;
import kgisl.data.DataReader;
import kgisl.pageobjects.CartPage;
import kgisl.pageobjects.CheckOutPage;
import kgisl.pageobjects.FinalConformationPage;
import kgisl.pageobjects.OrderPage;
import kgisl.pageobjects.ProductPage;


public class MainTest extends BaseTest{

	//String productName = "ADIDAS ORIGINAL";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void mainTest(HashMap<String,String> input) throws IOException, InterruptedException
	{
		ProductPage productPage = landingPage.loginApplication(input.get("email"),input.get("password"));
		 
		
		productPage.getProducts();
		CartPage cartPage = productPage.SelectProductByName(input.get("productName"));
		
		Boolean match =cartPage.VerifyCartItems(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.gotoCheckout();
		
		
		checkoutPage.gotoConfirmOrder();
		FinalConformationPage confirm = checkoutPage.placeOrder();
		
		
		String ConfirmMessage = confirm.ConformationMessage();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(ConfirmMessage);
		
			
				
  	}
	
	@Test(dependsOnMethods= {"mainTest"},dataProvider="getData")
	public void orderhistoryTest(HashMap<String,String> input) throws IOException {
		
		ProductPage productPage = landingPage.loginApplication(input.get("email"),input.get("password"));
		OrderPage orderPage = productPage.goToOrdersPage();
		Boolean match1 = orderPage.VerifyOrderItems(input.get("productName"));
		Assert.assertTrue(match1);
		if(match1==true) {
			System.out.println("Order is Present");
		}
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "madhan@gmail.com");
//		map.put("password", "Madhan@6765");
//		map.put("productName", "IPHONE 13 PRO");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "madhan8301@gmail.com");
//		map1.put("password", "Madhan@6765");
//		map1.put("productName", "ADIDAS ORIGINAL");
		DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data = dataReader.getDatafromJson();
		
		return new Object[][] {{data.get(0)},{data.get(1)}} ;
		
		//return new Object[][]{{map},{map1}} ;
	}

	

}
