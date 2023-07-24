package com.pagemanager;

import com.pages.HomePage;
import com.pages.LoginPage;

public class PageObjectManager {

	private LoginPage loginPage;
	private HomePage homePage;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage() : homePage;
	}

}
