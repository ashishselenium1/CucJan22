package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LandingPage;
import pages.LaunchPage;
import pages.LoginPage;

public class Session {
	
	TestContext testContext;
	LaunchPage launchPage;
	LoginPage loginPage;
	LandingPage landingpage;
	
	public Session(TestContext testContext) {
		System.out.println("Initialize Open");
		this.testContext=testContext;
		launchPage=testContext.getPageObjectManager().getLaunchPage();
		loginPage=testContext.getPageObjectManager().getLoginPage();
		landingpage=testContext.getPageObjectManager().getLandingPage();
	}
	
	
	@Given("I open {string}")
	public void openBrowser(String browser) {
		testContext.log(" Starting scenario. Opening Browser "+ browser);
		launchPage.openBrowser(browser);
	}
	
	@And("Navigate to {string}")
	public void navigate(String url) {
		testContext.log("Navigate to "+url);
		launchPage.navigate(url);
		testContext.takeScreenshot();
	}
	
	@And("Login with default credentials")
	public void defaultLogin() {
		System.out.println("Login with default credentials");
		loginPage.doLogin();
	}
	
	@And("Select Portfolio {string}")
	public void selectPortFolio(String option){
		System.out.println("Select "+option+" from ");
		landingpage.selectPortfolio("Anything");

	}
	
	@Before
	public void init(Scenario scenario) {
		testContext.getPageObjectManager().getWebDriverManager().init(scenario.getName());
	}
	
	@After
	public void quit() {
		testContext.getPageObjectManager().getWebDriverManager().quit();
	}

}
