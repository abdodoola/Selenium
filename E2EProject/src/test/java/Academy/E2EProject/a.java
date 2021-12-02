package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.base;

public class a extends base {
	
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateAppTitle() throws IOException {

		HomePage l = new HomePage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		System.out.println("Test completed");
	}

	
}
