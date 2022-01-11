package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterPage {

	public WebDriver driver;

	private By genderMale = By.cssSelector("#gender-male");
	private By genderFemale = By.cssSelector("#gender-female");
	private By firstName = By.cssSelector("[name='FirstName']");
	private By lastName = By.cssSelector("[name='LastName']");
	private By email = By.cssSelector("[name='Email']");
	private By password = By.cssSelector("[name='Password']");
	private By confirmPassword = By.cssSelector("[name='ConfirmPassword']");
	private By registerButton = By.cssSelector("[name='register-button']");


	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	

	public WebElement getGenderMale() {
		return driver.findElement(genderMale);
	}
	
	public WebElement getGenderFemale() {
		return driver.findElement(genderFemale);
	}

	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName()
	{
		return driver.findElement(lastName);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getConfirmPassword()
	{
		return driver.findElement(confirmPassword);
	}
	public WebElement getRegisterButton()
	{
		return driver.findElement(registerButton);
	}

}
