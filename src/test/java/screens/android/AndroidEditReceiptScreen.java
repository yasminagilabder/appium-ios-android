package screens.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.common.BaseScreen;
import screens.interfaces.EditReceiptScreen;
import screens.interfaces.UpdateReceiptScreen;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidEditReceiptScreen extends BaseScreen implements EditReceiptScreen {
	
	
	private String amountValue = "com.lunchit.android.beta:id/amountValue";
	private String dateValue = "com.lunchit.android.beta:id/dateValue";
	private String editButton="com.lunchit.android.beta:id/editButton";
	private String showReceiptButton="com.lunchit.android.beta:id/showReceiptButton";
	private String deleteReceiptButton="com.lunchit.android.beta:id/deleteButton";
	private String confirmDeleteReceiptButton="com.lunchit.android.beta:id/removeReceipt";
	private String navigateUpButton="Navigate up";
	private String sideMenu = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
	private String logOut = "com.lunchit.android.beta:id/btnLogout";
	
	public AndroidEditReceiptScreen(AndroidDriver driver) {
		super(driver);
	}
	
	public void checkScreenFormat() {
		sleep(5000);
		assertThat("Amount is not present", isElementPresent(By.id(amountValue)));
		assertThat("Date is not present", isElementPresent(By.id(dateValue)));
		assertThat("Show Receipt is not present", isElementPresent(By.id(showReceiptButton)));
	}
	
	public void submit() {
		waitAndClick(By.id(editButton));
		System.out.println("Save edited receipt...");
		
	}
	
	@Override
	public void deleteReceipt() {
		sleep(5000);
		waitAndClick(By.id(deleteReceiptButton));
		sleep(3000);
		waitAndClick(By.id(confirmDeleteReceiptButton));
		
	}
	
	public void updateAmount(String amount) {
		waitAndClick(By.id(amountValue));
		clearText(By.id(amountValue));
		sendText(By.id(amountValue),amount+"00");
		System.out.println("Receipt updated with correct amount....");
		
	}
	
	@Override
	public void viewReceipt() {
		waitAndClick(By.id(showReceiptButton));
		System.out.println("Showing receipt....");
		sleep(10000);
		waitAndClickbyAccessibility(navigateUpButton);
	}
	
	public void clickSideMenu() {
		sleep(3000);
		waitAndClick(By.xpath(sideMenu));
		sleep(2000);
		System.out.println("Clicking side menu....");
		waitAndClick(By.id(logOut));
		System.out.println("Logging out....");
	}
}
