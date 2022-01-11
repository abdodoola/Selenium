package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingCart;
import resources.base;

public class a08ValidateTerms extends base  {
    
	public WebDriver driver;
	HomePage l ;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}
	
	@Test
	public void validateTerms() throws IOException {
		

		String email = prop.getProperty("email");
		String password = prop.getProperty("password");

		l=new HomePage(driver);
		LoginPage lp = l.getLogin();


		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.getLogInButton().click();
		
		String[] itemsNeeded = {"14.1-inch Laptop"};
		l.addItems(driver, itemsNeeded);
		
		ShoppingCart sc = l.getShoppingCart();
		sc.getcheckoutButton().click();
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(sc.getTermsWarning()));  
		Assert.assertFalse(driver.findElement(sc.getTermsWarning()).getText(), true);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
 
}
