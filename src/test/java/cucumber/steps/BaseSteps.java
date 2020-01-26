package cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import screens.LoginScreen;
import util.Context;
import util.ThreadLocalDriver;


public class BaseSteps  {
	
	
	protected LoginScreen loginScreen;
	
	public BaseSteps() {
		
		loginScreen =new LoginScreen(ThreadLocalDriver.getTLDriver());
		
	}
	
	@Then("I should next page")
	public void iShouldNextPage() {
	}
	
	
	@Given("I enter (.*) in field (.*)")
	public void iEnterLoginValueInFieldLogin(String value, String field) throws InterruptedException {
	
		loginScreen.enterLogin(value);
	}
	
	@AfterClass
	public void tearDown() {
		if (ThreadLocalDriver.getTLDriver()!=null){
			ThreadLocalDriver.getTLDriver().quit();
		}
	}
}
