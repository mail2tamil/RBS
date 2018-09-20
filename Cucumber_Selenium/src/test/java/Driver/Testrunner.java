package Driver;
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import StepDefinitionFiles.CommonFunctionalities;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/Feature_Files"
        ,glue= "StepDefinitionFiles",
        tags="@Test001,@Test002",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
        monochrome = true
                )

public class Testrunner 
{
	@BeforeClass
	public static void initializeDriver() 
    {
		CommonFunctionalities.IntiatlizeDriver();
    }
    @AfterClass
    public static void writeExtentReport() 
    {
        Reporter.loadXMLConfig(new File("config/report.xml"));       
        CommonFunctionalities.driver.quit();
    }
  
}
 

