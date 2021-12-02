import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JDBC_Conn {

	public static void main(String[] args) throws SQLException {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");


		String host = "localhost";
		String port = "3306";
		String dataBaseName = "MyDataBase";
		String userName = "root";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dataBaseName, userName,
				"Aa@5947892");

		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where location ='cairo'");

		while (rs.next())
		{
			String name = rs.getString("name");
			String id = rs.getString("id");
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("id"));
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com");
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(name);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(id);
			
		}
	}
}
