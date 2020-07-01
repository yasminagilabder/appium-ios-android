package screens.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.common.BaseScreen;
import screens.interfaces.LoginScreen;


public class IOSLoginScreen extends BaseScreen implements LoginScreen {


    private String emailField = "//XCUIElementTypeOther[@name=\"loginView_emailTextField\"]/XCUIElementTypeTextField";
    private String passwordField = "//XCUIElementTypeOther[@name=\"loginView_passwordTextField\"]/XCUIElementTypeSecureTextField";

    private String btnLogin = "loginView_loginButton";
    private String toggleFirebase = "//XCUIElementTypeApplication[@name=\"Lunchit RC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch";

    private String closeFirebase = "//XCUIElementTypeButton[@name=\"close icon\"]";

    private String noFaceIdButton = "//XCUIElementTypeStaticText[@name=\"No\"]";


    public IOSLoginScreen(IOSDriver driver) {
        super(driver);
    }

    public void checkScreenFormat() {
        sleep(5000);
    }

    public void enterLogin(String login) {
        sleep(5000);
        WebElement element = driver.findElementByXPath(emailField);
        element.click();
        element.clear();
        element.sendKeys(login);
    }

    public void enterPassword(String passwordValue) {
        WebElement element = driver.findElementByXPath(passwordField);
        element.clear();
        element.click();
        element.sendKeys(passwordValue);
    }

    public void submit() {
        WebElement element = driver.findElementByAccessibilityId(btnLogin);
        element.click();
        allowNotifications();
        closeFireBase();
    }

    public void closeFireBase() {
        sleep(5000);
        WebElement element = driver.findElementByXPath(toggleFirebase);
        element.click();
        System.out.println("Enable Firebase ....");
        WebElement elementFirebase = driver.findElementByAccessibilityId("close icon");
        elementFirebase.click();
        System.out.println("Closing Firebase screen ....");
    }

    public void allowNotifications() {
        sleep(10000);
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
