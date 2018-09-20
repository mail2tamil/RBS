package StepDefinitionFiles;

import org.openqa.selenium.By;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyAccountUpdate {

	@When("^user navigates to My Account Page$")
	public void user_navigates_to_My_Account_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span")).click();
	}

	@When("^user navigates to My personal information$")
	public void user_navigates_to_My_personal_information() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.driver.findElement(By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a > span")).click();

	}

	@Then("^user gets the YOUR PERSONAL INFORMATION$")
	public void user_gets_the_YOUR_PERSONAL_INFORMATION() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#center_column > div > h1"), "YOUR PERSONAL INFORMATION");
	}

	@When("^user updates the FirstName$")
	public void user_updates_the_FirstName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.driver.findElement(By.id("firstname")).sendKeys("Test");
		CommonFunctionalities.driver.findElement(By.id("old_passwd")).sendKeys("Password123");
		CommonFunctionalities.driver.findElement(By.cssSelector("#center_column > div > form > fieldset > div:nth-child(11) > button > span")).click(); 
	}

	@Then("^user gets the Your personal information has been successfully updated\\. message$")
	public void user_gets_the_Your_personal_information_has_been_successfully_updated_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#center_column > div > p"), "Your personal information has been successfully updated.");
		 
	}

}
