package managers.webdriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class WebDriverManager extends ValidationManager{
	
	public WebDriverManager() {
		prop = new Properties();
		String path = System.getProperty("user.dir")+"//src//test//resources//project.properties";
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void login() {
		log("Logging In");
		//validateTitle("home_page_title",false);// collect failure
		type("username_textfield_xpath", getProperty("defaultUsername"));
		type("password_textfield_css", getProperty("defaultPassword"));
		validateElementPresent("login_submit_button_id",true);// report failure and immediately stop
		click("login_submit_button_id");
	}
	
	
	public void buyStock() {
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
