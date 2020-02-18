package screens.android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import screens.common.BaseScreen;
import screens.interfaces.EditReceiptScreen;

import static org.hamcrest.MatcherAssert.assertThat;

public class AndroidEditReceiptScreen extends BaseScreen implements EditReceiptScreen {
	
	
	private String amountValue = "com.lunchit.android.beta:id/amountValue";
	private String dateValue = "com.lunchit.android.beta:id/dateValue";
	private String editButton = "com.lunchit.android.beta:id/editButton";
	private String showReceiptButton = "com.lunchit.android.beta:id/showReceiptButton";
	private String deleteReceiptButton = "com.lunchit.android.beta:id/deleteButton";
	private String confirmDeleteReceiptButton = "com.lunchit.android.beta:id/removeReceipt";
	private String navigateUpButton = "Navigate up";
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
		sendText(By.id(amountValue), amount + "00");
		System.out.println("Receipt updated with correct amount....");
	}
	
	@Override
	public void viewReceipt() {
		waitAndClick(By.id(showReceiptButton));
		System.out.println("Showing receipt....");
		sleep(10000);
		waitByAccessibility(navigateUpButton).click();
	}
	
	public void swipingVertical()  {
		sleep(8000);
		//Get the size of screen.
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		
		//Find swipe start and end point from screen's with and height.
		//Find starty point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		//Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		//Find horizontal point where you wants to swipe. It is in middle of screen width.
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		
		//Swipe from Bottom to Top.
		new TouchAction(driver).press(PointOption.point(new Point(startx, starty))).moveTo(PointOption.point(new Point(starty, endy))).release().perform();
		//Swipe from Top to Bottom.
		
	}
	public void clickSideMenu() {
		sleep(3000);
		waitAndClick(By.xpath(sideMenu));
		sleep(2000);
		System.out.println("Clicking side menu....");
		try {
			waitAndClick(By.id(logOut));
			System.out.println("Logging out....");
			
		} catch (Exception e) {
			swipingVertical();
			e.printStackTrace();
		}
		
	}
}
