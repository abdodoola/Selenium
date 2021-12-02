package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class a1 {

	@Test
	public void Demo() {
		System.out.println("Hello");
	}
	
	@Test(groups={"thisgroup"})
	public void Demo2() {
		System.out.println("Hey");
	}
	
	@BeforeTest
	public void Demo5() {
		System.out.println("Execute first");
	}
	
	@AfterTest
	public void Demo4() {
		System.out.println("Execute last");
	}
	
	
}
