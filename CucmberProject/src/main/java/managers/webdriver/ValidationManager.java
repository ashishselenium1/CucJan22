package managers.webdriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ValidationManager extends GenericManager{
	
	public void validateElementPresent(String locatorKey,boolean stopOnFailure) {
		log("Validating element presence "+ locatorKey);
		if(!isElementPresent(locatorKey)) {
			// report a failure + stop the test
			reportFailure("Element not found "+ locatorKey,stopOnFailure);
		}
		
	}
	
	public void validateTitle(String expectedTitleKey,boolean stopOnFailure) {
		String actualTitle=driver.getTitle();
		String expectedTitle=getProperty(expectedTitleKey);
		if(!actualTitle.equals(expectedTitle)) {
			reportFailure("Titles did not match",stopOnFailure);
		}
		
	}
	
	public void validateOptionPresentInDropDown(String locatorkey, String option ,boolean stopOnFailure) {
		wait(3);
		Select s = new Select(getObject(locatorkey));
		List<WebElement> allOptions = s.getOptions();
		for(WebElement o:allOptions) {
			if(o.getText().equals(option))
				return;
		}
		reportFailure("Option Not Present"+option,stopOnFailure);
	
		
	}


}
