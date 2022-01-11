package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingCart;
import resources.base;

public class a06ValidateAddNewItem extends base  {
    
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
	public void validateNewItem() throws IOException {
		

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
		
		Assert.assertEquals(itemsNeeded[0], sc.getitemName().getText());
		
	} 
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
 
}
