package Runner;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;


import java.io.File;

@CucumberOptions(

        plugin = {
                "html:target/cucumber-Html-Report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportEnd2End.html" // to generate a extend report we need this plugin
        },
  //      tags = {"@E2E"},
        features = {"src/test/java/FeatureFiles/Specials.feature", "src/test/java/FeatureFiles/SocialMedia.feature","src/test/java/FeatureFiles/OrderHistory.feature"},
        glue = {"StepDefinition"},
        dryRun = false
)

public class E2EScenario extends AbstractTestNGCucumberTests{

    @AfterClass
    public static void afterClass(){

        Reporter.loadXMLConfig(new File("src/test/java/FeatureFiles/extentReport.xml"));
        Reporter.setSystemInfo("User Name" , "Ekrem Can");
        Reporter.setSystemInfo("Application Name", "Basqar");
        Reporter.setSystemInfo("Operating System Type" , System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "QA");
        Reporter.setTestRunnerOutput("Test execution Cucumber report");
    }
}