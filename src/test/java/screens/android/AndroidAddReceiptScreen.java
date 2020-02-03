package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.AddReceiptScreen;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidAddReceiptScreen extends BaseScreen implements AddReceiptScreen {
	
	private String addReceiptBackground = "com.lunchit.android.beta:id/background";
	private String currentMonth = "com.lunchit.android.beta:id/month";
	private String totalReceipt = "com.lunchit.android.beta:id/totalReceipt";
	private String totalMoney = "com.lunchit.android.beta:id/totalMoney";
	private String addReceiptButton = "com.lunchit.android.beta:id/addReceipt";
	private String closeHelp = "com.lunchit.android.beta:id/btn_close";
	
	public AndroidAddReceiptScreen(AndroidDriver driver) {
		super(driver);
	}
	
	public void checkScreenFormat() {
		sleep(5000);
		assertThat("Background image is not present", isElementPresent(By.id(addReceiptBackground)));
		assertThat("Current month is not present", isElementPresent(By.id(currentMonth)));
		assertThat("Total receipt  is not present", isElementPresent(By.id(totalReceipt)));
		assertThat("Total money  is not present", isElementPresent(By.id(totalMoney)));
	}
	
	public void submit() {
		sleep(3000);
		waitAndClick(By.id(addReceiptButton));
		System.out.println("Clicking add receipt....");
		waitAndClick(By.id(closeHelp));
		System.out.println("Closing help window....");
		
	}
	
}