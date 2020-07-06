package acceptanceTests.steps.def;

import acceptanceTests.exception.UnknownScreenException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjectModel.MainScreenPageObject;
import screens.android.*;
import screens.interfaces.MainView;
import screens.ios.*;
import util.driver.ThreadLocalDriver;


public class BaseSteps {
    private static final String MAIN = "main";
    private static final String UNKNOWN_SCREEN = "Unknown screen!!!";
    private static final String UNKNOWN_FIELD = "Unknown field!!!";
    private static final String UNKNOWN_BUTTON = "Unknown button!!!";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_RESET  = "\u001B[0m";
    MainScreenPageObject mainScreenPageObject;
    AppiumDriver appiumDriver;
    MainView mainView;

    public BaseSteps() {
         appiumDriver = ThreadLocalDriver.getTLDriver();
        if (appiumDriver instanceof AndroidDriver) {
            mainView = new AndroidMainView((AndroidDriver) appiumDriver);

        } else {
           mainView = new IOSMainView((IOSDriver) appiumDriver);
             //mainScreenPageObject=new MainScreenPageObject(appiumDriver);
        }
    }

    @After()
    public void afterScenario(Scenario scenario) {
        System.out.println("Current Thread ID AfterTest: " + Thread.currentThread().getName());

    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        long id = Thread.currentThread().getId();
        appiumDriver = ThreadLocalDriver.getTLDriver();
        appiumDriver.launchApp();
        System.out.println(ANSI_RED + "**************** Starting tests in thread: " + id+ "-- Session details: "+appiumDriver.getSessionDetails().get("deviceName")+ ANSI_RESET);
    }


    @Given("^I am in (.*) Screen$")
    public void iAmOnScreen(String screen)  {
        switch (screen.toLowerCase()) {
            case MAIN:
                mainView.checkScreenFormat();
                //mainScreenPageObject.checkScreenFormat();
                break;
            default:
                try {
                    throw new UnknownScreenException(UNKNOWN_SCREEN);
                } catch (UnknownScreenException e) {
                    e.printStackTrace();
                }
        }
    }

    @When("^I select user with first name (.*) and last name (.*)$")
    public void iSelectFirstNameAndLastName(String name, String last) {
      mainView.selectUser(name,last);
      // mainScreenPageObject.selectUser();
    }
}
