package acceptanceTests.steps.def;

import acceptanceTests.exception.UnknownButtonException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import screens.platform.android.AndroidDetailView;
import screens.interfaces.DetailView;
import screens.platform.IOSDetailView;
import util.driver.ThreadLocalDriver;

import static acceptanceTests.constants.Constants.*;


public class DetailViewSteps {

    AppiumDriver appiumDriver;
    DetailView detailView;

    public DetailViewSteps() {
        appiumDriver = ThreadLocalDriver.getTLDriver();
        if (appiumDriver instanceof AndroidDriver) {
            //    mainView = new AndroidLoginScreen((AndroidDriver) appiumDriver);
            detailView = new AndroidDetailView((AndroidDriver) appiumDriver);

        } else {
            detailView = new IOSDetailView((IOSDriver) appiumDriver);
        }
    }

    @Then("^I will see the detailView for user with first name (.*) and last name (.*)$")
    public void detailView(String name, String lastName) {
        detailView.checkScreenFormat(name, lastName);
    }

    @Given("^I click in (.*) button$")
    public void iClickInButton(String bottomName){
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
            default:
                try {
                    throw new UnknownButtonException(UNKNOWN_BUTTON);
                } catch (UnknownButtonException e) {
                    e.printStackTrace();
                }
        }
    }
}
