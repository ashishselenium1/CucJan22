package managers;

import org.testng.annotations.Test;

import managers.webdriver.WebDriverManager;
import pages.LandingPage;
import pages.LaunchPage;
import pages.LoginPage;
import pages.StockManagementPage;
// initializes WebDriverManager
// manages page objects
public class PageObjectManager {
	
	WebDriverManager webDriverManager;
	LaunchPage launchPage;
	LoginPage loginPage;
	LandingPage landingPage;
	StockManagementPage stockManagementPage;
	
	public PageObjectManager() {
		webDriverManager = new WebDriverManager();
	}
	
	public LaunchPage getLaunchPage() {
		if(launchPage == null)
			launchPage = new LaunchPage(webDriverManager);		
		return launchPage;
	}
	
	public LoginPage getLoginPage() {
		if(loginPage == null)
			loginPage = new LoginPage(webDriverManager);		
		return loginPage;
	}
	
	public LandingPage getLandingPage() {
		if(landingPage == null)
			landingPage = new LandingPage(webDriverManager);		
		return landingPage;
	}
	
	public StockManagementPage getStockManagementPage() {
		if(stockManagementPage == null)
			stockManagementPage = new StockManagementPage(webDriverManager);		
		return stockManagementPage;
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	
	
	
	

}
