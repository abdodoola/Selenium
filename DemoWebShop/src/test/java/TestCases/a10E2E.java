package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingCart;
import resources.base;

public class a10E2E extends base  {
    
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
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"))).build().perform(); // Hover mouse to computers
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a")).click();  // click on desktops
		
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div/div[2]/div[3]/div[2]/input")).click(); // select simple computer
		
		@SuppressWarnings("deprecation")
		WebDriverWait w3 = new WebDriverWait(driver,5);
		w3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='product_attribute_75_5_31']")));  
		
		driver.findElement(By.cssSelector("input[name='product_attribute_75_5_31']")).click();  // click on slow
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-75\"]")).click();  // click on add
		
		ShoppingCart sc = l.getShoppingCart();
		sc.getTermsBox().click();
		sc.getcheckoutButton().click();

		CheckoutPage cp = new CheckoutPage(driver);
		
		int savedAddressExists = driver.findElements(By.xpath("//select[@name='billing_address_id']")).size();
		
		if(savedAddressExists!=0) {
			cp.getContinueButton().click();
		}else {
			WebElement staticDropdown = cp.getCountry();;
			Select dropdown = new Select(staticDropdown);
			dropdown.selectByVisibleText("Egypt");
			
			cp.getCity().sendKeys("Alex");
			cp.getAddress1().sendKeys("14 A st");
			cp.getPostalCode().sendKeys("123456");
			cp.getPhoneNumber().sendKeys("01120");
			cp.getContinueButton().click();
		}
		
		cp.getContinueButtonShippingAddress().click();
		cp.getContinueButtonShippingMethod().click();
		
		cp.getCreditCardPaymentMethod().click();
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(cp.getContinueButtonPaymentMethod())); 
		
		driver.findElement(cp.getContinueButtonPaymentMethod()).click();
		
		
		String creditCard = prop.getProperty("creditCard");
		String cardHolderName = prop.getProperty("cardHolderName");
		String cardNumber = prop.getProperty("cardNumber");
		String expirationDateMonth = prop.getProperty("expirationDateMonth");
		String expirationDateYear = prop.getProperty("expirationDateYear");
		String cardCode = prop.getProperty("cardCode");
		
		WebElement selectCreditCardStaticDropdown = cp.getSelectCreditCard();
		Select selectCreditCarddropdown = new Select(selectCreditCardStaticDropdown);
		selectCreditCarddropdown.selectByVisibleText(creditCard);
		
		cp.getCardHolderName().sendKeys(cardHolderName);
		cp.getCardNumber().sendKeys(cardNumber);
		
		WebElement expirationDataMonthStaticDropdown = cp.getExpirationDataMonth();
		Select expirationDataMonthdropdown = new Select(expirationDataMonthStaticDropdown);
		expirationDataMonthdropdown.selectByVisibleText(expirationDateMonth);
		
		WebElement expirationDateYearStaticDropdown = cp.getExpirationDateYear();
		Select expirationDateYeardropdown = new Select(expirationDateYearStaticDropdown);
		expirationDateYeardropdown.selectByVisibleText(expirationDateYear);
		
		cp.getCardCode().sendKeys(cardCode);
		
		cp.getContinueButtonPaymentInfo().click();
		
		cp.getConfirmButton().click();
		
		@SuppressWarnings("deprecation")
		WebDriverWait w2 = new WebDriverWait(driver,5);
		w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")));  
		System.out.println(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")).getText());
		
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")).getText(), true);
		
		log.info(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")).getText());
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
 
}
