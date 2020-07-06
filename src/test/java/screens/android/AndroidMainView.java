package screens.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.MainView;

public class AndroidMainView extends BaseScreen implements MainView {


    public AndroidMainView(AppiumDriver driver) {
        super(driver);
    }

    public void checkScreenFormat() {
        sleep(5000);
    }

    @Override
    public void selectUser(String name, String last) {
        String completeName="\""+last+", "+name+"\"";
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text="+completeName+"]"));
    }

}
