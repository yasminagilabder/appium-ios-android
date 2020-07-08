package acceptanceTests.runners;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import util.driver.ThreadLocalDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "acceptanceTests.steps.def",
		tags = {"@ios"},
		monochrome = true,
		strict = true,
		plugin = {"pretty",
				"json:target/cucumber.json",
				"html:target/ios_cucumber-reports/reports"}
)

public class IOSCucumberRunnerTest {
	private TestNGCucumberRunner testNGCucumberRunner;
	private IOSDriver driver;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	
	@BeforeClass
	@Parameters({"deviceName","platformVersion","node_port","wda"})
	public void setUp(String deviceName, String platformVersion, String node_port, String wda) throws IOException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/src/app/iOS/");
		File app = new File(appDir, "AcquaintNativeiOS.app");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("automationName","XCUITest");
		capabilities.setCapability("noReset", true);
	/*	capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wda);
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, "true");
		capabilities.setCapability(IOSMobileCapabilityType.SHOW_IOS_LOG, "false");
		capabilities.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, "false");
		capabilities.setCapability(IOSMobileCapabilityType.ACCEPT_INSECURE_CERTS, "true");
		capabilities.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, "false");
		capabilities.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, "true");
		capabilities.setCapability(IOSMobileCapabilityType.WAIT_FOR_APP_SCRIPT, "true");
		capabilities.setCapability(IOSMobileCapabilityType.SUPPORTS_ALERTS, "true");*/
		//capabilities.setCapability(IOSMobileCapabilityType.CONNECT_HARDWARE_KEYBOARD, "true");
		URL url = new URL("http://localhost:" + node_port +"/wd/hub");
		driver = new IOSDriver(url, capabilities);
		System.out.println("URL: " + url);
		System.out.println("deviceName: " + deviceName);
		System.out.println("session: " + driver.getSessionId());
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
		if (driver!=null) driver.closeApp();
	}
}