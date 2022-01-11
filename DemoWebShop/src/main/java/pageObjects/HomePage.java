package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	private By register = By.cssSelector("a[href*='/register']");
	private By login = By.cssSelector("a[href*='/login']");
	private By shoppingCart = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPage getRegister() {
		driver.findElement(register).click();
		RegisterPage lp = new RegisterPage(driver);
		return lp;
	}

	public LoginPage getLogin() {
		driver.findElement(login).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}

	public ShoppingCart getShoppingCart() {
		driver.findElement(shoppingCart).click();
		ShoppingCart lp = new ShoppingCart(driver);
		return lp;
	}

	public void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h2[@class='product-title']"));
		List<String> productsName = new ArrayList<String>();
		List<String> itemsNeededList = Arrays.asList(itemsNeeded);

		for (int i = 0; i < products.size(); i++) {
			productsName.add(products.get(i).getText().trim());

			if (itemsNeededList.contains(productsName.get(i))) {
				j++;
				driver.findElements(By.xpath("//div[@class='buttons']/input[@value='Add to cart']")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}

}
