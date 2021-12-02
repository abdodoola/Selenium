import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class a102_Aufgabe1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,500)");
		
		System.out.println(driver.findElements(By.cssSelector(".table-display tr")).size());  // No of col
		System.out.println(driver.findElements(By.cssSelector(".table-display tr")).get(0).findElements(By.tagName("th")).size());  // No of rows
		
		List<WebElement> values = driver.findElements(By.cssSelector(".table-display tr")).get(2).findElements(By.tagName("td"));
		
		for(int i=0;i<values.size();i++) {
			System.out.println(values.get(i).getText());
		}
		
	}

}
