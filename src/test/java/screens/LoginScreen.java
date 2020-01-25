package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    //Mobile Elements
    String telephoneNumber = "com.isinolsun.app:id/login_phone_number";
    String loginButton = "com.isinolsun.app:id/login";



    public void enterLogin (String login) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout"))).click();
        MobileElement elLogin = (MobileElement) driver.findElementById("com.lunchit.android.beta:id/aet_email");
        wait.until(ExpectedConditions.elementToBeClickable(elLogin)).click();
        
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
