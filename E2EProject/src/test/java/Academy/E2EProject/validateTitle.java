package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.base;

public class validateTitle extends base {

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
	public void validateAppTitle() throws IOException {

		l=new HomePage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED aCOURSES");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void validateHeader() throws IOException {

		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
