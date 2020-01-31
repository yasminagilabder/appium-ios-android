package acceptanceTests.runners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import util.ThreadLocalDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@CucumberOptions(

		features = "src/test/resources/features/",
		glue = "acceptanceTests.steps.def"
		, tags = {"@ios"}
		, monochrome = true
		, strict = true,
		plugin = {"pretty",
				"html:target/ios_cucumber-reports/reports"}
)


public class IOSCucumberRunnerTest {
	private TestNGCucumberRunner testNGCucumberRunner;
	private IOSDriver driver;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	
	@BeforeClass
	@Parameters({"deviceName","platformVersion","node_port"})
	public void setUp(String deviceName, String platformVersion, String node_port ) throws IOException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
		File appDir = new File(classpathRoot, "/src/app/iOS");
		File app = new File(appDir, "LUNCHIT_RC.app");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("automationName","XCUITest");
		capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY, "grouped");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, "true");
		capabilities.setCapability("fullReset", "false");
		URL url = new URL("http://localhost:" + node_port +"/wd/hub");
		System.out.println("url: "+url.toString());
		driver = new IOSDriver(url, capabilities);
		System.out.println("deviceName: " + deviceName);
		System.out.println("session: " + driver.getSessionId());
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		ThreadLocalDriver.setTLDriver(driver);
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
		System.out.println("scenario....");
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}
	
	@DataProvider
	public Object[][] scenarios() {
		System.out.println("scenarios....");
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		System.out.println("tearDownClass....");
		testNGCucumberRunner.finish();
	}
}