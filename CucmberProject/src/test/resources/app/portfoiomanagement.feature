@PortfolioManagement
Feature: Create and Delete Portfolios
  
  Background:
    Given I open 'Chrome'
    When Navigate to 'login_page_url'
    And Login with default credentials
   
  @CreatePortfolio
  Scenario: Creation of Portfolio
    When I create a portfolio 'ABC1'
    Then Portfolio 'ABC1' should be created

  @DeletePortfolio
  Scenario: Deletion of Portfolio
    When I delete a portfolio 'ABC1'
    Then Portfolio 'ABC1' should be created
    