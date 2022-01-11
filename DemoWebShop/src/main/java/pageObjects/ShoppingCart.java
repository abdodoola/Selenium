package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ShoppingCart {

	public WebDriver driver;

	private By discountCode = By.cssSelector("input[name='discountcouponcode']");
	private By applyCoupon = By.cssSelector("input[name='applydiscountcouponcode']");
	private By termsBox = By.cssSelector("input[name='termsofservice']");
	private By checkoutButton = By.cssSelector("button[name='checkout']");
	private By itemName = By.xpath("//td[@class='product']/a[@class='product-name']");
	private By couponAppliedMessage = By.xpath("//div[@class='message']");
	private By discount = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/span");
	private By price = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/span/span");
	private By termsWarning = By.xpath("//*[@id=\"terms-of-service-warning-box\"]/p");
	

	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDiscountCode()
	{
		return driver.findElement(discountCode);
	}
	public WebElement getApplyCoupon()
	{
		return driver.findElement(applyCoupon);
	}
	public WebElement getTermsBox()
	{
		return driver.findElement(termsBox);
	}
	public WebElement getcheckoutButton()
	{
		return driver.findElement(checkoutButton);
	}
	public WebElement getitemName()
	{
		return driver.findElement(itemName);
	}
	public By getCouponAppliedMessage()
	{
		return couponAppliedMessage;
	}
	public By getDiscount()
	{
		return discount;
	}
	public By getPrice()
	{
		return price;
	}
	public By getTermsWarning()
	{
		return termsWarning;
	}

}
