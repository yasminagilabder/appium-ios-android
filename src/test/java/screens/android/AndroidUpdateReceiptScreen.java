package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.common.BaseScreen;
import screens.interfaces.AddReceiptScreen;
import screens.interfaces.UpdateReceiptScreen;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidUpdateReceiptScreen extends BaseScreen implements UpdateReceiptScreen {
	
	
	private String amountValue = "com.lunchit.android.beta:id/amountValue";
	private String dateValue = "com.lunchit.android.beta:id/dateValue";
	private String legalTermsButton="com.lunchit.android.beta:id/legalSwitch";
	private String submitButton="com.lunchit.android.beta:id/submitButton";
	
	
	public AndroidUpdateReceiptScreen(AndroidDriver driver) {
		super(driver);
	}
	
	public void checkScreenFormat() {
		sleep(5000);
		assertThat("Amount is not present", isElementPresent(By.id(amountValue)));
		assertThat("Date is not present", isElementPresent(By.id(dateValue)));
	}
	
	public void submit() {
		waitAndClick(By.id(submitButton));
		System.out.println("Submit receipt...");
		
	}
	
	@Override
	public void updateAmount(String amount) {
		waitAndClick(By.id(amountValue));
		clearText(By.id(amountValue));
		sendText(By.id(amountValue),amount+"00");
		System.out.println("Receipt updated with correct amount....");
		driver.hideKeyboard();
		waitAndClick(By.id(legalTermsButton));
		System.out.println("Legal terms accepted...");
		
	}
	
	protected void scrolltill(){
	
	//	(AndroidDriver)driver..findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Logout\").instance(0))").click();
	
	}
}
