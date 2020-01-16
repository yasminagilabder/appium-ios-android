package Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test_AndroidUI {
    
    private RemoteWebDriver driver;
    
    @Test
    public void testLunchit() {
       
        
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_email");
        el2.sendKeys("happyspendit.de.test1@gmail.com");
        MobileElement el3 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_password");
        el3.sendKeys("lindaBrown124!");
        MobileElement el4 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/btn_login");
        el4.click();
    }
}
