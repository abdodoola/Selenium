import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class a089_Aufgabe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		//System.out.println(driver.findElement(By.cssSelector("")));
		//System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("html > frameset > frame:nth-child(1)")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("html > frameset > frame:nth-child(2)")));
		
		System.out.println(driver.findElement(By.cssSelector("#content")).getText());
		
	}

}
