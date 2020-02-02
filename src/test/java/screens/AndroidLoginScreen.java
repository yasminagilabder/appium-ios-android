package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginScreen extends BaseScreen implements LoginScreen  {
	
	private String emailField = "com.lunchit.android.beta:id/aet_email";
	
	private String passwordField = "com.lunchit.android.beta:id/aet_password";
	
	private String btnLogin = "com.lunchit.android.beta:id/btn_login";
	
	private String skipInstbug= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout";
	
	private String toggleFirebase = "com.lunchit.android.beta:id/ga_switch";
	
	private String closeFirebase = "com.lunchit.android.beta:id/close_happy";
	
	
	public AndroidLoginScreen(AndroidDriver driver) {
		super(driver);
	}
	
	
	public void checkLoginScreenFormat() {
		sleep(10000);
		waitVisibility(By.id(emailField));
		waitVisibility(By.id(passwordField));
		waitVisibility(By.id(btnLogin));
	}
	
	public void enterLogin(String login) {
		sendText(By.id(emailField),login);
		
	}
	
	public void enterPassword(String password) {
		sendText(By.id(passwordField), password);
	}
	
	
	public void submit() {
		waitAndClick(By.id(btnLogin));
		closeFireBase();
		
	}
	
	public void closeFireBase(){
		sleep(10000);
		if (isElementPresent(By.id(toggleFirebase))){
			waitAndClick(By.id(toggleFirebase));
			waitAndClick(By.id(closeFirebase));
			System.out.println("Enabling Firebase ....");
		}
	}
	
	
}
