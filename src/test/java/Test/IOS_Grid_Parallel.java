package Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOS_Grid_Parallel {
    
    public IOSDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    @Parameters({"deviceName","platformVersion","node_port"})
    public void setUp(String deviceName, String platformVersion, String node_port ) throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
        File appDir = new File(classpathRoot, "/src/app/iOS");
        File app = new File(appDir, "LUNCHIT_RC.app");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY, "grouped");
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, "true");
       
        capabilities.setCapability(IOSMobileCapabilityType.SUPPORTS_ALERTS, true);
       //capabilities.setCapability("app","settings");
     
        capabilities.setCapability("fullReset", "false");
        /*capabilities.setCapability("noReset", "false");*/
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("printPageSourceOnFindFailure", "true");
        URL url = new URL("http://localhost:" + node_port +"/wd/hub");
        System.out.println("url: "+url.toString());
       
        driver = new IOSDriver<MobileElement>(url, capabilities);
        
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
         
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void LunchitTest() {
        
        System.out.println("capabilities: "+capabilities.toString());
    
        WebDriverWait wait = new WebDriverWait(driver, 60 /*timeout in seconds*/);
       
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        MobileElement el2 = (MobileElement) driver.findElementByName("E-Mail Adress");
        el2.clear();
        el2.sendKeys("oscar.izquierdo@spendit.de");
        MobileElement el3 = (MobileElement) driver.findElementByName("Password");
        el3.clear();
        el3.sendKeys("Spendoscar1029");
        MobileElement el4 = (MobileElement) driver.findElementByName("Log In");
        el4.click();
    
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"No\"]");
        el5.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement allow = (MobileElement)driver.findElementByAccessibilityId("Allow");
        if (allow.isEnabled()){
            System.out.println("alert is present");
            allow.click();
        }
        
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("context"+driver.getContext());
       
    
    }
    @AfterClass
    public void tearDown() {
    /*    if (driver != null) {
            driver.quit();
        } else {
            return;
        }*/
    }

}
