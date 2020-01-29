package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import util.ThreadLocalDriver;

public class LoginScreen extends BaseScreen{
    
    private AppiumDriver driver;
    private String email="com.lunchit.android.beta:id/aet_email";
    private String password="com.lunchit.android.beta:id/aet_password";
    private String btnLogin="com.lunchit.android.beta:id/btn_login";
    private String firebase ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout";
    
    public LoginScreen(AppiumDriver driver) {
        
        
        super(driver);
    }
   
    public void enterLogin (String login){
        sleep(1000);
        waitAndClick(By.xpath(firebase));
        waitAndClick(By.id(email));
        sendText(By.id(email),login);
    }
    
    public void enterLogin2 (String login) throws InterruptedException {
        Thread.sleep(1000);
        driver=ThreadLocalDriver.getTLDriver();
        MobileElement init = (MobileElement) driver.findElementById("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
        init.click();
        MobileElement elLogin = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_email");
        elLogin.click();
       
        MobileElement el2 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_email");
        el2.sendKeys("happyspendit.de.test1@gmail.com");
        
        
        MobileElement el3 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_password");
        el3.sendKeys("lindaBrown124!");
        
        MobileElement el4 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/btn_login");
        el4.click();
        MobileElement close = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/close_happy");
        close.click();
    }
    public void enterPassword (String passwordValue) {
       waitAndClick(By.id(password));
        sendText(By.id(password),passwordValue);
    }
    public void clickLogin() {
        waitAndClick(By.id(btnLogin));
    }
    

}
