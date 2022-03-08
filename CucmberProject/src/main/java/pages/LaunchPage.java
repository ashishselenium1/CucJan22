package pages;

import managers.webdriver.WebDriverManager;

public class LaunchPage {
	WebDriverManager webDriverManager;
	
	public LaunchPage(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;
	}
	
	
	public void openBrowser(String browserName) {
		webDriverManager.openBrowser(browserName);
	}
	
	
	public void navigate(String url) {
		webDriverManager.navigate(url);
	}

}
