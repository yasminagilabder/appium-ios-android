package cucumber.steps;

import Test.BaseTestAndroid;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import screens.LoginScreen;

public class BaseSteps extends BaseTestAndroid {
	protected AndroidDriver<MobileElement> driver;
	protected WebDriverWait wait;
	protected LoginScreen loginScreen = null;
	//@Parameters({"deviceName"})
	protected void setupCucumber () {
		System.out.println("Cucumber Base Test Before-login-test-cucumber");
		loginScreen = new LoginScreen(driver);
	}
	@Then("I should next page")
	public void iShouldNextPage() {
	}
	
	
	@Given("I enter (.*) in field (.*)")
	public void iEnterLoginValueInFieldLogin(String value, String field) {
		loginScreen.enterLogin(value);
	}
}
