import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class a048_49_DynamicDD {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_ddl_originStation1_CTXT\']")).click(); 
		driver.findElement(By.xpath("//*[@id=\'dropdownGroup1\']/div/ul[1]/li[6]/a")).click(); 
		Thread.sleep(2000L);
		//driver.findElement(By.xpath("(//*[@id=\'dropdownGroup1\']/div/ul[1]/li[7]/a)[2]")).click(); 
		//driver.findElement(By.xpath("(//*[@value='MAA'])[2]")).click(); 
		driver.findElement(By.xpath("//*[@id=\'glsctl00_mainContent_ddl_destinationStation1_CTNR\']//*[@id=\'dropdownGroup1\']/div/ul[1]/li[7]/a")).click(); 
	}
}
