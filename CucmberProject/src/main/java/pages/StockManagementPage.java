package pages;

import java.util.List;

import org.openqa.selenium.By;

import managers.webdriver.WebDriverManager;

public class StockManagementPage {
	WebDriverManager webDriverManager;
	
	public StockManagementPage(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;
	}
	
	public void addStock(List<String> list) {
        webDriverManager.click("add_stock_button_xpath");
        webDriverManager.type("stock_name_textfield_id", list.get(0).substring(0, list.get(0).length()-1));
        webDriverManager.getDriver().findElement(By.xpath("//div[text()='"+list.get(0)+"']")).click();
        // you
        
	}

	public void sellExistingStock(List<String> stockDetails) {
		int rowNum=webDriverManager.getRowNumWithCellData("all_rows_in_stock_table_css",stockDetails.get(0));
		if(rowNum==-1)
			webDriverManager.reportFailure("Stock Not found "+stockDetails.get(0) , true);
		
		webDriverManager.getDriver().findElement(By.cssSelector("table#stock > tbody >tr:nth-child("+rowNum+") >td:nth-child(1) > input")).click();
		webDriverManager.getDriver().findElement(By.cssSelector("table#stock > tbody >tr:nth-child("+rowNum+") >td:nth-child(3)>div>input:nth-child(1)")).click();
		
		// fill the details -  You
		
		System.out.println("Stock found on row "+ rowNum);
		
	}

}
