import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class a075_Aufagbe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
		
		WebDriverWait w = new WebDriverWait(driver,5);         
		
		driver.findElement(By.cssSelector("#content > a:nth-child(7)")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));  
		System.out.println(driver.findElement(By.cssSelector("#results")).getText());

	}

}
