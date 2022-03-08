package managers.webdriver;

public class WebDriverTest {

	public static void main(String[] args) {
		WebDriverManager webDriverManager = new WebDriverManager();// init prop file
		webDriverManager.openBrowser("Chrome");
		webDriverManager.navigate("login_page_url");
		webDriverManager.login();
		
		if(webDriverManager.isElementPresent("portfolio_selection_dropdown_id"))
		 webDriverManager.select("portfolio_selection_dropdown_id", "Anything");

	}

}
