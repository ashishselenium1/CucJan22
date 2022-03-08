package pages;

import managers.webdriver.WebDriverManager;

public class LoginPage {
	WebDriverManager webDriverManager;
	
	public LoginPage(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;
	}
	
	
	
	public void doLogin() {
		webDriverManager.login();
	}

}
