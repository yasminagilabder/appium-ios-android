package acceptanceTests.steps.def;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.android.AndroidAddReceiptScreen;
import screens.android.AndroidLoginScreen;
import screens.android.AndroidGalleryScreen;
import screens.interfaces.AddReceiptScreen;
import screens.interfaces.GalleryScreen;
import screens.interfaces.LoginScreen;
import screens.ios.IOSLoginScreen;
import util.driver.ThreadLocalDriver;
import util.exception.UnknownButtonException;
import util.exception.UnknownFieldException;
import util.exception.UnknownScreenException;

public class BaseSteps {
	private static final String LOGGING = "login";
	private static final String PASSWORD = "password";
	private static final String ADD_RECEIPT = "addreceipt";
	private static final String GALLERY = "gallery";
	private static final String VERIFY = "verifyreceipt";
	private static final String UNKNOWN_SCREEN = "Unknown screen!!!";
	private static final String UNKNOWN_FIELD = "Unknown field!!!";
	private static final String UNKNOWN_BUTTON = "Unknown button!!!";
	
	
	
	LoginScreen loginScreen;
	AddReceiptScreen addReceiptScreen;
	GalleryScreen galleryScreen;
	
	public BaseSteps() {
		AppiumDriver appiumDriver = ThreadLocalDriver.getTLDriver();
		if (appiumDriver instanceof AndroidDriver) {
			loginScreen = new AndroidLoginScreen((AndroidDriver) appiumDriver);
			addReceiptScreen = new AndroidAddReceiptScreen((AndroidDriver) appiumDriver);
			galleryScreen= new AndroidGalleryScreen((AndroidDriver) appiumDriver);
		} else {
			loginScreen = new IOSLoginScreen((IOSDriver) appiumDriver);
		}
	}
	
	/*@After()
	public void afterScenario(Scenario scenario) {
		
		AppiumDriver appiumDriver = ThreadLocalDriver.getTLDriver();
		appiumDriver.closeApp();
	}*/
	
	@Before()
	public void beforeScenario(Scenario scenario) {
		
		AppiumDriver appiumDriver = ThreadLocalDriver.getTLDriver();
		appiumDriver.launchApp();
	}
	
	@Given("^I am in (.*) Screen$")
	public void iAmOnScreen(String screen) throws Exception {
		switch (screen.toLowerCase()) {
			case LOGGING:
				loginScreen.checkScreenFormat();
				break;
			case ADD_RECEIPT:
				addReceiptScreen.checkScreenFormat();
				break;
			case GALLERY:
				galleryScreen.checkScreenFormat();
				break;
			default:
				throw new UnknownScreenException(UNKNOWN_SCREEN);
		}
	}
	
	
	@Given("^I enter (.*) in field (.*)$")
	public void i_enter_value_in_field(String value, String field) throws Exception {
		switch (field.trim().toLowerCase()) {
			case LOGGING:
				loginScreen.enterLogin(value);
				break;
			case PASSWORD:
				loginScreen.enterPassword(value);
				break;
			default:
				throw new UnknownFieldException(UNKNOWN_FIELD);
		}
	}
	
	@When("^I click (.*) button$")
	public void i_click_login_button(String value) throws Throwable {
		switch (value.trim().toLowerCase()) {
			case LOGGING:
				loginScreen.submit();
				break;
			case ADD_RECEIPT:
				addReceiptScreen.submit();
				break;
			case GALLERY:
				galleryScreen.submit();
				break;
			case VERIFY:
				galleryScreen.verify();
				break;
			default:
				throw new UnknownButtonException(UNKNOWN_BUTTON);
		}
	}
	
}
