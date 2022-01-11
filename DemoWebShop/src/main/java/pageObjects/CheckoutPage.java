package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {

	public WebDriver driver;
	
	private By savedAddresses = By.xpath("//select[@name='billing_address_id']");
	private By country = By.xpath("//*[@id='BillingNewAddress_CountryId']");
	private By city = By.xpath("//*[@id='BillingNewAddress_City']");
	private By address1 = By.xpath("//*[@id='BillingNewAddress_Address1']");
	private By postalCode = By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']");
	private By phoneNumber = By.xpath("//*[@id='BillingNewAddress_PhoneNumber']");
	
	private By continueButton = By.xpath("//*[@id='billing-buttons-container']/input");
	private By continueButtonShippingAddress = By.xpath("//*[@id=\"shipping-buttons-container\"]/input");
	private By continueButtonShippingMethod = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input");
	private By continueButtonPaymentMethod = By.xpath("//*[@id=\"payment-method-buttons-container\"]/input");
	private By continueButtonPaymentInfo = By.xpath("//*[@id=\"payment-info-buttons-container\"]/input");
	private By confirmButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");
	
	private By creditCardPaymentMethod = By.xpath("//*[@id=\"paymentmethod_2\"]");
	
	private By selectCreditCard = By.xpath("//*[@id=\"CreditCardType\"]"); 
	private By cardHolderName = By.xpath("//*[@id=\"CardholderName\"]"); 
	private By cardNumber = By.xpath("//*[@id=\"CardNumber\"]"); 
	private By expirationDataMonth = By.xpath("//*[@id=\"ExpireMonth\"]"); 
	private By expirationDateYear = By.xpath("//*[@id=\"ExpireYear\"]"); 
	private By cardCode = By.xpath("//*[@id=\"CardCode\"]"); 
	 
	
	private By countryError = By.xpath("//*[@id=\"billing-new-address-form\"]/div/div/div/div[5]/span[2]");
	private By cityError = By.xpath("//*[@id=\"billing-new-address-form\"]/div/div/div/div[7]/span[2]");//*[@id="billing-new-address-form"]/div/div/div/div[7]/span[2]
	private By address1Error = By.xpath("//*[@id=\"billing-new-address-form\"]/div/div/div/div[8]/span[2]");//*[@id="billing-new-address-form"]/div/div/div/div[8]/span[2]
	private By postalCodeError = By.xpath("//*[@id=\"billing-new-address-form\"]/div/div/div/div[10]/span[2]");//*[@id="billing-new-address-form"]/div/div/div/div[10]/span[2]
	private By phoneNumberError = By.xpath("//*[@id=\"billing-new-address-form\"]/div/div/div/div[11]/span[2]");//*[@id="billing-new-address-form"]/div/div/div/div[11]/span[2]

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSavedAddresses()
	{
		return driver.findElement(savedAddresses);
	}
	public WebElement getCountry()
	{
		return driver.findElement(country);
	}
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	public WebElement getAddress1()
	{
		return driver.findElement(address1);
	}
	public WebElement getPostalCode()
	{
		return driver.findElement(postalCode);
	}
	public WebElement getPhoneNumber()
	{
		return driver.findElement(phoneNumber);
	}
	
	
	public WebElement getContinueButton()
	{
		return driver.findElement(continueButton);
	}
	public WebElement getContinueButtonShippingAddress()
	{
		return driver.findElement(continueButtonShippingAddress);
	}
	public WebElement getContinueButtonShippingMethod()
	{
		return driver.findElement(continueButtonShippingMethod);
	}
	public By getContinueButtonPaymentMethod()
	{
		return continueButtonPaymentMethod;
	}
	public WebElement getContinueButtonPaymentInfo()
	{
		return driver.findElement(continueButtonPaymentInfo);
	}
	public WebElement getConfirmButton()
	{
		return driver.findElement(confirmButton);
	}
	
	
	public WebElement getCreditCardPaymentMethod()
	{
		return driver.findElement(creditCardPaymentMethod);
	}
	
	
	public WebElement getSelectCreditCard()
	{
		return driver.findElement(selectCreditCard);
	}
	public WebElement getCardHolderName()
	{
		return driver.findElement(cardHolderName);
	}
	public WebElement getCardNumber()
	{
		return driver.findElement(cardNumber);
	}
	public WebElement getExpirationDataMonth()
	{
		return driver.findElement(expirationDataMonth);
	}
	public WebElement getExpirationDateYear()
	{
		return driver.findElement(expirationDateYear);
	}
	public WebElement getCardCode()
	{
		return driver.findElement(cardCode);
	}
	
	
	public By getCountryError()
	{
		return countryError;
	}
	public By getCityError()
	{
		return cityError;
	}
	public By getAddress1Error()
	{
		return address1Error;
	}
	public By getPostalCodeError()
	{
		return postalCodeError;
	}
	public By getPhoneNumberError()
	{
		return phoneNumberError;
	}

}
