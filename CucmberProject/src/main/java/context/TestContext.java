package context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;

import managers.PageObjectManager;
import managers.webdriver.WebDriverManager;
// implement more features
// grid one hub and 2 nodes
// Jenkins + Git

public class TestContext {
	PageObjectManager pageObjectManager;
	ExtentReports extentReports;
	
	public TestContext() {
			System.out.println("Init test context");
			pageObjectManager = new PageObjectManager();
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public void log(String msg) {
		pageObjectManager.getWebDriverManager().log(msg);
		
	}

	public void takeScreenshot() {
		pageObjectManager.getWebDriverManager().takeScreenshot();
	}
	
}
