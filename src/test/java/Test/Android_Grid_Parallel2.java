package Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import java.util.concurrent.TimeUnit;

public class Android_Grid_Parallel2 {
    
    public AndroidDriver androidDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    
    
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
        //capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        // capabilities.setCapability("uiautomator2ServerLaunchTimeout",40000);
        capabilities.setCapability("printPageSourceOnFindFailure", "true");
        // capabilities.setCapability("clearSystemFiles","true");
        //capabilities.setCapability("autoDismissAlerts", true);
        URL url = new URL("http://localhost:" + node_port + "/wd/hub");
        androidDriver = new AndroidDriver(url, capabilities);
        
        
        //   File receiptDir2 = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT2.jpg");
        // androidDriver.pushFile("/sdcard/Pictures//DE_RECEIPT2.jpg", Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir2)));
        System.out.println("deviceName: " + deviceName);
        System.out.println("udid: " + UDID);
        System.out.println("session: " + androidDriver.getSessionId());
    
    
        androidDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
    
    @Test
    public void testLunchit() throws InterruptedException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        System.out.println("settings: " + androidDriver.getCapabilities());
        MobileElement el1 = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
        el1.click();
        //androidDriver.hideKeyboard();
       
        MobileElement el2 = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/aet_email");
       
        el2.sendKeys("happyspendit+jose1fz2707@gmail.com");
        MobileElement el3 = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/aet_password");
        el3.sendKeys("aaaaaaaaa1-");
        MobileElement el4 = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/btn_login");
        el4.click();
        MobileElement close = (MobileElement) androidDriver.findElementById("com.lunchit.android.beta:id/close_happy");
        close.click();
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/addReceipt"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/btn_close"))).click();
        Thread.sleep(2000);
        File receiptDir1 = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
        try {
            androidDriver.pushFile("/sdcard/Pictures/DE_RECEIPT1.jpg", Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.documentsui:id/icon_thumb"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/btnVerify"))).click();
        //Thread.sleep(1000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/amountValue"))).click();
        //androidDriver.hideKeyboard();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/amountValue"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/amountValue"))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/amountValue"))).sendKeys("300");
        //	androidDriver.getKeyboard().sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebDriverWait waitConditions = new WebDriverWait(androidDriver, 20);
        //androidDriver.hideKeyboard();
        waitConditions.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/legalSwitch"))).click();
        waitConditions.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/submitButton"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/done_button"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/closeFeedback"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/receiptsContainer"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout"))).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/deleteButton"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/removeReceipt"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lunchit.android.beta:id/done_button"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))).click();
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Logout\").instance(0))").click();
        
    }
    @AfterClass
    public void tearDown() {
       if (androidDriver!=null){
            androidDriver.quit();
        }
    }

   

}
