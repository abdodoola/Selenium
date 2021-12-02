import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class a002_FacebookLocator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://facebook.com");
		//driver.findElement(By.id("email")).sendKeys("abdodoola@gmail.com");
		//driver.findElement(By.name("pass")).sendKeys("123456");
		//driver.findElement(By.linkText("Forgotten password?")).click();
		//driver.findElement(By.className("inputtext")).sendKeys("abdodoola@gmail.com");
		//driver.findElement(By.xpath("//*[@id=\'u_0_d_A/\']")).click();
		driver.get("https://login.salesforce.com/");
		//driver.findElement(By.id("username")).sendKeys("abdodoola@gmail.com");
		//
		driver.findElement(By.cssSelector("#username")).sendKeys("aa");
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click(); 
		String x = driver.findElement(By.xpath("//*[@id=\'error\']")).getText();
		System.out.println("Error:"+x);
	}
}
