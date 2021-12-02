import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalEnv {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Users\\AbdElRahman\\eclipse-workspace\\GlobalEnvVariables\\src\\data.properties");

		prop.load(fis);

		System.out.println(prop.getProperty("browser"));

		System.out.println(prop.getProperty("url"));

		prop.setProperty("browser", "firefox");

		System.out.println(prop.getProperty("browser"));

		FileOutputStream fos = new FileOutputStream("C:\\Users\\AbdElRahman\\eclipse-workspace\\GlobalEnvVariables\\src\\data.properties");

		prop.store(fos, null);
	}

}
