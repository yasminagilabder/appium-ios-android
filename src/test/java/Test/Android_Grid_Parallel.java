package Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android_Grid_Parallel {
    
    public AndroidDriver androidDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    
    
    @BeforeClass
    @Parameters({"deviceName","UDID", "platformVersion","node_port"})
    public void setUp(String deviceName,String UDID, String platformVersion, String node_port ) throws IOException {
        
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/app/Android");
        File app = new File(appDir, "app-beta-debug.apk");
        System.out.println("app dir: "+app.getAbsolutePath());
       
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        URL url = new URL("http://localhost:" + node_port +"/wd/hub");
        androidDriver = new AndroidDriver(url, capabilities);
        File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT.jpg");
        androidDriver.pushFile("/sdcard/DE_RECEIPT.jpg", Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir)));
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("uiautomator2ServerLaunchTimeout",40000);
        System.out.println("deviceName: "+deviceName);
        System.out.println("udid: "+UDID);
        androidDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
    
    @Test
    public void testLunchit() throws InterruptedException {
        
        System.out.println("capabilities: "+capabilities.toString());
        MobileElement el1 = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
        el1.click();
        MobileElement el2 = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/aet_email");
        el2.sendKeys("happyspendit.de.test1@gmail.com");
        MobileElement el3 = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/aet_password");
        el3.sendKeys("lindaBrown124!");
        MobileElement el4 = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/btn_login");
        el4.click();
        MobileElement close = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/close_happy");
        close.click();
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/addReceipt"))).click();
        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/btn_close");
        el6.click();
        
       
    
    
    }
    @AfterClass
    public void tearDown() {
        /*if (androidDriver!=null){
            androidDriver.quit();
        }*/
    }

   

}
