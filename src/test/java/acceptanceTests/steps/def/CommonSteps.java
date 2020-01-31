package acceptanceTests.steps.def;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.*;
import util.ThreadLocalDriver;

public class CommonSteps {
	
	LoginScreen loginScreen;
	AddReceiptScreen addReceiptScreen;
	
	public CommonSteps() {
		AppiumDriver appiumDriver=ThreadLocalDriver.getTLDriver();
		if (appiumDriver instanceof AndroidDriver){
			loginScreen = new AndroidLoginScreen((AndroidDriver)appiumDriver);
			 addReceiptScreen=new AndroidAddReceiptScreen((AndroidDriver)appiumDriver);
		}else{
			loginScreen = new IOSLoginScreen((IOSDriver)appiumDriver);
		}
	}
	
	@Given("^I am in (.*) Screen$")
	public void iAmOnScreen(String screen) throws Exception {
		if (screen.toLowerCase().equals("login")){
			loginScreen.checkLoginScreenFormat();
		}else if (screen.toLowerCase().equals("addreceipt")) {
			addReceiptScreen.checkScreenFormat();
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
	public void i_click_login_button(String value) throws Exception {
		if (value.toLowerCase().equals("login")) {
			loginScreen.clickLogin();
		}else if (value.toLowerCase().equals("addreceipt")) {
			addReceiptScreen.clickButton("addreceipt");
		}
		else{
			throw new Exception("Unknown button!!!");
		}
	}

	
}
