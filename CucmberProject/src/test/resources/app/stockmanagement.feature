@StockManagement
Feature: Managing Stocks
  

   Background:
    Given I open 'Chrome'
    When Navigate to 'login_page_url'
    And Login with default credentials
    And Select Portfolio 'Anything'
   
  @PurchaseNewStock
  Scenario: Purchasing New Stock
    And I add a stock with details as
    |Reliance Industries Ltd.|24-04-2021|100|100|
    
    
	@SellExistingStock
  Scenario: Selling Existing Stock
    And I sell the stock with details as
    |Reliance Inds.|24-04-2021|100|100|    