package screens.platform.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.common.Actions;
import screens.interfaces.DetailView;
import screens.interfaces.EditView;


public class IOSEditView extends Actions implements EditView {

    public IOSEditView(AppiumDriver driver) {
        super(driver);
    }


    @Override
    public void checkScreenFormat() {
        waitVisibility(new MobileBy.ByAccessibilityId("AcquaintanceEditView"));
    }

    @Override
    public void save() {sleep(500);waitByAccessibility("Save").click();}

    @Override
    public void addName(String name) {
       WebElement element= waitByAccessibility("_FirstNameField");
        element.click();
        element.sendKeys(name);
  }

    @Override
    public void addLast(String last) {
        sleep(200);
        WebElement element= waitByAccessibility("_LastNameField");
        element.click();
        element.sendKeys(last);

    }

    public void back(){ sleep(500);waitByAccessibility("List").click();}


}
