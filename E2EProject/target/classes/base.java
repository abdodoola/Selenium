package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/java/resources/data.properties");
		//FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//String browserName = System.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/java/resources/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "./src/main/java/resources/msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
}

/*
 * else if (browserName.equals("ie")) {
 * System.setProperty("webdriver.ie.driver",
 * "C:\\Program Files\\selenium-java-3.141.59\\IEDriverServer"); driver = new
 * InternetExplorerDriver(); }
 */