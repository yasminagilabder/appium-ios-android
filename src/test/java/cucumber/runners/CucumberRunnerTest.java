package cucumber.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import util.Context;
import util.ThreadLocalDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@CucumberOptions(
      
        features = "src/test/resources/Features"
        ,glue="cucumber.steps"
        ,tags = {"@wip"}
        ,monochrome = true
        ,strict = true,
        plugin = {"pretty",
                "html:target/cucumber-reports/reports"}
                )
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;
    protected DesiredCapabilities capabilities = new DesiredCapabilities();
    protected AndroidDriver driver;
    private Context context;

   @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    
    @BeforeMethod
    @Parameters({"deviceName", "UDID", "platformVersion", "node_port"})
    public void init(String deviceName, String UDID, String platformVersion, String node_port) throws IOException {
        System.out.println("Cucumber Base Test Before-login-test-cucumber");
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/app/Android");
        File app = new File(appDir, "app-beta-debug.apk");
        
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("fullReset", "true");
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("printPageSourceOnFindFailure", "true");
        URL url = new URL("http://localhost:" + node_port + "/wd/hub");
        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
        try {
            driver.pushFile("/sdcard/Pictures/DE_RECEIPT1.jpg", Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("deviceName: " + deviceName);
        System.out.println("udid: " + UDID);
        System.out.println("session: " + driver.getSessionId());
        ThreadLocalDriver.setTLDriver(driver);
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
