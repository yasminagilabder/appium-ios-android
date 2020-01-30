package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginScreen extends BaseScreen implements LoginScreen  {
	
	private String loginScreenTitleId = "com.lunchit.android.beta:id/start_welcome_text";
	
	private String loginScreenTitle = "Welcome to the largest cafeteria in the world.";
	
	private String emailField = "com.lunchit.android.beta:id/aet_email";
	
	private String passwordField = "com.lunchit.android.beta:id/aet_password";
	
	private String btnLogin = "com.lunchit.android.beta:id/btn_login";
	
	private String skipInstbug= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout";
	
	private String toggleFirebase = "com.lunchit.android.beta:id/ga_switch";
	
	private String closeFirebase = "com.lunchit.android.beta:id/close_happy";
	
	
	public AndroidLoginScreen(AndroidDriver driver) {
		super(driver);
	}
	
	public void checkLoginScreenTitle () {
		sleep(10000);
		waitVisibility(By.id(loginScreenTitleId));
		assertEquals(getText(By.id(loginScreenTitleId)), loginScreenTitle);
	}
	
	public void enterLogin(String login) {
		sleep(5000);
		closeInstBug();
		waitAndClick(By.id(emailField));
		sendText(By.id(emailField),login);
		closeInstBug();
	}
	
	public void enterPassword(String passwordValue) {
		waitAndClick(By.id(passwordField));
		sendText(By.id(passwordField), passwordValue);
	}
	
	public void clickLogin() {
		waitAndClick(By.id(btnLogin));
		closeFireBase();
	}
	
	public void closeInstBug(){
		if (isElementPresent(By.xpath(skipInstbug))){
			waitAndClick(By.xpath(skipInstbug));
			System.out.println("Closing InstaBug screen....");
		}
	}
	public void closeFireBase(){
		sleep(10000);
		if (isElementPresent(By.id(toggleFirebase))){
			waitAndClick(By.id(toggleFirebase));
			waitAndClick(By.id(closeFirebase));
			System.out.println("Enable Firebase ....");
		}
	}
	
	
}
