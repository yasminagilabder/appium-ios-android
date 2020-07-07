package acceptanceTests.steps.def;

import acceptanceTests.exception.UnknownButtonException;
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
import screens.platform.IOSDetailView;
import screens.platform.IOSMainView;
import screens.platform.android.AndroidDetailView;
import screens.platform.android.AndroidMainView;
import screens.interfaces.MainView;
import screens.interfaces.DetailView;
import util.driver.ThreadLocalDriver;

import static acceptanceTests.constants.common.Constants.*;
import static acceptanceTests.constants.view.DetailView.ADD;
import static acceptanceTests.constants.view.DetailView.SETTING;
import static acceptanceTests.constants.view.UserView.*;


public class BaseSteps {

    MainScreenPageObject mainScreenPageObject;
    AppiumDriver appiumDriver;
    MainView mainView;
    DetailView detailView;

    public BaseSteps() {
        appiumDriver = ThreadLocalDriver.getTLDriver();
        if (appiumDriver instanceof AndroidDriver) {
            mainView = new AndroidMainView(appiumDriver);
            detailView = new AndroidDetailView(appiumDriver);
        } else {
            mainView = new IOSMainView(appiumDriver);
            detailView = new IOSDetailView(appiumDriver);
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
        System.out.println(ANSI_RED + "**************** Starting tests in thread: " + id + "-- Session details: " + appiumDriver.getSessionDetails().get("deviceName") + ANSI_RESET);
    }


    @Given("^I am in (.*) Screen$")
    public void iAmOnScreen(String screen) {
        switch (screen.toLowerCase()) {
            case MAIN:
                mainView.checkScreenFormat();
                break;
            default:
                try {
                    throw new UnknownScreenException(UNKNOWN_SCREEN);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    @Given("^I click in (.*) button$")
    public void iClickInButton(String bottomName) {
        switch (bottomName.toLowerCase()) {
            case EDIT:
                detailView.edit();
                break;
            case DELETE:
                detailView.delete();
                break;
            case BACK:
                detailView.back();
                break;
            case ADD:
                mainView.addUser();
                break;
            case SETTING:
                mainView.setSettings();
                break;
            default:
                try {
                    throw new UnknownButtonException(UNKNOWN_BUTTON);
                } catch (UnknownButtonException e) {
                    e.printStackTrace();
                }
        }
    }

    @When("^I select user with first name (.*) and last name (.*)$")
    public void iSelectFirstNameAndLastName(String name, String last) {
        mainView.selectUser(name, last);
        // mainScreenPageObject.selectUser();
    }

}
