package test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class a2 {

	@Test
	public void Demo3() {
		System.out.println("Hello");
	}
	
	@Test
	public void Demo7() {
		System.out.println("Hello");
	}
	
	@Test(groups={"thisgroup"})
	public void Demo4() {
		System.out.println("Dont print");
	}
	
	@BeforeMethod
	public void Demo6() {
		System.out.println("I will execute before every methods in a2");
	}
	
	@AfterMethod
	public void Demo8() {
		System.out.println("I will execute after every methods in a2");
	}
	
	@BeforeClass
	public void Demo10() {
		System.out.println("I will execute before any method in a2");
	}
	
	@AfterClass
	public void Demo11() {
		System.out.println("I will execute after any method in a2");
	}
}
