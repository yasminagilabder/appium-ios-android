package Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class IOS_Grid_Parallel {
    
    public IOSDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    @Parameters({"deviceName","platformVersion","node_port"})
    public void setUp(String deviceName, String platformVersion, String node_port ) throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
       /* byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir.getCanonicalFile()));
        (AppiumDriver)driver.pushFile("/sdcard/",encoded);*/
// push the file -- note that it's important it's just the bare basename of the file
       
        File appDir = new File(classpathRoot, "/src/app/iOS");
        File app = new File(appDir, "LUNCHIT_RC.app");
        capabilities.setCapability("app", app.getAbsolutePath());
      
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("automationName","XCUITest");
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
       
        driver = new IOSDriver(url, capabilities);
        
        
        try {
            Thread.sleep(2000);
         
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void LunchitTest() throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT2.jpg");
    
        //receiptDir1.getAbsolutePath()+"/sdcard/DE_RECEIPT1.jp
       
        //driver.pushFile("/sdcard1/User/img1.jpg", fileContent);
        
        System.out.println("capabilities: "+capabilities.toString());
   // driver.executeScript(new String[]{"xcrun", "simctl", "addmedia", deviceUDID, pathToFile + fileName});
    
    
       /* String command = "mobile:xcrun simctl addmedia D4A14667-1951-4D09-88B0-B61E490C0311";
        Map<String, Object> params = new HashMap();
        params.put("path", receiptDir.getAbsolutePath());
        Object result = driver.execute(command, params);*/
        WebDriverWait wait = new WebDriverWait(driver, 60 /*timeout in seconds*/);
       
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      /*  MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
        el1.click();
    */
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
        MobileElement instbug = (MobileElement)driver.findElementByClassName("UITransitionView");
        instbug.click();
        
        System.out.println("clicked");
       
       
    
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
