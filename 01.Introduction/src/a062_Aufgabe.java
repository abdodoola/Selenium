import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class a062_Aufgabe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		
		driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div[1]/div/div[2]/div/div[3]/div[3]/div/div/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div[1]/div/div[2]/div/div[3]/div[3]/div/div/div/div/div/ul/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[2]/div/div")).click();
		
		WebElement staticDropdown1 = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div[1]/div/div[2]/div/div[4]/div/div[1]/select"));
		WebElement staticDropdown2 = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div[1]/div/div[2]/div/div[4]/div/div[1]/select"));

		Select dropdown1 = new Select(staticDropdown1);
		Select dropdown2 = new Select(staticDropdown2);
		dropdown1.selectByIndex(3);
		dropdown2.selectByIndex(2);
		
		driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div[1]/div/div[2]/div/div[7]/div[2]/button")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div[1]/div[2]/div/div/div/span")).getText());
		
	}

}
