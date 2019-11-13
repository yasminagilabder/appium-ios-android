package Test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android_Grid_Parallel {
    
    public AndroidDriver androidDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    
    
    @BeforeClass
    @Parameters({"deviceName","UDID", "platformVersion","node_port"})
    public void setUp(String deviceName,String UDID, String platformVersion, String node_port ) throws MalformedURLException {
        
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/app/Android");
        File app = new File(appDir, "app-beta-debug.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        URL url = new URL("http://localhost:" + node_port +"/wd/hub");
        androidDriver = new AndroidDriver(url, capabilities);
       
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("uiautomator2ServerLaunchTimeout",40000);
        System.out.println("deviceName: "+deviceName);
        System.out.println("udid: "+UDID);
        androidDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
    
    @Test
    public void advertiseTest() {
        
        System.out.println("capabilities: "+capabilities.toString());
      
    }
    @AfterClass
    public void tearDown() {
        if (androidDriver!=null){
            androidDriver.quit();
        }
    }

   

}
