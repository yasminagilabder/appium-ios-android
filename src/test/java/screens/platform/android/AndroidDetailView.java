package screens.platform.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import screens.common.Actions;
import screens.interfaces.DetailView;


public class AndroidDetailView extends Actions implements DetailView {

    public AndroidDetailView(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void checkScreenFormat(String name, String lastName) {
        sleep(500);
        String title=waitAndFindElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")).getText();
        assertEquals(title,name+" "+lastName );
    }

    public void edit(){
        click(By.id("com.xamarin.acquaintnative:id/acquaintanceEditButton"));
    }
    public void delete(){
        click(By.id("com.xamarin.acquaintnative:id/acquaintanceDeleteButton"));
    }
    public void back(){ sleep(500);waitByAccessibility("Navigate up").click();}


}
