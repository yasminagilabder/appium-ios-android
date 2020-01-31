package acceptanceTests.steps.def;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.*;
import util.ThreadLocalDriver;

public class BaseSteps {
	
	LoginScreen loginScreen;
	AddReceiptScreen addReceiptScreen;
	
	public BaseSteps() {
		AppiumDriver appiumDriver = ThreadLocalDriver.getTLDriver();
		if (appiumDriver instanceof AndroidDriver) {
			loginScreen = new AndroidLoginScreen((AndroidDriver) appiumDriver);
			addReceiptScreen = new AndroidAddReceiptScreen((AndroidDriver) appiumDriver);
		} else {
			loginScreen = new IOSLoginScreen((IOSDriver) appiumDriver);
		}
	}
	
	@Given("^I am in (.*) Screen$")
	public void iAmOnScreen(String screen) throws Exception {
		switch (screen.toLowerCase()) {
			case "login":
				loginScreen.checkLoginScreenFormat();
				break;
			case "addreceipt":
				addReceiptScreen.checkScreenFormat();
				break;
			default:
				throw new Exception("Unknown screen!!!");
		}
	}
	
	@Given("^I enter (.*) in field (.*)$")
	public void i_enter_value_in_field(String value, String field) throws Exception {
		switch (field.trim().toLowerCase()) {
			case "login":
				loginScreen.enterLogin(value);
				break;
			case "password":
				loginScreen.enterPassword(value);
				break;
			default:
				
				throw new Exception("Unknown screen!!!");
		}
	}
	
	@When("^I click (.*) button$")
	public void i_click_button(String value) throws Throwable {
		switch (value.toLowerCase()) {
			case "login":
				loginScreen.clickLogin();
				break;
			case "addreceipt":
				addReceiptScreen.clickButton(value);
				break;
			default:
				throw new Exception("Unknown button!!!");
		}
	}
	
}
