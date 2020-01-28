package cucumber.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import screens.LoginScreen;
import util.ThreadLocalDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class SetUp {
	protected DesiredCapabilities capabilities = new DesiredCapabilities();
	protected AndroidDriver driver;
	
	public SetUp(AppiumDriver androidDriver) {
		this.driver = (AndroidDriver) androidDriver;
	}
	
	@BeforeMethod
	@Parameters({"deviceName", "UDID", "platformVersion", "node_port"})
	public void init(String deviceName, String UDID, String platformVersion, String node_port) throws IOException {
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
		File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
		try {
			driver.pushFile("/sdcard/Pictures/DE_RECEIPT1.jpg", Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		URL url = new URL("http://localhost:" + node_port + "/wd/hub");
		driver = new AndroidDriver(url, capabilities);
		ThreadLocalDriver.setTLDriver(driver);
		System.out.println("Cucumber Base Test Before-login-test-cucumber");
		
		System.out.println("deviceName: " + deviceName);
		System.out.println("udid: " + UDID);
		System.out.println("session: " + driver.getSessionId());
		
		
	}
	
	
}