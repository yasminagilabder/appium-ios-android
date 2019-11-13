package AppiumSupport;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;


public class AppiumController {
	
	public static OS executionOS = OS.ANDROID;
	
	public enum OS {
		ANDROID,
		IOS
	}
	
	public static AppiumController instance = new AppiumController();
	public AppiumDriver driver;
	
	public void start()  {
		if (driver != null) {
			return;
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (executionOS) {
			case ANDROID:
				File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/app/Android");
				File app = new File(appDir, "Contacts.apk");
				capabilities.setCapability("app", app.getAbsolutePath());
			/*	capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("deviceName", "NotUsed");
				
				capabilities.setCapability("appPackage", "com.jayway.contacts");
				capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
				capabilities.setCapability("automationName", "UiAutomator2");
				capabilities.setCapability("fullReset", true);
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			*/	break;
			case IOS:
				classpathRoot = new File(System.getProperty("user.dir"));
				appDir = new File(classpathRoot, "/app/iOS/");
				app = new File(appDir, "LUNCHITBeta 2.app");
			/*	capabilities.setCapability("platformName", "ios");
				capabilities.setCapability("deviceName", "iPhone 7");
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("automationName", "XCUITest");
				capabilities.setCapability("noReset", true);
				driver = new IOSDriver(new URL("http://127.0.0.1:4722/wd/hub"), capabilities);
			*/	break;
		}
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
