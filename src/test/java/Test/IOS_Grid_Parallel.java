package Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOS_Grid_Parallel {

    AppiumDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    @Parameters({"deviceName","platformVersion","node_port"})
    public void setUp(String deviceName, String platformVersion, String node_port ) throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/app/iOS");
        File app = new File(appDir, "LUNCHIT_RC.ipa");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("automationName", "XCUITest");
        URL url = new URL("http://localhost:" + node_port +"/wd/hub");
        System.out.println("url: "+url.toString());
       // capabilities.setCapability("noReset", "true");
        driver = new IOSDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void advertiseTest() {
        System.out.println("capabilities: "+capabilities.toString());
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        } else {
            return;
        }
    }

}
