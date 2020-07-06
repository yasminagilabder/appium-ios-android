package screens.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.MainView;


public class IOSMainView extends BaseScreen implements MainView {

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
