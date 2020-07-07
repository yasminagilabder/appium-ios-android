package acceptanceTests.steps.def;

import acceptanceTests.exception.UnknownButtonException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import screens.platform.android.AndroidDetailView;
import screens.interfaces.DetailView;
import screens.platform.IOSDetailView;
import util.driver.ThreadLocalDriver;

import static acceptanceTests.constants.common.Constants.*;
import static acceptanceTests.constants.view.UserView.*;


public class DetailViewSteps {

     AppiumDriver appiumDriver;
     DetailView detailView;

    public DetailViewSteps() {
        appiumDriver = ThreadLocalDriver.getTLDriver();
        if (appiumDriver instanceof AndroidDriver) {
            detailView = new AndroidDetailView(appiumDriver);

        } else detailView = new IOSDetailView(appiumDriver);
    }

    @Then("^I will see the detailView for user with first name (.*) and last name (.*)$")
    public void detailView(String name, String lastName) {
        detailView.checkScreenFormat(name, lastName);
    }


}
