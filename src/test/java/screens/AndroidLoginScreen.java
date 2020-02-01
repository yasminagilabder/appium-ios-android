package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidLoginScreen extends BaseScreen implements LoginScreen {
	

	
	
	private String emailField = "com.lunchit.android.beta:id/aet_email";
	
	private String passwordField = "com.lunchit.android.beta:id/aet_password";
	
	private String btnLogin = "com.lunchit.android.beta:id/btn_login";
	
	private String skipInstbug = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout";
	
	private String toggleFirebase = "com.lunchit.android.beta:id/ga_switch";
	
	private String forgotPassword = "com.lunchit.android.beta:id/btn_forgot_password";
	
	private String closeFirebase = "com.lunchit.android.beta:id/close_happy";
	
	private String noAccountLink = "com.lunchit.android.beta:id/tv_test_as_guest";
	
	private String acceptLegalConditions = "com.lunchit.android.beta:id/tv_accept_legals";
	
	
	public AndroidLoginScreen(AndroidDriver driver) {
		super(driver);
	}
	
	
	public void checkLoginScreenFormat() {
		sleep(10000);
		
		//assertThat("Title is not present", isElementPresent(By.id(loginScreenTitleId)));
/*		assertThat("'Forgot password' is not present", isElementPresent(By.id(forgotPassword)));
		assertThat("'No account link' is not present", isElementPresent(By.id(noAccountLink)));
		assertThat("'Accept legal conditions link' is not present", isElementPresent(By.id(acceptLegalConditions)));*/
	}
	
	public void enterLogin(String login) {
	
		By emailElement = By.id(emailField);
		//click(emailElement);
		sendText(emailElement, login);
	}
	
	public void enterPassword(String passwordValue) {
		By passwordElement = By.id(passwordField);
		//click(passwordElement);
		sendText(passwordElement, passwordValue);
		
	}
	
	public void clickLogin() {
		By loginElement = By.id(btnLogin);
		
		//click(loginElement);
		//closeFireBase();
	}
	
	public void closeInstBug() {
		if (isElementPresent(By.xpath(skipInstbug))) {
			waitAndClick(By.xpath(skipInstbug));
			System.out.println("Closing InstaBug screen....");
		}
	}
	
	public void closeFireBase() {
		sleep(10000);
		if (isElementPresent(By.id(toggleFirebase))) {
			waitAndClick(By.id(toggleFirebase));
			waitAndClick(By.id(closeFirebase));
			System.out.println("Enable Firebase ....");
		}
	}
	
	
}



