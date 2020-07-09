package acceptanceTests.steps.def;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import screens.interfaces.EditView;
import screens.platform.android.AndroidEditView;
import screens.platform.ios.IOSEditView;
import util.driver.ThreadLocalDriver;

import java.util.Map;


public class EditViewSteps {

    AppiumDriver appiumDriver;
    EditView editView;

    public EditViewSteps() {
        appiumDriver = ThreadLocalDriver.getTLDriver();
        if (appiumDriver instanceof AndroidDriver) {
            editView = new AndroidEditView(appiumDriver);

        } else editView = new IOSEditView(appiumDriver);
    }



    @Given("^I fill the following information:$")
    public void iFillTheFollowingInformation(Map<String, String> editFields) {
        for (Map.Entry<String, String> field : editFields.entrySet()) {
            switch (field.getKey()) {
                case "First":
                    editView.addName(field.getValue());
                    break;
                case "Last":
                    editView.addLast(field.getValue());
                    break;
            }

        }
    }
}
