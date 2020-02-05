package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.AllReceiptsScreen;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidAllReceiptsScreen  extends BaseScreen implements AllReceiptsScreen {
	
	private String title = "com.lunchit.android.beta:id/title";
	private String doneButton="com.lunchit.android.beta:id/done_button";
	private String currentMonth="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]";
	private String currentMonth2= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]";
	
	private String lastReceipt="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout";
	
	public AndroidAllReceiptsScreen(AndroidDriver driver) {
		super(driver);
	}
	
	@Override
	public void selectCurrentMonth() {
		sleep(3000);
		try{
			waitAndClick(By.xpath(currentMonth));
		}catch (Exception e){
			waitAndClick(By.xpath(currentMonth2));
		}
		
	}
	
	@Override
	public void selectLastReceipt() {
		sleep(3000);
		waitAndClick(By.xpath(lastReceipt));
	}
	
	@Override
	public void checkScreenFormat() {
		assertThat("Title  is not present", isElementPresent(By.id(title)));
	}
	
	@Override
	public void submit() {
		waitAndClick(By.id(doneButton));
	
	}
}
