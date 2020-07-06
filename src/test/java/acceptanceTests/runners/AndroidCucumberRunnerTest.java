package acceptanceTests.runners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import util.driver.ThreadLocalDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"acceptanceTests.steps.def"},
        tags = {"@android"},
        monochrome = true,
        strict = true,
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/android_cucumber-reports/reports"}
)

public class AndroidCucumberRunnerTest {
    private TestNGCucumberRunner testNGCucumberRunner;
    private AndroidDriver driver;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    @Parameters({"deviceName", "UDID", "platformVersion", "node_port"})
    public void setUp(String deviceName, String UDID, String platformVersion, String node_port) throws IOException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/app/Android");
        File app = new File(appDir, "com.xamarin.acquaintnative.apk");

        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("printPageSourceOnFindFailure", true);
        capabilities.setCapability("autoLaunch", "true");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 30000);
        capabilities.setCapability(AndroidMobileCapabilityType.ADB_EXEC_TIMEOUT, 90000);
        capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);


        URL url = new URL("http://localhost:" + node_port + "/wd/hub");
        System.out.println("URL: " + url.toString());
        driver = new AndroidDriver(url, capabilities);
        System.out.println("settings: " + driver.getCapabilities());
        System.out.println("deviceName: " + deviceName);
        System.out.println("udid: " + UDID);
        System.out.println("session: " + driver.getSessionId());
        ThreadLocalDriver.setTLDriver(driver);
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        System.out.println("Scenario....");
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner != null) {
            System.out.println("Scenarios....");
            return testNGCucumberRunner.provideScenarios();
        } else {
            System.out.println("Did you run the setup script as in Readme?");
            return null;
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        System.out.println("tearDownClass....");
        testNGCucumberRunner.finish();

    }
}