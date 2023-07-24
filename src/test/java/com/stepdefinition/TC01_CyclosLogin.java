package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC01_CyclosLogin extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User should be on Cyclos Login Page")
	public void user_should_be_on_cyclos_login_page() {

	}

	@When("User should perform login using {string} and {string}")
	public void user_should_perform_login_using_and(String username, String password) throws InterruptedException {
		unconditionalWait(3000);
		pom.getLoginPage().login(username, password);
	}

	@Then("Verfiy user is on homepage by {string} and close browser")
	public void verfiy_user_is_on_homepage_by_and_close_browser(String verifyTxt) throws InterruptedException {
		unconditionalWait(3000);
		WebElement successMsg = pom.getHomePage().getSuccessMsg();
		String text = getText(successMsg);
		Assert.assertEquals(verifyTxt, text);
	}

	@When("User should perform login using {string} and {string} with Enter Key")
	public void user_should_perform_login_using_and_with_enter_key(String username, String password) throws InterruptedException {
		unconditionalWait(3000);
		pom.getLoginPage().loginWithEnterKey(username, password);
	}

	@When("User perform login using {string} and {string}")
	public void user_perform_login_using_and(String username, String password) throws InterruptedException {
		unconditionalWait(3000);
		pom.getLoginPage().login(username, password);
	}

	@Then("Verify displaying error {string} and close browser")
	public void verify_displaying_error_and_close_browser(String message) throws InterruptedException {
		unconditionalWait(5000);
		WebElement errorMsg = pom.getLoginPage().getErrorMsg();
		String text = getText(errorMsg);
	}

}
