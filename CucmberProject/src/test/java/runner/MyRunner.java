package runner;
//https://github.com/ashishselenium1/jan_22.git
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		 features = "src/test/resources",
         glue = {"steps"},
         plugin = { "html:target/cucumber-reports.html","rerun:rerun/failed_scenarios.txt"},       
		 tags = "@CreatePortfolio",
         monochrome = true,
         dryRun = false         	
		 )
public class MyRunner extends AbstractTestNGCucumberTests {

}