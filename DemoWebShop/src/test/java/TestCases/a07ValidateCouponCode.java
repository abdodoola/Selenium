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

public class a07ValidateCouponCode extends base  {
    
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
	public void validateCouponCode() throws IOException {
		

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
		sc.getDiscountCode().sendKeys("AutomationDiscount2");
		sc.getApplyCoupon().click();
		
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(sc.getCouponAppliedMessage()));  
		
		String discount = driver.findElement(sc.getDiscount()).getText();
		String price = driver.findElement(sc.getPrice()).getText();
		
		float actualPercentResult = Math.abs(Float.parseFloat(discount)/Float.parseFloat(price));
		float expectedPercentResult = (float) 0.2;
		System.out.println(actualPercentResult);
		
		boolean result = false;
		
		if(actualPercentResult==expectedPercentResult) {
			result = true;
		}
		
		Assert.assertTrue(result);
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
 
}
