package screens.platform.android;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.common.Actions;
import screens.interfaces.EditView;


public class AndroidEditView extends Actions implements EditView {

    public AndroidEditView(AppiumDriver driver) {
        super(driver);
    }

    private WebElement saveButton;
    private WebElement backButton;

    @Override
    public void checkScreenFormat() {
        sleep(5000);
        saveButton=waitAndFindElement(By.id("com.xamarin.acquaintnative:id/acquaintanceSaveButton"));
        backButton=waitByAccessibility("Navigate up");
    }

    @Override
    public void save() {
        sleep(500);
        saveButton.click();
    }

    public void back() {
        sleep(500);
        backButton.click();
    }

    public void addName(String first) {
        sendText(By.id("com.xamarin.acquaintnative:id/firstNameField"), first);
    }

    public void addLast(String last) {
        sendText(By.id("com.xamarin.acquaintnative:id/lastNameField"), last);
    }


}
