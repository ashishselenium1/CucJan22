package steps;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;

public class Portfolio {
	TestContext testContext;
	LandingPage landingpage;
	
	public Portfolio(TestContext testContext) {
		this.testContext=testContext;
		System.out.println("Initialize navigate");
		landingpage = testContext.getPageObjectManager().getLandingPage();
	}
	
	 @When("I create a portfolio {string}")
	 public void createPortfolio(String portfolioName) {
		 landingpage.createPortfolio(portfolioName);
	 }
	 
	 @Then("Portfolio {string} should be created")
	 public void validatePortfolioCreation(String portfolioName) {
		 landingpage.validatePortfolioCreation(portfolioName);
	 }
	 
	 @When("I delete a portfolio {string}")
	 public void deletePorfolio(String portfolioName) {
		 
	 }
	 
	    
	 @Then("Portfolio {string} should be deleted")
	 public void validatePortfolioDeletion(String portfolioName)
	 {
		 
	 }
	    

}
