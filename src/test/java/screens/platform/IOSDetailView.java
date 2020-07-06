package screens.platform;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import screens.common.Actions;
import screens.interfaces.DetailView;


public class IOSDetailView extends Actions implements DetailView {

    public IOSDetailView(AppiumDriver driver) {
        super(driver);
    }


    @Override
    public void checkScreenFormat(String name, String lastName) {
        sleep(500);
        String title=waitAndFindElement(By.className("XCUIElementTypeStaticText")).getText();
        assertEquals(title,name+" "+lastName );
    }

    public void edit(){
        click(By.id("Edit"));
    }
    public void delete(){
        click(By.id("Delete"));
    }
    public void back(){
        click(By.id("List"));
    }


}
