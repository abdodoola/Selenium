package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class a3 {

	@Test
	public void Demo9() {
		System.out.println("I am in a3");
	}

	@Test(dependsOnMethods = { "Demo13" })
	public void Demo12() {
		System.out.println("I depend on Demo13");
	}

	@Test
	public void Demo13() {
		System.out.println("I should execute first before Demo12");
	}

	@Test(enabled = false)
	public void Demo14() {
		System.out.println("I shouldn't run");
	}

	@Test(timeOut = 4000) // Milli second
	public void Demo15() {
		System.out.println("I shouldn't run");
	}
	
	@Parameters({"URL","userName"})
	@Test
	public void Demo16(String urlName,String userName) {
		System.out.println("This URL");
		System.out.println(urlName);
		System.out.println(userName);
	}
	
	@Test(dataProvider="getData")
	public void dataFunction(String userName,String password) {
		System.out.println(userName);
		System.out.println(password);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		
		data[0][0]="FirstUserName";
		data[0][1]="FirstPassword";
		data[1][0]="SecondUserName";
		data[1][1]="SecondPassword";
		data[2][0]="ThirdUserName";
		data[2][1]="ThirdPassword";
		
		return data;
		
	}
}
