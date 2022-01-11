package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

	public WebDriver driver;

	private By email = By.cssSelector("[name='Email']");
	private By password = By.cssSelector("[name='Password']");
	private By logInButton = By.cssSelector("[value='Log in']");
	


	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogInButton()
	{
		return driver.findElement(logInButton);
	}

}
