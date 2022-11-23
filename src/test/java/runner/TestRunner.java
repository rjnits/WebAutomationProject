package runner;

import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {".\\src\\main\\java\\features\\loginPageValidationScenario.feature" }, 
				   glue = {"stepdefinations" }, 
				   plugin = { "com.cucumber.listener.ExtentCucumberFormatter:ExtentReports/report.html" }
				)

public class TestRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void setup() {
		
		Reporter.loadXMLConfig(".\\src\\main\\resources\\extent-config.xml");
		Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "Raju Das");
		Reporter.setSystemInfo("Application Name", "Web Application");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}

}