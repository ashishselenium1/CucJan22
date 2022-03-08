package steps;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.StockManagementPage;

public class StockManagement {
	
    TestContext testContext;
    StockManagementPage stockManagementPage;
    
	public StockManagement(TestContext testContext) {
		this.testContext=testContext;
		System.out.println("Initialize navigate");
		stockManagementPage = testContext.getPageObjectManager().getStockManagementPage();
	}
	
	
	@And("I add a stock with details as")
	public void addStock(DataTable stockDetails) {
		System.out.println("I add a stock with details as "+stockDetails);
		stockManagementPage.addStock(stockDetails.asList());
	}
	
	@And("I sell the stock with details as")
	public void sellExistingStock(DataTable dataTable) {
		testContext.log("Selling stock with details - "+dataTable.asList());
		stockManagementPage.sellExistingStock(dataTable.asList());
	}
	
}
