package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement userName;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btnSubmit;
	@FindBy(xpath = "//div[text()='The given name / password are incorrect. Please, try again.']")
	private WebElement errorMsg;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public void login(String username, String password) {
		WebElement userName = getUserName();
		sendKeys(userName, username);
		WebElement pass = getPassword();
		sendKeys(pass, password);
		WebElement btnSubmit = getBtnSubmit();
		click(btnSubmit);
	}

	public void loginWithEnterKey(String username, String password) {
		WebElement userName = getUserName();
		sendKeys(userName, username);
		WebElement pass = getPassword();
		sendKeys(pass, password);
		clickByEnterKey();
	}

}
