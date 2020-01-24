package cucumber.runners;
import Test.BaseTestAndroid;


import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(

        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "cucumber/features/Login.feature"
        ,glue="cucumber.steps.LoginSteps.java"
        ,tags = {"not @deferred"}
        ,monochrome = true
        ,strict = true,
        plugin = {"pretty",
                "html:target/cucumber-reports/reports"}
                )
public class RunCucumberFeatures extends BaseTestAndroid{

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs LoginCandiate Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("Cucumber Test Class Inside Test");
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
  
    @DataProvider
    public Object[][] features() {
        System.out.println("Data Provider test Class");
        return testNGCucumberRunner.provideFeatures();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}
