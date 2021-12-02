import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs {

	public static final String SAUCE_USERNAME = "oauth-abdodoola-2c510";
	public static final String SAUCE_ACCESS_KEY = "3680cf75-e2af-4660-842e-1f345b01eda4";
	//public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	protected static RemoteWebDriver driver;

	public static void main(String[] args) throws MalformedURLException {


		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("Windows 10");
		options.setBrowserVersion("latest");

		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", System.getenv("SAUCE_USERNAME"));
		sauceOptions.put("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
		//sauceOptions.put("name", testInfo.getDisplayName());
		
		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");
		driver = new RemoteWebDriver(url, options);
		driver.get("https://www.saucedemo.com");

	}

}
