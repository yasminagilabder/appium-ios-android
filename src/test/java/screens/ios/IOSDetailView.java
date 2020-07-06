package screens.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.DetailView;
import screens.interfaces.MainView;


public class IOSDetailView extends BaseScreen implements DetailView {

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
