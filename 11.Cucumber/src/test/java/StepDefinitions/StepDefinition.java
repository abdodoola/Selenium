package StepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinition {

	@Given("^User is on loading page$")
	public void user_is_on_loading_page() throws Throwable {
		System.out.println("Navigated");
	}

	@When("^User login into application with username and password$")
	public void user_login_into_application_with_username_and_password() throws Throwable {
		System.out.println("Logged");
	}

	@Then("^Home page is populated$")
	public void home_page_is_populated() throws Throwable {
		System.out.println("Populated");
	}

	@And("^Cards are displayed$")
	public void cards_are_displayed() throws Throwable {
		System.out.println("Displayed");
	}
}
