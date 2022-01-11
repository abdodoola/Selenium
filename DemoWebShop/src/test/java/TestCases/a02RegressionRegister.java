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
import pageObjects.RegisterPage;
import resources.base;

public class a02RegressionRegister extends base  {
    
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
	public void regressRegister() throws IOException {
		
		String gender = prop.getProperty("gender");
		String firstName = prop.getProperty("firstName");
		String lastName = prop.getProperty("lastName");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");

		l=new HomePage(driver);
		RegisterPage lp = l.getRegister();

		if(gender.equals("male")) {
			lp.getGenderMale().click();
		}else if(gender.equals("female")){
			lp.getGenderFemale().click();
		}
		lp.getFirstName().sendKeys(firstName);
		lp.getLastName().sendKeys(lastName);
		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.getConfirmPassword().sendKeys(password);
		lp.getRegisterButton().click();
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='The specified email already exists']")));  
		Assert.assertFalse(driver.findElement(By.xpath("//*[text()='The specified email already exists']")).getText(), true);
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
 
}
