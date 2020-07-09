package screens.platform.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import screens.common.Actions;
import screens.interfaces.MainView;

import java.util.logging.Logger;

import static acceptanceTests.constants.view.MainView.TITLE;


public class IOSMainView extends Actions implements MainView {

    private static final Logger LOGGER = Logger.getLogger("logger");
    private String settingElementXpath = "//XCUIElementTypeNavigationBar[@name=\"Acquaintances\"]/XCUIElementTypeButton[1]";
    private String addElementAcessibility = "Add";

    public IOSMainView(AppiumDriver driver) {
        super(driver);
    }

    public void checkScreenFormat() {
        sleep(5000);
        String title = waitAndFindElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Acquaintances\"]")).getText();
        assertEquals(title, TITLE);
        LOGGER.info("-[Title] is correct");
        isElementPresent(By.xpath(settingElementXpath));
        LOGGER.info("-[Setting] button is present");
        isElementPresent(By.id(addElementAcessibility));
        LOGGER.info("-[Add] button is present");
    }

    @Override
    public void selectUser(String name, String last) {
        sleep(2000);
        waitByAccessibility(last.trim() + ", " + name.trim()).click();
        LOGGER.info("User: " + name + " " + last + " is selected");
    }

    @Override
    public void addUser() {
        click(By.id(addElementAcessibility));
        LOGGER.info("-[Add User] button is clicked");
    }

    @Override
    public void setSettings() {
        click(By.xpath(settingElementXpath));
        LOGGER.info("-[set Settings] button is clicked");

    }

}
