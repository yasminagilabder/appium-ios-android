package acceptanceTests.steps.def;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.AndroidLoginScreen;
import screens.IOSLoginScreen;
import screens.LoginScreen;
import util.ThreadLocalDriver;

public class LoginSteps {
	
	LoginScreen loginScreen;
	
	
	
	public LoginSteps() {
		AppiumDriver appiumDriver=ThreadLocalDriver.getTLDriver();
		if (appiumDriver instanceof AndroidDriver){
			loginScreen = new AndroidLoginScreen((AndroidDriver)appiumDriver);
		}else{
			loginScreen = new IOSLoginScreen((IOSDriver)appiumDriver);
		}
		
	}
	
	@Given("^I am in (.*) Screen$")
	public void iAmOnScreen(String screen) throws Exception {
		if (screen.toLowerCase().equals("login")){
			loginScreen.checkLoginScreenTitle();
		}else {
			throw new Exception("Unknown screen!!!");
		}
	}
	
	@Given("^I enter (.*) in field (.*)$")
	public void i_enter_value_in_field(String value, String field) throws Exception {
		if (field.toLowerCase().equals("login")) {
			loginScreen.enterLogin(value);
		} else {
			if (field.toLowerCase().equals("password")) {
				loginScreen.enterPassword(value);
			} else {
				throw new Exception("Unknown screen!!!");
			}
		}
	}
	
	@When("^I click (.*) button$")
	public void i_click_login_button(String value) throws Throwable {
		if (value.toLowerCase().equals("login")) {
			loginScreen.clickLogin();
		} else{
			throw new Exception("Unknown button!!!");
		}
	}
	
}
