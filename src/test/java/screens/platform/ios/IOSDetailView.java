package screens.platform.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.springframework.util.Assert;
import screens.common.Actions;
import screens.interfaces.DetailView;

import java.util.logging.Logger;


public class IOSDetailView extends Actions implements DetailView {
    private static final Logger LOGGER = Logger.getLogger("logger");

    public IOSDetailView(AppiumDriver driver) {
        super(driver);
    }


    @Override
    public void checkScreenFormat(String name, String lastName) {
        sleep(500);
        String title = waitAndFindElement(By.className("XCUIElementTypeStaticText")).getText();
        assertEquals(title, name + " " + lastName);
    }

    public void edit() {
        click(By.id("Edit"));
    }

    public void delete() {
        click(By.id("Delete"));
    }

    public void back() {
        sleep(500);
        waitByAccessibility("List").click();
    }

    @Override
    public void checkModalScreen() {
        sleep(500);
        String title = waitAndFindElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Delete?\"]")).getText();
        assertEquals(title, "Delete?");
        LOGGER.info("-[checkModalScreen] is ok");

    }

    @Override
    public void confirmModalScreen(Boolean confirm) {
        sleep(800);

        if (confirm.equals(Boolean.TRUE)) {
            waitAndFindElement(By.xpath("//XCUIElementTypeButton[@name=\"Delete\"]")).click();
            System.out.println("delete clicked");
        } else {
            waitByAccessibility("Cancel").click();
            System.out.println("delete clicked");
        }
    }


}
