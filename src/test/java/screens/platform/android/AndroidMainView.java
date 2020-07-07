package screens.platform.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import screens.common.Actions;
import screens.interfaces.MainView;

import java.util.logging.Logger;

import static acceptanceTests.constants.view.MainView.TITLE;

public class AndroidMainView extends Actions implements MainView {

    String titleElementXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView";
    String settingElementId = "com.xamarin.acquaintnative:id/settingsButton";
    String addElementId = "com.xamarin.acquaintnative:id/acquaintanceListFloatingActionButton";
    private static final Logger LOGGER = Logger.getLogger("logger");


    public AndroidMainView(AppiumDriver driver) {
        super(driver);
    }

    public void checkScreenFormat() {
        sleep(5000);
        String title = waitAndFindElement(By.xpath(titleElementXpath)).getText();
        assertEquals(title, TITLE);
        LOGGER.info("-[Title] is correct");
        isElementPresent(By.id(settingElementId));
        LOGGER.info("-[Setting] button is present");
        isElementPresent(By.id(addElementId));
        LOGGER.info("-[Add] button is present");
    }

    @Override
    public void selectUser(String name, String last) {
        String completeName = "\"" + last + ", " + name + "\"";
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text=" + completeName + "]"));
        LOGGER.info("User: "+name+" "+last+ " is selected");
    }

    @Override
    public void addUser() {
        click(By.id(addElementId));
        LOGGER.info("-[Add User] button is clicked");
    }

    @Override
    public void setSettings() {
        click(By.id(settingElementId));
        LOGGER.info("-[set Settings] button is clicked");

    }

}
