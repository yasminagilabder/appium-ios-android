package acceptanceTests.steps.def;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.android.*;
import screens.interfaces.*;
import screens.ios.*;
import util.driver.ThreadLocalDriver;
import util.exception.*;

public class BaseSteps {
    private static final String LOGGING = "login";
    private static final String PASSWORD = "password";
    private static final String UNKNOWN_SCREEN = "Unknown screen!!!";
    private static final String UNKNOWN_FIELD = "Unknown field!!!";
    private static final String UNKNOWN_BUTTON = "Unknown button!!!";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_RESET  = "\u001B[0m";

    AppiumDriver appiumDriver;
    LoginScreen loginScreen;



    public BaseSteps() {
         appiumDriver = ThreadLocalDriver.getTLDriver();
        if (appiumDriver instanceof AndroidDriver) {
            loginScreen = new AndroidLoginScreen((AndroidDriver) appiumDriver);

        } else {
            loginScreen = new IOSLoginScreen((IOSDriver) appiumDriver);
        }
    }

    @After()
    public void afterScenario(Scenario scenario) {

        System.out.println("Current Thread ID AfterTest: " + Thread.currentThread().getName());
       // ThreadLocalDriver.cleanupTLDriver();
    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        long id = Thread.currentThread().getId();
        appiumDriver = ThreadLocalDriver.getTLDriver();
        appiumDriver.launchApp();
        System.out.println(ANSI_RED + "**************** Starting tests in thread: " + id+ "-- Session details: "+appiumDriver.getSessionDetails().get("deviceName")+ ANSI_RESET);
    }


    @Given("^I am in (.*) Screen$")
    public void iAmOnScreen(String screen) throws Exception {
        switch (screen.toLowerCase()) {
            case LOGGING:
                loginScreen.checkScreenFormat();
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

            default:
                throw new UnknownButtonException(UNKNOWN_BUTTON);
        }
    }






}
