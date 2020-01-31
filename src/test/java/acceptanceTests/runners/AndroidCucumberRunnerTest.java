package acceptanceTests.runners;

import io.appium.java_client.android.AndroidDriver;
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
		features = "src/test/resources/features"
		,glue = "acceptanceTests.steps.def"
		, tags = {"@android and @e2e"}
		, monochrome = true
		, strict = true,
		plugin = {"pretty",
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
		File app = new File(appDir, "app-beta-debug.apk");
		System.out.println("app dir: " + app.getAbsolutePath());
		
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
		System.out.println("settings: " + driver.getCapabilities());
		File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
		try {
			driver.pushFile("/sdcard/Pictures/DE_RECEIPT1.jpg", Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("deviceName: " + deviceName);
		System.out.println("udid: " + UDID);
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