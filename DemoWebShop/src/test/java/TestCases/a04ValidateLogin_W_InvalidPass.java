package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.base;

public class a04ValidateLogin_W_InvalidPass extends base {

	public WebDriver driver;
	HomePage l;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test
	public void validateLogin_W_InvalidPass() throws IOException {

		//String email = prop.getProperty("email");
		String password = prop.getProperty("password");

		l = new HomePage(driver);
		LoginPage lp = l.getLogin();

		lp.getEmail().sendKeys("abc@abc.com");
		lp.getPassword().sendKeys(password);
		lp.getLogInButton().click();

		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='validation-summary-errors']")));  
		Assert.assertFalse(driver.findElement(By.cssSelector("[class='validation-summary-errors']")).getText(), true);
	
	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
