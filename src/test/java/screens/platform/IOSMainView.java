package screens.platform;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import screens.common.Actions;
import screens.interfaces.MainView;


public class IOSMainView extends Actions implements MainView {

    public IOSMainView(AppiumDriver driver) {
        super(driver);
    }

    public void checkScreenFormat() {
        sleep(5000);
    }

    @Override
    public void selectUser(String name, String last) {
        click(By.id(last.trim() + ", " + name.trim()));
    }

}
