package screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class IOSLoginScreen extends BaseScreen implements LoginScreen {
	
	/*private String loginScreenTitleId = "com.lunchit.android.beta:id/start_welcome_text";
	
	private String loginScreenTitle = "Welcome to the largest cafeteria in the world.";
	*/
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
	
	public void checkLoginScreenTitle() {
	
	}
	
	/*public void checkLoginScreenTitle () {
			sleep(10000);
			waitVisibility(By.id(loginScreenTitleId));
			assertEquals(getText(By.id(loginScreenTitleId)), loginScreenTitle);
		}
		*/
	public void enterLogin(String login) {
		By emailElement=By.name(emailField);
		closeInstBug();
		waitAndClick(emailElement);
		//clearText(emailElement);
		sendText(emailElement, login);
	}
	
	public void enterPassword(String passwordValue) {
		By passwordElement=By.name(passwordField);
		waitAndClick(passwordElement);
		//clearText(passwordElement);
		sendText(passwordElement, passwordValue);
	}
	
	public void clickLogin() {
		waitAndClick(By.name(btnLogin));
		disabeFaceId();
		allowNotifications();
		closeFireBase();
	}
	
	public void disabeFaceId() {
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
	//	if (isElementPresent(MobileBy.ByAccessibilityId.id(allowNotificationsButton))) {
		//	click(By.name(allowNotificationsButton));
			//System.out.println("Allow Notifications ....");
	//	}
		/*driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();*/
		//driver.executeAsyncScript("mobile: alert', {'action': 'accept', 'buttonLabel': 'Allow'}");
	}
	
	
}
