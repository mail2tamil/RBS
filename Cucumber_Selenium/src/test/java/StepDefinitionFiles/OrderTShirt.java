package StepDefinitionFiles;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class OrderTShirt {

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {  
	
		CommonFunctionalities.driver.get("http://automationpractice.com/index.php");
		CommonFunctionalities.driver.manage().window().maximize();
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		CommonFunctionalities.driver.findElement(By.linkText("Sign in")).click();
	}

	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		CommonFunctionalities.driver.findElement(By.id("email")).sendKeys("someone@example.com");
		CommonFunctionalities.driver.findElement(By.id("passwd")).sendKeys("Password123");
		CommonFunctionalities.driver.findElement(By.id("SubmitLogin")).click();   
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";	
		String actual = CommonFunctionalities.driver.findElement(By.cssSelector("#center_column > p")).getText();
		Assert.assertEquals(exp_message, actual);  
		//CommonFunctionalities.driver.quit();  
	}   
	@When("^user navigates to T-shirts tab$")
	public void user_navigates_to_T_shirts_tab() throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a")).click();
	}

	@When("^user select size,color and Styles$")
	public void user_select_size_color_and_Styles() throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions 
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("layered_id_attribute_group_3")));
		CommonFunctionalities.driver.findElement(By.id("layered_id_attribute_group_3")).click();
		CommonFunctionalities.driver.findElement(By.id("layered_id_attribute_group_14")).click();
		
		WebElement sortby=CommonFunctionalities.driver.findElement(By.xpath("//*[@id='selectProductSort']"));
		Select sel=new Select(sortby);
		sel.selectByVisibleText("Reference: Highest first");	
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.id("layered_id_feature_11")).click();		
	}
	@When("^select the tshirt and add it to the cart$")
	public void select_the_tshirt_and_add_it_to_the_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		WebElement FirstShowingItem=CommonFunctionalities.driver.findElement(By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img"));
		FirstShowingItem.click();
		CommonFunctionalities.waitTime(5);
		/*Actions act=new Actions(CommonFunctionalities.driver.Testrunner.driver);
		act.moveToElement(FirstShowingItem);	
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);*/
		CommonFunctionalities.driver.switchTo().frame(CommonFunctionalities.driver.findElement(By.className("fancybox-iframe")));
		CommonFunctionalities.driver.findElement(By.cssSelector("#add_to_cart > button > span")).click();
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.switchTo().defaultContent();
	}
	@Then("^Product successfully added to your shopping cart message is displayed in a new tab$")
	public void product_successfully_added_to_your_shopping_cart_message_is_displayed_in_a_new_tab() throws Throwable {	// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2"),"Product successfully added to your shopping cart");
	}
	@Given("^user click on Proceed to Checkout and navigates to SHOPPING-CART SUMMARY page$")
	public void user_click_on_Proceed_to_Checkout_and_navigates_to_SHOPPING_CART_SUMMARY_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")).click();
	}
	@Then("^user navigates to Summary tab$")
	public void user_navigates_to_Summary_tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#order_step > li.step_current.first > span"),"01. Summary");
	}
	@When("^proceed with the Summary tab$")
	public void proceed_with_the_Summary_tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")).click();
	}	 
	@When("^proceed with the (\\d+)\\. Sign$")
	public void proceed_with_the_Sign(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")).click();
	}
	@When("^user select the proceed to checkout button$")
	public void user_select_the_proceed_to_checkout_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")).click();
	}
	@Then("^user navigates to (\\d+)\\. Sign in$")
	public void user_navigates_to_Sign_in(int arg1) throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#order_step > li.step_current.first > span")," Sign in");
	}
	@Then("^user navigates to (\\d+)\\. Address$")
	public void user_navigates_to_Address(int arg1) throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#order_step > li.step_current.third > span"),"03. Address");
    }	
	@Then("^proceed with the (\\d+)\\. Address tab$")
	public void proceed_with_the_Address_tab(int arg1) throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#center_column > form > p > button > span")).click();
	}
	@Then("^user navigates to (\\d+)\\. Shipping$")
	public void user_navigates_to_Shipping(int arg1) throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#order_step > li.step_current.four > span"),"04. Shipping");	 
	}
	@When("^proceed with the (\\d+)\\. Shipping tab$")
	public void proceed_with_the_Shipping_tab(int arg1) throws Throwable 
	{
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);		
		CommonFunctionalities.driver.findElement(By.cssSelector("#cgv")).click();
		CommonFunctionalities.driver.findElement(By.cssSelector("#form > p > button > span")).click();
	}
	@Then("^user navigates to (\\d+)\\. Payment$")
	public void user_navigates_to_Payment(int arg1) throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#step_end > span"),"05. Payment");
	}
	@When("^proceed with the (\\d+)\\. Payment tab$")
	public void proceed_with_the_Payment_tab(int arg1) throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#cart_navigation > button > span")).click();
	}
	@Then("^user gets the You have chosen to pay by bank wire\\. Here is a short summary of your order message is displayed$")
	public void user_gets_the_You_have_chosen_to_pay_by_bank_wire_Here_is_a_short_summary_of_your_order_message_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#center_column > form > div > p.cheque-indent > strong"),"You have chosen to pay by bank wire. Here is a short summary of your order:");
	}
	@When("^user select the Pay by bank wire$")
	public void user_select_the_Pay_by_bank_wire() throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions	
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a")).click();
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
	}
	@When("^in ORDER SUMMARY page select the I confirm my order$")
	public void in_ORDER_SUMMARY_page_select_the_I_confirm_my_order() throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.waitTime(CommonFunctionalities.waitTime);
		CommonFunctionalities.driver.findElement(By.cssSelector("#cart_navigation > button > span")).click();

	}

	@Then("^user gets the Your order on My Store is complete message with details$")
	public void user_gets_the_Your_order_on_My_Store_is_complete_message_with_details() throws Throwable 
	{
		// Write code here that turns the phrase above into concrete actions
		CommonFunctionalities.verifyText(By.cssSelector("#center_column > div > p > strong"),"Your order on My Store is complete.");
	 
	}
	
}
