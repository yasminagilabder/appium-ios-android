package screens.ios;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.LoginScreen;
import util.category.Category;

public class IOSLoginScreen extends BaseScreen implements LoginScreen {
	
	private String loginScreenTitleId = "Welcome to the largest cafeteria in the world.";
	
	private String loginScreenTitle = "Welcome to the largest cafeteria in the world.";
	
	private String emailField = "E-Mail Adress";
	
	private String passwordField = "Password";
	
	private String btnLogin = "Log In";
	
	//private String skipInstbug= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout";
	
	private String toggleFirebase = "//XCUIElementTypeApplication[@name=\"Lunchit RC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch";
	
	private String closeFirebase = "icon close";
	
	private String noFaceIdButton = "//XCUIElementTypeStaticText[@name=\"No\"]";
	//private String allowNotificationsButton = "Allow";
	
	private String allowNotificationsButton = "//XCUIElementTypeButton[@name=\"Allow\"]";
	
	public IOSLoginScreen(IOSDriver driver) {
		super(driver);
	}



	public void checkScreenFormat(){

		sleep(10000);
		waitVisibility(MobileBy.ByAccessibilityId.id(loginScreenTitleId));
		assertEquals(getText(MobileBy.ByAccessibilityId.id(loginScreenTitleId)), loginScreenTitle);
	}
	
	public void enterLogin(String login) {
		By emailElement = By.name(emailField);
		closeInstBug();
		waitAndClick(emailElement);
		sendText(emailElement, login);
	}
	
	public void enterPassword(String passwordValue) {
		By passwordElement = By.name(passwordField);
		waitAndClick(passwordElement);
		sendText(passwordElement, passwordValue);
	}
	
	public void submit() {
		waitAndClick(By.name(btnLogin));
		disableFaceId();
		allowNotifications();
		closeFireBase();
	}
	
	public void disableFaceId() {
		if (isElementPresent(By.xpath(noFaceIdButton))) {
			waitAndClick(By.xpath(noFaceIdButton));
			System.out.println("Disabling Face ID....");
		}
	}
	
	public void closeInstBug() {
		sleep(20000);
	}
	
	public void closeFireBase() {
		click(By.xpath(toggleFirebase));
		System.out.println("Enable Firebase ....");
		click(MobileBy.ByAccessibilityId.id(closeFirebase));
		System.out.println("Closing Firebase screen ....");
	}
	
	public void allowNotifications() {
		sleep(3000);
	}
	
	
}
