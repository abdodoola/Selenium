package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import resources.base;

public class a01ValidateRegister extends base  {
    
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
	public void validateRegister() throws IOException {
		
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
		
	}
	
	@AfterTest
	public void teardown() {

		driver.close();
	}
 
}
