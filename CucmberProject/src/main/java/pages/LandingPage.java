package pages;

import managers.webdriver.WebDriverManager;

public class LandingPage {
	WebDriverManager webDriverManager;
	
	public LandingPage(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;
	}
	
	public void selectPortfolio(String option) {
		webDriverManager.select("portfolio_selection_dropdown_id", option);
	}

	public void createPortfolio(String portfolioName) {
		webDriverManager.click("create_portfolio_button_id");
		webDriverManager.clear("create_portfolio_textfield_name");
		webDriverManager.type("create_portfolio_textfield_name", portfolioName);
		webDriverManager.click("create_portfolio_submit_button_id");
	}

	public void validatePortfolioCreation(String portfolioName) {
		webDriverManager.validateOptionPresentInDropDown("portfolio_selection_dropdown_id",portfolioName,true);
		
	}

}
