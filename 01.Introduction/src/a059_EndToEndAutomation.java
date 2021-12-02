import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class a059_EndToEndAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_ddl_originStation1_CTXT\']")).click(); 
		driver.findElement(By.xpath("//*[@id=\'dropdownGroup1\']/div/ul[1]/li[6]/a")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'glsctl00_mainContent_ddl_destinationStation1_CTNR\']//*[@id=\'dropdownGroup1\']/div/ul[1]/li[7]/a")).click();

		driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[4]/td[3]/a")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("Is Disabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
		Thread.sleep(2000);
		for(int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_btn_FindFlights\']")).click();
	}

}
