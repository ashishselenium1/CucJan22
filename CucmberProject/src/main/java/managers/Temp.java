package managers;
// map the features
// reporting
// implement more scenarios
// implement grid
// jekins, github

import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LaunchPage;
import pages.LoginPage;

public class Temp {

	@Test
	public void temp() {
		PageObjectManager pageObjectManager = new PageObjectManager();
		LaunchPage launchPage = pageObjectManager.getLaunchPage();
		LoginPage loginPage = pageObjectManager.getLoginPage();
		LandingPage landingpage= pageObjectManager.getLandingPage();

		launchPage.openBrowser("Chrome");
		launchPage.navigate("login_page_url");
		loginPage.doLogin();
		landingpage.selectPortfolio("Anything");
		
	}
}
