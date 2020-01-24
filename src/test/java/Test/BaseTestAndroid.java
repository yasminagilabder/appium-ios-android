package Test;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestAndroid {

    public WebDriverWait wait;
    public AndroidDriver androidDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    
    //private ThreadLocalDriver threadLocalDriver = new ThreadLocalDriver();
    //Base Screens for all cases
  /*  protected SplashScreen splashScreen = null;
    protected TutorialScreen tutorialScreen = null;
    protected SelectionScreen selectionScreen = null;
    protected CandidateMainScreen candidateMainScreen = null;*/
    
    @BeforeMethod
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
        File receiptDir = new File(classpathRoot, "/src/test/resources/receipts/DE_RECEIPT1.jpg");
        try {
            androidDriver.pushFile("/sdcard/Pictures/DE_RECEIPT1.jpg", Base64.encodeBase64(FileUtils.readFileToByteArray(receiptDir)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL url = new URL("http://localhost:" + node_port + "/wd/hub");
        androidDriver = new AndroidDriver(url, capabilities);
        
        System.out.println("deviceName: " + deviceName);
        System.out.println("udid: " + UDID);
        System.out.println("session: " + androidDriver.getSessionId());
        
        
        androidDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
    /*@AfterMethod
    public synchronized void teardown(){
        ThreadLocalDriver.getTLDriver().quit();
    }*/
    @AfterClass
    public void tearDown() {
        if (androidDriver!=null){
            androidDriver.quit();
        }
    }
}
