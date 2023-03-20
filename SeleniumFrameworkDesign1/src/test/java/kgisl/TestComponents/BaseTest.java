package kgisl.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import kgisl.data.DataReader;
import kgisl.pageobjects.LandingPage;
import kgisl.pageobjects.OrderPage;
import kgisl.pageobjects.ProductPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	
	@SuppressWarnings("deprecation")
	public WebDriver InitializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\kgisl\\resources\\GlobalData.properties");
		prop.load(fis);
		
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = InitializeDriver();
		
		landingPage = new LandingPage(driver);
		landingPage.goToUrl();
		
		return landingPage;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File file =new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}
	
	
	
}
