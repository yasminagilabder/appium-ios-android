package screens.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import screens.common.BaseScreen;
import screens.interfaces.EditReceiptScreen;

import java.time.Duration;
import java.util.HashMap;

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
	private String recommend = "com.lunchit.android.beta:id/btnRecommend";
	private String settings = "com.lunchit.android.beta:id/btnSettings";
	private String dataProtection = "com.lunchit.android.beta:id/btnDataProtection";
	private String iPrint = "com.lunchit.android.beta:id/btnImprint";
	private String menuLayout = "com.lunchit.android.beta:id/menuLayout";
	
	
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
	
	public void swipingVertical() {
		sleep(8000);
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		WebElement containerElement = driver.findElementById(menuLayout);
		
		new TouchAction(driver)
				.press(PointOption.point(10, starty))
				.moveTo(PointOption.point(10, endy))
				.release()
				.perform();
	}
	
	public void swipingVertical2() {
		
		while (!isElementPresent(By.id(iPrint))) {
			//sleep(2000);
			WebElement we = driver.findElementById(settings);
			Point p1 = we.getLocation();
			int offset = 10;
			System.out.println("startX = " + p1.getX() + " ,endy = " + p1.getY());
			new TouchAction(driver).press(PointOption.point(new Point(p1.getX(), p1.getY()))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(new Point(p1.getX(), p1.getY() + offset)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).release().perform();
			offset++;
			
		}
		System.out.println("point pressed");
		
	}
	
	MobileElement scrollToElementByTextContains(String text) {
		AndroidDriver adriver = ((AndroidDriver) driver);
		
		return (MobileElement) adriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
				".scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0));");
	}
	
	
	public void clickSideMenu() {
		sleep(3000);
		waitAndClick(By.xpath(sideMenu));
		sleep(2000);
		System.out.println("Clicking side menu....");
		//swipingVertical();
		scrollToElementByTextContains("Logout");
		waitAndClick(By.id(logOut));
		
	}
}
