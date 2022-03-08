package managers.webdriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import managers.reporting.ExtentManager;

public class GenericManager {
	
	public WebDriver driver;
	public Properties prop;
	public SoftAssert softAssert;
	public ExtentReports rep;
	public ExtentTest test;

    public void openBrowser(String browserName) {
    	log("Opening browser "+browserName);
    	if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("Mozilla")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		// presence
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void navigate(String url) {
		log("Navigating to "+getProperty(url));
		driver.get(getProperty(url));
	}
	
	public void click(String locatorKey) {
		System.out.println("Clicking on "+locatorKey);
		getObject(locatorKey).click();
	}
	
	public void type(String locatorKey, String data) {
		log("Typing in "+ locatorKey);
		getObject(locatorKey).sendKeys(data);
	}
	public void clear(String locatorKey) {
		getObject(locatorKey).clear();
	}
	
	public String getText(String locator) {
		return "";
	}
	
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void select(String locator,String option) {
		log("Selecting value from "+locator);
		WebElement e = getObject(locator);	
		Select s = new Select(e);
		s.selectByVisibleText(option);
	}
	
	/***************************************Utility Functions***********************************************/
	// true - present
	// false - not present
	// presence + visibility
	public boolean isElementPresent(String locatorKey) {
		log("Checking element presence "+ locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			By locator = getLocator(locatorKey);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}catch(Exception e) {
			// not present or  visible
			log("Element not found "+locatorKey);
			return false;
		}
		return true;	
	}
	// central function to extract the objects
	public WebElement getObject(String locatorKey) {
		if(!isElementPresent(locatorKey)) {
			// critical error -  report the failure in reports and stop the test
		}
		By locator = getLocator(locatorKey);
		return driver.findElement(locator);
	}

	// read a value from the properties file
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	// return the locator
	public By getLocator(String locatorKey) {
		String identifier=getProperty(locatorKey);
		By locator=null;
		if(locatorKey.endsWith("_id"))
			locator = By.id(identifier);
		else if(locatorKey.endsWith("_name"))
			locator = By.name(identifier);
		else if(locatorKey.endsWith("_xpath"))
			locator = By.xpath(identifier);
		 if(locatorKey.endsWith("_css"))
				locator = By.cssSelector(identifier);
		 return locator;
	}
	
	/***************************Reporting Functions*****************************************/
	public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}
	public void reportFailure(String failureMessage, boolean stopExecution) {
		System.out.println("***FAILURE - "+failureMessage);
		// fail in extent reports
		test.log(Status.FAIL, failureMessage);
		// take screenshot and put in reports
		takeScreenshot();
		// fail in cucumber with the help of testNG commands
		softAssert.fail(failureMessage);
		if(stopExecution)
			quit();
	}
	
	public void quit() {
//		if(driver!=null) 
//			driver.quit();
		
		rep.flush();
		softAssert.assertAll();
	}
	
	public void takeScreenshot() {
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			//put the screenshot in a file
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+"//"+screenshotFile));
			//put screenshot file in reports
			test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+"//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init(String scenarioName) {
		softAssert = new SoftAssert();
		rep = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
		test=rep.createTest(scenarioName);
	}
	
	
	public int getRowNumWithCellData(String tableRowsLocatorKey , String data) {
		List<WebElement> rows = driver.findElements(getLocator(tableRowsLocatorKey));
		
		for(int r=0;r<rows.size();r++) {
			WebElement row = rows.get(r);
			List<WebElement> cells= row.findElements(By.tagName("td"));
			for(int c=0;c<cells.size();c++) {
				System.out.println("--> "+cells.get(c).getText().trim());
				if(!cells.get(c).getText().trim().equals("") && data.startsWith(cells.get(c).getText().trim()))// data is found
					return (r+1);
			}
		}
		
		return -1;
		
	}
	
	
}
