package acceptanceTests.steps.def;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.*;
import util.ThreadLocalDriver;
import util.exception.UnknownButtonException;
import util.exception.UnknownFieldException;
import util.exception.UnknownScreenException;

public class BaseSteps {
	private static final String LOGING = "login";
	private static final String PASSWORD = "password";
	private static final String ADD_RECEIPT = "addreceipt";
	private static final String UNKNOWN_SCREEN = "Unknown screen!!!";
	private static final String UNKNOWN_FIELD = "Unknown field!!!";
	private static final String UNKNOWN_BUTTON = "Unknown button!!!";
	
	
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
			case LOGING:
				loginScreen.checkLoginScreenFormat();
				break;
			case ADD_RECEIPT:
				addReceiptScreen.checkScreenFormat();
				break;
			default:
				throw new UnknownScreenException(UNKNOWN_SCREEN);
		}
	}
	
	
	@Given("^I enter (.*) in field (.*)$")
	public void i_enter_value_in_field(String value, String field) throws Exception {
		switch (field.trim().toLowerCase()) {
			case LOGING:
				loginScreen.enterLogin(value);
				break;
			case PASSWORD:
				loginScreen.enterPassword(value);
				break;
			default:
				throw new UnknownFieldException("UNKNOWN_FIELD");
		}
	}
	
	@When("^I click (.*) button$")
	public void i_click_login_button(String value) throws Throwable {
		switch (value.trim().toLowerCase()) {
			case LOGING:
				loginScreen.submit();
				break;
			case ADD_RECEIPT:
				addReceiptScreen.submit();
				break;
			default:
				throw new UnknownButtonException(UNKNOWN_BUTTON);
		}
	}
	
}
