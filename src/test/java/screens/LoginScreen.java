package screens;

import cucumber.steps.SetUp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ThreadLocalDriver;

public class LoginScreen extends BaseScreen{
    
    private AppiumDriver driver;
    WebDriverWait wait;
    protected SetUp setUp;
    
    
    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
       
    }
    
    public void enterLogin (String login) throws InterruptedException {
        Thread.sleep(1000);
        driver=ThreadLocalDriver.getTLDriver();
      /*  MobileElement init = (MobileElement) driver.findElementById("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
        init.click();*/
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout"))).click();
        MobileElement elLogin = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_email");
        elLogin.click();
        //wait.until(ExpectedConditions.elementToBeClickable(elLogin)).click();
        
        MobileElement el2 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_email");
        el2.sendKeys("happyspendit.de.test1@gmail.com");
        MobileElement el3 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_password");
        el3.sendKeys("lindaBrown124!");
        MobileElement el4 = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/btn_login");
        el4.click();
        MobileElement close = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/close_happy");
        close.click();
    }
    public void enterPassword (String password) {
       // sendText(By.id(telephoneNumber), cellPhoneNumber);
        //hideKeyboard();
    }
    public void clickSubmit () {
       // waitAndClick(By.id(loginButton));
    }
    

}
