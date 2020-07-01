package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.LoginScreen;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AndroidLoginScreen extends BaseScreen implements LoginScreen {
	
	private String emailField = "com.lunchit.android.beta:id/aet_email";
	private String passwordField = "com.lunchit.android.beta:id/aet_password";
	private String btnLogin = "com.lunchit.android.beta:id/btn_login";

	public AndroidLoginScreen(AndroidDriver driver) {
		super(driver);
	}
	
	
	public void checkScreenFormat() {
		sleep(3000);
		Boolean present=isElementPresent(By.id(emailField)) && isElementPresent(By.id(passwordField)) &&
				isElementPresent(By.id(btnLogin));
		assertThat("Format is not correct",present, is(true));

	}
	
	public void enterLogin(String login) {
		sendText(By.id(emailField),login);
	}
	
	public void enterPassword(String password) {
		sendText(By.id(passwordField), password);
	}
	
	public void submit() {
		clickBy(By.id(btnLogin));
		closeFireBase();
	}
	
	public void closeFireBase(){
		sleep(3000);
		String toggleFirebase = "com.lunchit.android.beta:id/ga_switch";
		if (isElementPresent(By.id(toggleFirebase))){
			clickBy(By.id(toggleFirebase));
			String closeFirebase = "com.lunchit.android.beta:id/close_happy";
			clickBy(By.id(closeFirebase));
			System.out.println("Enabling Firebase ....");
		}
	}
	
	
}
