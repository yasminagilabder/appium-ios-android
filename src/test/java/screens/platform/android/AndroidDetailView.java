package screens.platform.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.springframework.util.Assert;
import screens.common.Actions;
import screens.interfaces.DetailView;

import java.util.logging.Logger;


public class AndroidDetailView extends Actions implements DetailView {
    private static final Logger LOGGER = Logger.getLogger("logger");

    public AndroidDetailView(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void checkScreenFormat(String name, String lastName) {
        sleep(500);
        String title = waitAndFindElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")).getText();
        assertEquals(title, name + " " + lastName);

    }

    public void edit() {
        click(By.id("com.xamarin.acquaintnative:id/acquaintanceEditButton"));
    }

    public void delete() {
        click(By.id("com.xamarin.acquaintnative:id/acquaintanceDeleteButton"));
    }

    public void back() {
        sleep(500);
        waitByAccessibility("Navigate up").click();
    }

    @Override
    public void checkModalScreen() {
        sleep(500);
        String title = waitAndFindElement(By.id("android:id/alertTitle")).getText();
        assertEquals(title, "Delete?");
        String question = waitAndFindElement(By.id("android:id/message")).getText();
        Assert.hasText(question, "Are you sure you want to delete");
        LOGGER.info("-[checkModalScreen] is ok");
    }


    @Override
    public void confirmModalScreen(Boolean confirm) {
        if (confirm.equals(Boolean.TRUE)) {
            waitAndFindElement(By.id("android:id/button1")).click();
        } else {
            waitAndFindElement(By.id("android:id/button2")).click();
        }
    }
}



